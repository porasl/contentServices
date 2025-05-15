package com.porasl.contentservices.consumer;


import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.porasl.contentservices.domain.ConfigInfo;
import com.porasl.contentservices.service.ConfigService;
import com.porasl.contentservices.service.FFMPGService;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;

public class Transcoder{
	
  private String inputFilename;
  
  @Autowired
  private ConfigService configService;
  
  @Autowired
  private FFMPGService ffmpgService;
  
  private static Logger logger = Logger.getLogger(Transcoder.class.getName());
  
   public Transcoder(String inputFilename) {
	   this.inputFilename = inputFilename;
   }

	public void transcode() {
		try {// run ffmpeg to generate HLS fragments
			FFmpeg ffmpeg = new FFmpeg((String) getConfigInfoMap().get("ffmpeg"));
			FFprobe ffprobe = new FFprobe((String) getConfigInfoMap().get("ffprobe"));
			String output = String.format("%s%sstream.m3u8", getHlsOutputFolder(inputFilename), File.separator);
			FFmpegBuilder builder = new FFmpegBuilder().setInput(this.getInputFilename()).overrideOutputFiles(true)
					.setFormat("mp4").addOutput(output).setVideoCodec("libx264").setVideoResolution(1280, 720)
					.disableSubtitle().setAudioChannels(1).setAudioCodec("aac").setAudioSampleRate(48_000) // at 48KHz
					.setVideoBitRate(762800).setVideoFrameRate(30, 1).setStrict(FFmpegBuilder.Strict.STRICT)
					.setFormat("hls").addExtraArgs("-hls_wrap", "0", "-hls_time", "10", "-hls_list_size", "0").done();

			FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
			executor.createJob(builder).run();
			executor.createTwoPassJob(builder).run();
			
			//Update the imag transcoder
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
  
  public boolean  genSmallIcon() throws Exception {
	  ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	  ffmpgService = (FFMPGService) context.getBean("ffmpgService");
	  return ffmpgService.convetorAnimation(getInputFilename(),getHlsOutputFolder(this.getInputFilename()), (String) getConfigInfoMap().get("ffmpeg"));
  }
  
  
	public HashMap getConfigInfoMap() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		configService = (ConfigService) context.getBean("configService");
		List<ConfigInfo> configInfos = configService.getConfigInfos();
		HashMap configInfoMap = new HashMap();
		configInfos.stream().forEach(configInfo -> {
			configInfoMap.put(configInfo.getConfigName(), configInfo.getConfigValue());
		});
		return configInfoMap;
	}
  
  
   public String getInputFilename() {
	return inputFilename;
   }

   public void setInputFilename(String inputFilename) {
	this.inputFilename = inputFilename;
   }


   public String getHlsOutputFolder(String fileString) {
	   int index = fileString.length()-1;
	   for(int i = fileString.length()-1; i > 1; i--) {
		   if (fileString.charAt(i) == "/".charAt(0)) {
			   index = i;
			   break;
		   }
	   }
			   
	return fileString.substring(0, index);
   }
}
