package com.porasl.contentservices.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "contactinfo")
public class ContactInfo {
	private long contactinfoid;
	
	@Column(nullable=true)
	private long principallId;
	
	@Column(nullable=true)
	private String contactemails;
	

	@Id
	@Column(name="contactinfoid")
	@TableGenerator(name="contactinfo", table="contact_Pktb", 
	pkColumnName="contactKey", pkColumnValue="contactValue", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="contactinfo")
	public long getContactinfoid() {
		return contactinfoid;
	}
	
	public void setContactinfoid(long contactinfoid) {
		this.contactinfoid = contactinfoid;
	}

	public long getPrincipalId() {
		return principallId;
	}

	public void setPrincipalId(long principalId) {
		this.principallId = principallId;
	}

	public String getContactemails() {
		return contactemails;
	}

	public void setContactemails(String contactemails) {
		this.contactemails = contactemails;
	}



}
