package com.porasl.content.controller;

import java.nio.file.Path;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.core.io.Resource; 
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.web.bind.annotation.*; 
import org.springframework.web.multipart.MultipartFile; 
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.porasl.content.servie.StorageService;

import java.util.List; 
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/media")
public class MediaController {
    private final StorageService storageService;

    @Autowired
    public MediaController(StorageService storageService) {
        this.storageService = storageService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") List<FilePart> files) {
        storageService.store(files);
        return ResponseEntity.ok("File(s) uploaded successfully");
    }

    @GetMapping("/files")
    public ResponseEntity<Stream<Path>> listFiles() {
        return ResponseEntity.ok(storageService.loadAll());
    }

    @GetMapping("/file/{filename:.+}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String filename) {
        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok(file);
    }
}
