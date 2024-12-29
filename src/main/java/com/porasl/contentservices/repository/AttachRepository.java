package com.porasl.contentservices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.porasl.contentservices.domain.Attachment;

public interface AttachRepository extends JpaRepository<Attachment, Integer> {

 @Query(value = "select attach from Attach attach inner join User u on attach.userid = u.id where attach.userid = :id")
  List<Attachment> findAllByUsetId(long userid);
 
 @Query(value = "select attach from Attach attach where attach.postid = :id")
 List<Attachment> getAttachments(long postid);


 boolean deleteAttachmentById(long attachid);


 boolean deleteAttachmentsByPostId(long postid);
  
}