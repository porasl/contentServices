package com.porasl.contentservices.consumer;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.job.FFmpegJob;

public class VideoTranscoder {

    private final String inputFilename;

    public VideoTranscoder(String inputFilename) {
        this.inputFilename = inputFilename;
    }

    public String getInputFilename() {
        return inputFilename;
    }

    public String getHlsOutputFolder(String input) {
    	    String baseName = new File(input).getName();
        String outputDir = "/Users/hamidporasl/webdata/videos/" + baseName;
        new File(outputDir).mkdirs();
        return outputDir;
    }

    public void transcode() {
        try {
            FFmpeg ffmpeg = new FFmpeg("/opt/homebrew/bin/ffmpeg");
            FFprobe ffprobe = new FFprobe("/opt/homebrew/bin/ffprobe");

            convetorAnimation(getInputFilename(), 
            		getHlsOutputFolder(inputFilename), 
            		"/opt/homebrew/bin/ffmpeg");
            
            String output = String.format("%s%sstream.m3u8",
            		getHlsOutputFolder(inputFilename), File.separator);

            FFmpegBuilder builder = new FFmpegBuilder()
                    .setInput(this.getInputFilename())
                    .overrideOutputFiles(true)
                    .addOutput(output)
                    .setFormat("hls")
                    .setVideoCodec("libx264")
                    .setVideoResolution(1280, 720)
                    .disableSubtitle()
                    .setAudioChannels(1)
                    .setAudioCodec("aac")
                    .setAudioSampleRate(48_000)
                    .setVideoBitRate(762_800)
                    .setVideoFrameRate(30, 1)
                    .setStrict(FFmpegBuilder.Strict.STRICT)
                    .addExtraArgs(
                            "-vf", "drawtext=text='Inrik.com':fontcolor=white:fontsize=48:x=10:y=10",
                            "-hls_time", "10",
                            "-hls_list_size", "0"
                        )
                    .done();

            FFmpegExecutor executor = new FFmpegExecutor(ffmpeg, ffprobe);
            FFmpegJob job = executor.createJob(builder);
            job.run();

            System.out.println("FFmpeg job state: " + job.getState());
            System.out.println("Return code: " + job.getState());
           
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public boolean convetorAnimation(String inputFileAddress, String outputFolder, String ffmpegExe) {
		String name = outputFolder +"/videoImage";
		String paletteFile = name + ".png";
		String gifFile = name + ".gif";
		boolean isComplete = false;
		for (int i = 0; i < 5; i++) {
			try {
				// Generate palette
				Process p = new ProcessBuilder().command(ffmpegExe, "-v", "warning", "-ss",
						"2", "-t", "10", "-i", inputFileAddress, "-vf", "fps=5,scale=400:-1:flags=lanczos,palettegen",
						"-y", paletteFile, "-vn").start();
				isComplete = p.waitFor(10, TimeUnit.SECONDS);

				if (!isComplete) {
					System.out.println("Error generating palette");
				} else {
					p = new ProcessBuilder().command(ffmpegExe,
									"-v", "warning", "-ss", "2", "-t", "10", "-i", 
									inputFileAddress, "-i", paletteFile, "-lavfi",
									"fps=5,scale=650:-1:flags=lanczos [x]; [x][1:v] paletteuse",
									"-y", gifFile, "-vn").start();
					isComplete = p.waitFor(10, TimeUnit.SECONDS);
					if (isComplete) {
						System.out.println("Generate gif successfully");
						break;
					} else {
						System.out.println("Error generating gif");
					}
				}
			} catch (Exception e) {
				System.out.println("Error generating gif");
			}
		}
		return true;
	}
}
