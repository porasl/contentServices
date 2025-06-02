package com.porasl.contentservices.repository;

import com.porasl.contentservices.domain.Attachment;

public interface CustomPostRepository {
    void addAttachment(Long postId, Attachment attachment);
    void removeAttachment(Long postId, String filename);
}
