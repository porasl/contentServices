package com.porasl.contentservices.repository;

import com.porasl.contentservices.domain.Attachment;

public interface CustomPostRepository {
    void addAttachment(String postId, Attachment attachment);
    void removeAttachment(String postId, String filename);
}
