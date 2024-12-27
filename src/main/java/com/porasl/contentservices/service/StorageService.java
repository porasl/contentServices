package com.porasl.contentservices.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Objects;

import org.springframework.boot.autoconfigure.amqp.RabbitProperties.Stream;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.porasl.contentservices.config.StorageProperties;
import com.porasl.contentservices.exception.StorageException;

@Service
public class StorageService {
    private final Path rootDir;

    public StorageService(StorageProperties storageProperties) {
        this.rootDir = Paths.get(storageProperties.getLocation());
        try {
            Files.createDirectories(rootDir);
        } catch (Exception e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    public void store(List<FilePart>  files) {
        files.forEach(file -> {
            String filename = StringUtils.cleanPath(Objects.requireNonNull(file.filename()));
            if (filename.contains("..")) {
                throw new StorageException("Cannot store file with relative path outside current directory");
            }
            file.transferTo(Paths.get(rootDir.toString(), filename));
        });
    }
    
    public void store(FilePart  file) {
       String filename = StringUtils.cleanPath(Objects.requireNonNull(file.filename()));
            if (filename.contains("..")) {
                throw new StorageException("Cannot store file with relative path outside current directory");
            }
            file.transferTo(Paths.get(rootDir.toString(), filename));
        };
        
     public void store(MultipartFile file) { 
        	String filename = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename())); 
        	if (filename.contains("..")) { 
        		throw new StorageException("Cannot store file with relative path outside current directory"); } 
        	try { Files.copy(file.getInputStream(), 
        			this.rootDir.resolve(filename), StandardCopyOption.REPLACE_EXISTING); } 
        	catch (IOException e) { 
        		throw new StorageException("Failed to store file " + filename, e); } 
        	}

    public java.util.stream.Stream<Path> loadAll() {
        try {
            return Files.walk(rootDir, 1)
                       .filter(path -> !path.equals(rootDir))
                       .map(rootDir::relativize);
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }
    }

    public Path load(String filename) {
        return rootDir.resolve(filename);
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new StorageException("Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new StorageException("Could not read file: " + filename, e);
        }
    }

    public void deleteAll() {
        try {
            Files.deleteIfExists(rootDir);
        } catch (IOException e) {
            throw new StorageException("Failed to delete stored files", e);
        }
    }
}
