package com.porasl.contentservices.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.domain.Post;
import com.porasl.contentservices.repository.PostMongoRepository;

import java.util.Optional;

@Service
public class PostService {

	@Autowired
	private PostMongoRepository postRepository;

	public PostService(PostMongoRepository postRepository) {
		this.postRepository = postRepository;
	}

	public Optional<Post> addAttachment(Long postId, Attachment attachment) {
		postRepository.addAttachment(postId, attachment);
		return postRepository.findById(postId);
	}

	public Optional<Post> removeAttachment(Long postId, String filename) {
		postRepository.removeAttachment(postId, filename);
		return postRepository.findById(postId);
	}

	public Post savePost(Post post) {
		return postRepository.save(post);
	}

	public Optional<Post> getPostById(Long id) {
		return postRepository.findById(id);
	}

	public void deletePost(Long id) {
		postRepository.deleteById(id);
	}
}
