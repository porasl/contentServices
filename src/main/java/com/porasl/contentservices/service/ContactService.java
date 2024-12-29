package com.porasl.contentservices.service;

import com.porasl.contentservices.domain.Contact;

public interface ContactService
{
	public Contact createOrUpdate(Contact ContactInfo);
	public void addContactemail(long principalId, String newContactemail);
	public void removeContactemail(long principalId, String contactemail);
	public void removeAllContactemails(long principalId);
	public String getContactemails(long principalId);
	
}
