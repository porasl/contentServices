package com.porasl.contentservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.domain.Post;
import com.porasl.contentservices.repository.PostRepository;

import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Optional<Post> addAttachment(String postId, Attachment attachment) {
        postRepository.addAttachment(postId, attachment);
        return postRepository.findById(postId);
    }

    public Optional<Post> removeAttachment(String postId, String filename) {
        postRepository.removeAttachment(postId, filename);
        return postRepository.findById(postId);
    }
}
