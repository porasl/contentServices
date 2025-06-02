package com.porasl.contentservices.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.domain.Post;
import com.porasl.contentservices.service.PostService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

@Tag(name = "ContentController", description = "Endpoints for content Controller")
@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class ContentController {

    public final PostService postService;
    
    @Operation(summary = "Create Post")
    @PostMapping 
    public ResponseEntity<Post> createPost(
    		@Parameter(description = "Register request body") 
    		@RequestBody Post request) 
    { 
    	return ResponseEntity.ok(postService.savePost(request)); 
    	}
    
//    @Operation(summary = "Authenticate a user with token")
//    @PostMapping("/authenticateWithToken")
//    public ResponseEntity<AuthenticationResponse> authenticateWithToken(
//        HttpServletRequest request,
//        @RequestBody AuthenticationRequest authenticationRequest
//    ) throws IOException {
//      return ResponseEntity.ok(authservice.authenticateWithToken(request, authenticationRequest));
//    }
    
    @Operation(summary = "Get Post")
    @GetMapping("/{id}") 
    public ResponseEntity<Post> getPost( 
    		@Parameter(description = "Post Id")
    @PathVariable Long id) { 
    	return postService.getPostById(id) 
    			.map(ResponseEntity::ok) 
    			.orElse(ResponseEntity.notFound().build()); 
    	} 
    
    @Operation(summary = "Delete Post")
    @DeleteMapping("/{id}") 
    public ResponseEntity<Void> deletePost(
    		@Parameter(description = "Delete Post id") @PathVariable Long id) {
    	postService.deletePost(id); 
    	return ResponseEntity.noContent().build(); 
    	}

    
    @Operation(summary = "Add attachments to the Post")
    @PatchMapping("/{postId}/attachments/add")
    public ResponseEntity<Post> addAttachment(
    		@Parameter(description = "PostId") @PathVariable Long postId,
    		@Parameter(description = "Attachment") @RequestBody Attachment attachment) {
        return postService.addAttachment(postId, attachment)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PatchMapping("/{postId}/attachments/remove")
    public ResponseEntity<Post> removeAttachment(
    		@Parameter(description = "PostId") @PathVariable Long postId,
    		@Parameter(description = "filename") @RequestBody String filename) {
        return postService.removeAttachment(postId, filename)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
