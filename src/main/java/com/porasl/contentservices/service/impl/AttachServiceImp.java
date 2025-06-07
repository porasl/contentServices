package com.porasl.contentservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.porasl.contentservices.domain.Attachment;
import com.porasl.contentservices.repository.AttachRepository;
import com.porasl.contentservices.service.AttachService;

public class AttachServiceImp{
	
	 @Autowired
	  private AttachRepository attachRepo;
	 
   public Attachment save(Attachment attach) {
	   return attachRepo.save(attach);
   }
   
	public List<Attachment> getAttachments(String postid){
		return attachRepo.getAttachments(postid);
	}

}