package com.porasl.contentservices.content;

import com.porasl.contentservices.domain.AttachInfo;
import com.porasl.contentservices.domain.CommentInfo;
import com.porasl.contentservices.domain.PostInfo;


public class Post{

    private List<CommentInfo> comments;
    private List<AttachInfo> attachs;
    private PostInfo post;
    
    public PostInfo getPost(){
      return post;
    }
    
    public void setPost(PostInfo post){
        this.post = post;
    }

    public void setComments(List<CommentInfo> comments){
        this.comments = comments;
    }
    
    public List<CommentInfo> getComments(){
        return comments;
    }

    
    public List<AttachInfo> getAttachs(){
        return attachs;
    }

    public void setAttachInfos(List<AttachInfo> attachs){
        this.attachs = attachs;
    }

}