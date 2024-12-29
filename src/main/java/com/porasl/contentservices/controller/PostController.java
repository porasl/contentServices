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
    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
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
