package com.porasl.contentservices.repository;

import java.util.List;

import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.domain.Post;

public interface CustomPostRepository {
    List<Post> searchPosts(String keyword);
    void addAttachment(String postId, Attachment attachment);
    void removeAttachment(String postId, String filename);
}
