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


@Entity
//@Cacheable
//@org.hibernate.annotations.Cache(usage =  org.hibernate.annotations.CacheConcurrencyStrategy.READ_WRITE)
@Table(name = "useractivityinfo")
public class UserActivityInfo {

		private long useractivityinfoid;
		
		@Column(nullable=true)
		private String action;
		
		@Column(nullable=true)
		private long visitedChannelid;
		
		@Column(nullable=true)
		private long userid;
		
		@Column(nullable=true)
		@Temporal(TemporalType.TIMESTAMP)
		public Date creationDate;
		
		@Id
		@Column(name="useractivityinfoid")
		@TableGenerator(name="useractivityinfo", table="useractivity_Pktb", 
		pkColumnName="useractivityKey", pkColumnValue="useractivityValue", allocationSize=1)
		@GeneratedValue(strategy=GenerationType.TABLE, generator="useractivityinfo")
		
		public long getUseractivityinfoid() {
			return useractivityinfoid;
		}
		
		public void setUseractivityinfoid(long useractivityinfoid) {
			this.useractivityinfoid = useractivityinfoid;
		}
		
		public String getAction() {
			return action;
		}
		
		public void setAction(String action) {
			this.action = action;
		}
		
		public long getVisitedChannel() {
			return visitedChannelid;
		}
		
		public void setVisitedChannel(long visitedChannel) {
			this.visitedChannelid = visitedChannelid;
		}
		
		public long getUserid() {
			return userid;
		}

		public void setUserid(long userid) {
			this.userid = userid;
		}
		
		public Date getCreationDate() {
			return creationDate;
		}

		public void setCreateDate(Date creationDate) {
			this.creationDate = creationDate;
		}
}



