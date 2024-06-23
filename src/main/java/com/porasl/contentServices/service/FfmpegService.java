package com.porasl.contentServices.service;

import net.bramp.ffmpeg.FFmpeg;
import net.bramp.ffmpeg.FFprobe;
import net.bramp.ffmpeg.builder.FFmpegBuilder;
import net.bramp.ffmpeg.job.FFmpegJob;
import net.bramp.ffmpeg.job.SinglePassFFmpegJob;
import net.bramp.ffmpeg.progress.ProgressListener;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

@Service
public class FfmpegService {

    private final FFmpeg ffmpeg;
    private final FFprobe ffprobe;

    public FfmpegService(@Value("${ffmpeg.path}") String ffmpegPath, @Value("${ffprobe.path}") String ffprobePath) throws IOException {
        this.ffmpeg = new FFmpeg(ffmpegPath);
        this.ffprobe = new FFprobe(ffprobePath);
    }

    public String transcode(String inputFilePath, String outputFilePath) {
        FFmpegBuilder builder = new FFmpegBuilder()
                .setInput(inputFilePath)
                .overrideOutputFiles(true)
                .addOutput(outputFilePath)
                .setFormat("hls")
                .addExtraArgs("-hls_time", "10")
                .done();

        FFmpegJob job = new SinglePassFFmpegJob(ffmpeg, builder, progress -> {
            System.out.println(String.format("[%.0f%%] status: %s", progress.speed * 100, progress.status));
        });

        job.run();
        return outputFilePath;
    }
}
