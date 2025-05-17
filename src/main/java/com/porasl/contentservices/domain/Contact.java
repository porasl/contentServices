package com.porasl.contentservices.domain;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "contact")
public class Contact {
	
	@CreatedDate
    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime createdate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastmodified;


    @CreatedBy
    @Column(
            nullable = false,
            updatable = false
    )
    private Integer createdby;

    @LastModifiedBy
    @Column(insertable = false)
    private Integer lastmodifiedby;
    
	private long contactinfoid;
	
	@Column(nullable=true)
	private long principallid;
	
	@Column(nullable=true)
	private String contactemails;
	

	@Id
	@Column(name="contactinfoid")
	@TableGenerator(name="contactinfo", table="contact_Pktb", 
	pkColumnName="contactKey", pkColumnValue="contactvalue", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="contactinfo")
	public long getContactinfoid() {
		return contactinfoid;
	}
	
	public void setContactinfoid(long contactinfoid) {
		this.contactinfoid = contactinfoid;
	}

}
