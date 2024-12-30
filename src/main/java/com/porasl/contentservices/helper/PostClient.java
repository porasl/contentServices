package com.porasl.contentservices.helper;

import java.util.List;

import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.domain.Comment;
import com.porasl.contentservices.domain.Post;
import com.porasl.contentservices.utils.Category;
import com.porasl.contentservices.utils.State;

public class PostClient{

    private List<Comment> comments;
    private List<Attachment> attachments;
    private Post post;
    private boolean sponsored;
    private long viewed;
    private long liked;
    private String createdDate;
    private boolean blocked;
    private long owner;
    private State state;
    private Category category;
    
    
    public Post getPost(){
      return post;
    }
    
    public void setPost(Post post){
        this.post = post;
    }

    public void setComments(List<Comment> comments){
        this.comments = comments;
    }
    
    public List<Comment> getComments(){
        return comments;
    }

    
    public List<Attachment> getAttachments(){
        return attachments;
    }

    public void setAttachments(List<Attachment> attachments){
        this.attachments = attachments;
    }

}
	
	
