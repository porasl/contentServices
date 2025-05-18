package com.porasl.contentservices.consumer;
import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFmpegExecutor;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.job.FFmpegJob;

import java.io.File;
import java.io.IOException;

public class VideoTranscoder {

    private final String inputFilename;

    public VideoTranscoder(String inputFilename) {
        this.inputFilename = inputFilename;
    }

    public String getInputFilename() {
        return inputFilename;
    }

    public String getHlsOutputFolder(String input) {
        String baseName = new File(input).getName().replaceFirst("[.][^.]+$", "");
        String outputDir = "/Users/hamidporasl/webdata/videos/" + baseName;
        new File(outputDir).mkdirs();
        return outputDir;
    }

    public void transcode() {
        try {
            // Use ffmpeg and ffprobe from system PATH
            FFmpeg ffmpeg = new FFmpeg("/opt/homebrew/bin/ffmpeg");
            FFprobe ffprobe = new FFprobe("/opt/homebrew/bin/ffprobe");

            String output = String.format("%s%sstream.m3u8", getHlsOutputFolder(inputFilename), File.separator);

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
                    .addExtraArgs("-hls_wrap", "0", "-hls_time", "10", "-hls_list_size", "0")
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
}
