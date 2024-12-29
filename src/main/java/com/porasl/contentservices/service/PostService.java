package com.porasl.contentservices.service;

import java.util.List;

import com.porasl.contentservices.domain.Post;

public interface PostService
{
   public Post createOrUpdate(Post postInfo);

   public List<Post> getPosts(String userId);
 
   public Post getPost(String postId); 
  
   public void deletePost(String postId);
}
