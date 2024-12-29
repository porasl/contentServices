package com.porasl.contentservices.service;

import java.util.List;

import com.porasl.contentservices.domain.Comment;

public interface CommentService {
   public Comment createOrUpdate(Comment commentInfo, long postinfoid);

   public List<Comment> getComments(long postinfoid);
 
   public Comment getComment(long comentinfoid, long postinfoid); 
  
   public void deleteComment(long comentinfoid, long postinfoid); 
   
   public void deleteComments(long postinfoid); 
}
