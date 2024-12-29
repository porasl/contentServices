package com.porasl.contentservices.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.porasl.contentservices.domain.Attach;
import com.porasl.contentservices.repository.AttachRepository;
import com.porasl.contentservices.service.AttachService;

public class AttachServiceImp implements AttachService{
	
	 @Autowired
	  private AttachRepository attachRepo;
	 
   public Attach save(Attach attach) {
	   return attachRepo.save(attach);
   }
   
	public List<Attach> getAttachments(long postid){
		attachRepo.getAttachments(postid);
	}
	
	public boolean deleteAttachmentById(long attachid){
		attachRepo.deleteAttachmentById(attachid);
	}

	@Override
	public boolean deleteAttachmentsByPostId(long postid) {
		attachRepo.deleteAttachmentsByPostId(postid);
		
	}

}