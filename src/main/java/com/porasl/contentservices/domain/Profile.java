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

		// Explicit getters to ensure compilation without Lombok processing
		public String getIconname() { return iconname; }
		public String getSchool() { return school; }
		public String getWorkplace() { return workplace; }
		public String getEducation() { return education; }
		public String getFreetextprofile() { return freetextprofile; }
		public String getFullname() { return fullname; }
		public String getTitle() { return title; }
		public String getCity() { return city; }
		public String getCountry() { return country; }
		public String getLocale() { return locale; }
		public String getPhonenumber() { return phonenumber; }
		public String getEmailaddress() { return emailaddress; }
		public String getSearechkeys() { return searechkeys; }
		public boolean isHideinpublicsearch() { return hideinpublicsearch; }
		public String getSubscribedids() { return subscribedids; }
		public String getHashtags() { return hashtags; }
		public String getTags() { return tags; }
		public long getUserid() { return userid; }
		public Date getCreationdate() { return creationdate; }
		public Date getModificationdate() { return modificationdate; }
		public Date getBirthdate() { return birthdate; }
		
		// Explicit setters to satisfy JPA property access
		public void setCreatedate(LocalDateTime createdate) { this.createdate = createdate; }
		public void setLastmodified(LocalDateTime lastmodified) { this.lastmodified = lastmodified; }
		public void setCreatedby(Integer createdby) { this.createdby = createdby; }
		public void setLastmodifiedby(Integer lastmodifiedby) { this.lastmodifiedby = lastmodifiedby; }
		public void setIconname(String iconname) { this.iconname = iconname; }
		public void setSchool(String school) { this.school = school; }
		public void setWorkplace(String workplace) { this.workplace = workplace; }
		public void setEducation(String education) { this.education = education; }
		public void setFreetextprofile(String freetextprofile) { this.freetextprofile = freetextprofile; }
		public void setFullname(String fullname) { this.fullname = fullname; }
		public void setTitle(String title) { this.title = title; }
		public void setCity(String city) { this.city = city; }
		public void setCountry(String country) { this.country = country; }
		public void setLocale(String locale) { this.locale = locale; }
		public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }
		public void setEmailaddress(String emailaddress) { this.emailaddress = emailaddress; }
		public void setSearechkeys(String searechkeys) { this.searechkeys = searechkeys; }
		public void setHideinpublicsearch(boolean hideinpublicsearch) { this.hideinpublicsearch = hideinpublicsearch; }
		public void setSubscribedids(String subscribedids) { this.subscribedids = subscribedids; }
		public void setHashtags(String hashtags) { this.hashtags = hashtags; }
		public void setTags(String tags) { this.tags = tags; }
		public void setUserid(long userid) { this.userid = userid; }
		public void setCreationdate(Date creationdate) { this.creationdate = creationdate; }
		public void setModificationdate(Date modificationdate) { this.modificationdate = modificationdate; }
		public void setBirthdate(Date birthdate) { this.birthdate = birthdate; }
}




