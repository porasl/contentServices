package com.porasl.content.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.porasl.content.servie.StorageService;

@RestController
@RequestMapping("/api/upload")
public class FileUploadController {

    private final StorageService storageService;

    @Autowired
    public FileUploadController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/video") 
    public ResponseEntity<String> uploadVideo(@RequestParam("file") MultipartFile file) { 
    	storageService.store(file); 
    return ResponseEntity.ok("Video uploaded successfully: " + file.getOriginalFilename()); }
}
