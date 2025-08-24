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
@Table(name = "favorite")
public class Favorite {
	
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
    
		private long favoriteid;
		
		@Column(nullable=true)
		private long userid;
		
		@Column(nullable=true)
		private long itemid;
		
		@Column(nullable=true)
		private String channelname;
		
		@Column(nullable=true)
		private boolean subscribed;
		
		@Column(nullable=true)
		private boolean liked;
		
		@Id
		@Column(name="favoriteid")
		@TableGenerator(name="favorite", table="favorite_Pktb", 
		pkColumnName="favoritekey", pkColumnValue="favoritevalue", allocationSize=1)
		@GeneratedValue(strategy=GenerationType.TABLE, generator="favorite")
		
		public long getFavoriteid() {
			return favoriteid;
		}
		
		// Explicit setters to satisfy JPA property access
		public void setCreatedate(LocalDateTime createdate) { this.createdate = createdate; }
		public void setLastmodified(LocalDateTime lastmodified) { this.lastmodified = lastmodified; }
		public void setCreatedby(Integer createdby) { this.createdby = createdby; }
		public void setLastmodifiedby(Integer lastmodifiedby) { this.lastmodifiedby = lastmodifiedby; }
		public void setFavoriteid(long favoriteid) { this.favoriteid = favoriteid; }
		public void setUserid(long userid) { this.userid = userid; }
		public void setItemid(long itemid) { this.itemid = itemid; }
		public void setChannelname(String channelname) { this.channelname = channelname; }
		public void setSubscribed(boolean subscribed) { this.subscribed = subscribed; }
		public void setLiked(boolean liked) { this.liked = liked; }
}
