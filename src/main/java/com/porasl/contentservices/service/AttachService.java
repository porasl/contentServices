package com.porasl.contentservices.service;

import java.util.List;

import com.porasl.contentservices.domain.AttachInfo;

public interface AttachService
{
   public AttachInfo createOrUpdate(AttachInfo attachInfo);
   
	public List<AttachInfo> getAttachments(long postinfoid);
	
	public void deleteAttachments(long postinfoid);

	public void deleteAttachment(long postinfoid, long iteminfoid);
	
	public void deleteAttachedItem(long iteminfoid);
}