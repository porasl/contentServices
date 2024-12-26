package com.porasl.contentservices.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;


/**
 * @author Porasl
 *
 */
@Entity
//@Cacheable
//@org.hibernate.annotations.Cache(usage =  org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "profileinfo")
public class ProfileInfo {

		private long profileinfoid;
		
		@Column(nullable=true)
		private String iconName;
		
		@Column(nullable=true)
		private String school;
		
		@Column(nullable=true)
		private String workplace;
		
		@Column(nullable=true)
		private String education;
		
		@Column(nullable=true)
		private String freeTextProfile;
		
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
		private String searechKeys;
		
		@Column(nullable=true)
		private boolean hideInPublicsearch;

		@Column(nullable=true)
		private String subscribedIds;
		
		@Column(nullable=true)
		private String hashTags;
		
		@Column(nullable=true)
		private String tags;
		
		@Column(nullable=true)
		private long userid;
		
		@Column(nullable=true)
		@Temporal(TemporalType.TIMESTAMP)
		public Date creationDate;
		
		@Column(nullable=true)
		@Temporal(TemporalType.TIMESTAMP)
		public Date modificationDate;
		
		@Column(nullable=true)
		@Temporal(TemporalType.TIMESTAMP)
		public Date birthDate;
		
		@Id
		@Column(name="profileinfoid")
		@TableGenerator(name="profileinfo", table="profile_Pktb", 
		pkColumnName="profileKey", pkColumnValue="profileValue", allocationSize=1)
		@GeneratedValue(strategy=GenerationType.TABLE, generator="profileinfo")
		public long getProfileinfoid() {
			return profileinfoid;
		}
		
		public void setProfileinfoid(long profileinfoid) {
			this.profileinfoid = profileinfoid;
		}
		
		public String getSearechKeys() {
			return searechKeys;
		}
		
		public void setSearechKeys(String searechKeys) {
			this.searechKeys = searechKeys;
		}
		
		public String getCity() {
			return city;
		}
		
		public void setCity(String city) {
			this.city = city;
		}
		
		public String getCountry() {
			return country;
		}
		
		public void setCountry(String country) {
			this.country = country;
		}
		
		public String getLocale() {
			return locale;
		}
		
		public void setLocale(String locale) {
			this.locale = locale;
		}
		
		public String getSubscribedIds() {
			return subscribedIds;
		}
		
		public void setSubscribedIds(String subscribedIds) {
			this.subscribedIds = subscribedIds;
		}
		
		public String getFreeTextProfile() {
			return freeTextProfile;
		}

		public void setFreeTextProfile(String freeTextProfile) {
			this.freeTextProfile = freeTextProfile;
		}

		public String getFullname() {
			return fullname;
		}

		public void setFullname(String fullname) {
			this.fullname = fullname;
		}

		public String getTags() {
			return tags;
		}

		public void setTags(String tags) {
			this.tags = tags;
		}
		
		public String getHashTags() {
			return hashTags;
		}

		public void setHashTag(String hashTags) {
			this.hashTags = hashTags;
		}
		
		public long getUserid() {
			return userid;
		}

		public void setUserid(long userid) {
			this.userid = userid;
		}

		public String getIconName() {
			return iconName;
		}

		public void setIconName(String iconName) {
			this.iconName = iconName;
		}

		public String getSchool() {
			return school;
		}

		public void setSchool(String school) {
			this.school = school;
		}

		public String getWorkplace() {
			return workplace;
		}

		public void setWorkplace(String workplace) {
			this.workplace = workplace;
		}

		public String getEducation() {
			return education;
		}

		public void setEducation(String education) {
			this.education = education;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getPhonenumber() {
			return phonenumber;
		}

		public void setPhonenumber(String phonenumber) {
			this.phonenumber = phonenumber;
		}

		public String getEmailaddress() {
			return emailaddress;
		}

		public void setEmailaddress(String emailaddress) {
			this.emailaddress = emailaddress;
		}

		public Date getCreationDate() {
			return creationDate;
		}

		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}

		public void setHashTags(String hashTags) {
			this.hashTags = hashTags;
		}
		
		public Date getBirthDate() {
			return birthDate;
		}

		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}
		
		public boolean isHideInPublicsearch() {
			return hideInPublicsearch;
		}

		public void setHideInPublicsearch(boolean hideInPublicsearch) {
			this.hideInPublicsearch = hideInPublicsearch;
		}
		
		public Date getModificationDate() {
			return modificationDate;
		}

		public void setModificationDate(Date modificationDate) {
			this.modificationDate = modificationDate;
		}

}




