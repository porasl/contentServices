package com.porasl.contentservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.porasl.contentservices.domain.Attachment;

@Repository
public interface AttachRepository extends JpaRepository<Attachment, Long> {

    @Query("SELECT attach FROM Attachment attach WHERE attach.postid = :postid")
    List<Attachment> getAttachments(@Param("postid") Long postid);

    void deleteById(Long id);

    boolean deleteByPostid(Long postid);
}
