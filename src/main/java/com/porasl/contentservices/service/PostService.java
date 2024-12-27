package com.porasl.contentservices.service;

import java.util.List;

import com.porasl.contentservices.domain.PostInfo;

public interface PostService
{
   public PostInfo createOrUpdate(PostInfo postInfo);

   public List<PostInfo> getPosts(String userId);
 
   public PostInfo getPost(String postId); 
  
   public void deletePost(String postId);
}
