package com.porasl.contentservices.domain;

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.TableGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author Porasl
 *
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "profile")
public class Profile {
	
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
    

		private long profileinfoid;
		
		@Column(nullable=true)
		private String iconname;
		
		@Column(nullable=true)
		private String school;
		
		@Column(nullable=true)
		private String workplace;
		
		@Column(nullable=true)
		private String education;
		
		@Column(nullable=true)
		private String freetextprofile;
		
		@Column(nullable=true)
		private String fullname;
		
		@Column(nullable=true)
		private String title;
		
		@Column(nullable=true)
		private String city;
		
		@Column(nullable=true)
		private String country;
		
		@Column(nullable=true)
		private String locale;
		
		@Column(nullable=true)
		private String phonenumber;
		
		@Column(nullable=true)
		private String emailaddress;
		
		@Column(nullable=true)
		private String searechkeys;
		
		@Column(nullable=true)
		private boolean hideinpublicsearch;

		@Column(nullable=true)
		private String subscribedids;
		
		@Column(nullable=true)
		private String hashtags;
		
		@Column(nullable=true)
		private String tags;
		
		@Column(nullable=true)
		private long userid;
		
		@Column(nullable=true)
		@Temporal(TemporalType.TIMESTAMP)
		public Date creationdate;
		
		@Column(nullable=true)
		@Temporal(TemporalType.TIMESTAMP)
		public Date modificationdate;
		
		@Column(nullable=true)
		@Temporal(TemporalType.TIMESTAMP)
		public Date birthdate;
		
		@Id
		@Column(name="profileinfoid")
		@TableGenerator(name="profileinfo", table="profile_Pktb", 
		pkColumnName="profilekey", pkColumnValue="profilevalue", allocationSize=1)
		@GeneratedValue(strategy=GenerationType.TABLE, generator="profileinfo")
		public long getProfileinfoid() {
			return profileinfoid;
		}
		
		public void setProfileinfoid(long profileinfoid) {
			this.profileinfoid = profileinfoid;
		}
}




