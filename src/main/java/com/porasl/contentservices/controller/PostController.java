package com.porasl.contentservices.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.domain.Post;
import com.porasl.contentservices.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    @Autowired
    public PostService postService;
    
    @PostMapping 
    public ResponseEntity<Post> createPost(@RequestBody Post post) { 
    	return ResponseEntity.ok(postService.savePost(post)); 
    	}
    
    @GetMapping("/{id}") 
    public ResponseEntity<Post> getPost(@PathVariable String id) { 
    	return postService.getPostById(id) 
    			.map(ResponseEntity::ok) 
    			.orElse(ResponseEntity.notFound().build()); 
    	} 
    
    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> deletePost(@PathVariable String id) {
    	postService.deletePost(id); 
    	return ResponseEntity.noContent().build(); 
    	}

    @PatchMapping("/{postId}/attachments/add")
    public ResponseEntity<Post> addAttachment(
            @PathVariable String postId,
            @RequestBody Attachment attachment) {
        return postService.addAttachment(postId, attachment)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{postId}/attachments/remove")
    public ResponseEntity<Post> removeAttachment(
            @PathVariable String postId,
            @RequestBody String filename) {
        return postService.removeAttachment(postId, filename)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
