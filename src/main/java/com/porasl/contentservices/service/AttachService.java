package com.porasl.contentservices.service;

import java.util.List;

import com.porasl.contentservices.domain.Attach;

public interface AttachService
{
   public Attach save(Attach attach);
   
	public List<Attach> getAttachments(long postid);
	
	public boolean deleteAttachmentsByPostId(long postid);
	
	public boolean deleteAttachmentById(long itemid);
}