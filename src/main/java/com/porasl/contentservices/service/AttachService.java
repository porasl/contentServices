package com.porasl.contentservices.service;

import java.util.List;

import com.porasl.contentservices.domain.Attachment;

public interface AttachService
{
   public Attachment save(Attachment attach);
   
	public List<Attachment> getAttachments(long postid);
	
	public boolean deleteAttachmentsByPostId(long postid);
	
	public boolean deleteAttachmentById(long itemid);
}