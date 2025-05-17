package com.porasl.contentservices.service;

import java.util.List;

import com.porasl.contentservices.domain.Attachment;

public interface AttachService
{
   public Attachment save(Attachment attach);
   
	public List<Attachment> getAttachments(Long postid);
	
	public boolean deleteAttachmentsByPostId(Long postid);
	
	public boolean deleteAttachmentById(Long itemid);
}