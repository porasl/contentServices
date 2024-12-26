package com.porasl.contentservices.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.porasl.contentservices.service.StorageService;

@RestController
@RequestMapping("/api/upload")
@Tag(name = "File Upload", description = "Endpoints for file uploading")
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/video")
    @Operation(summary = "Upload a video file", description = "Uploads a video file and saves it to the server")
    public ResponseEntity<String> uploadVideo(
            @Parameter(description = "The video file to be uploaded") @RequestParam("file") MultipartFile file) {
        storageService.store(file);
        return ResponseEntity.ok("Video uploaded successfully: " + file.getOriginalFilename());
    }
    
    @GetMapping("/info")
    @Operation(summary = "File list", description = "File list")
    public ResponseEntity<String> getContent(
            @Parameter(description = "The content name") @RequestParam("content") String contentName) {
        //storageService.store(file);
        return ResponseEntity.ok("Content Name: " + contentName);
    }
}
