package com.porasl.contentservices.service;

import java.util.List;

import com.porasl.contentservices.domain.CommentInfo;

public interface CommentService {
   public CommentInfo createOrUpdate(CommentInfo commentInfo, long postinfoid);

   public List<CommentInfo> getComments(long postinfoid);
 
   public CommentInfo getComment(long comentinfoid, long postinfoid); 
  
   public void deleteComment(long comentinfoid, long postinfoid); 
   
   public void deleteComments(long postinfoid); 
}
