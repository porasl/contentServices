package com.porasl.contentServices.controller;

import com.example.contentservice.service.FfmpegService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/api/ffmpeg")
public class FfmpegController {

    @Autowired
    private FfmpegService ffmpegService;

    @ApiOperation(value = "Transcode a video file to HLS format")
    @PostMapping("/transcode")
    public String transcode(@RequestParam("file") MultipartFile file) throws IOException {
        // Save the uploaded file to a temporary location
        Path tempDir = Files.createTempDirectory("");
        Path tempFile = tempDir.resolve(file.getOriginalFilename());
        file.transferTo(tempFile.toFile());

        // Define the output file path
        String outputFilePath = tempDir.resolve("output.m3u8").toString();

        // Call the FFmpeg service to transcode the file
        String result = ffmpegService.transcode(tempFile.toString(), outputFilePath);

        // Clean up the temporary input file
        Files.deleteIfExists(tempFile);

        return result;
    }
}
