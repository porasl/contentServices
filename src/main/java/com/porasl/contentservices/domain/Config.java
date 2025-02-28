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
@Table(name = "config")
public class Config {
	
	@CreatedDate
    @Column(
            nullable = false,
            updatable = false
    )
    private LocalDateTime createDate;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime lastModified;


    @CreatedBy
    @Column(
            nullable = false,
            updatable = false
    )
    private Integer createdBy;

    @LastModifiedBy
    @Column(insertable = false)
    private Integer lastModifiedBy;
    
	private long configinfoid;
	
	@Column(nullable=true)
	private String configName;
	
	@Column(nullable=true)
	private String configValue;
	
	@Id
	@Column(name="configinfoid")
	@TableGenerator(name="configinfo", table="Config_Pktb", 
	pkColumnName="configKey", pkColumnValue="configValue", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="configinfo")
	
	public long getConfiginfoid() {
		return configinfoid;
	}
	
	public void setConfiginfoid(long configinfoid) {
		this.configinfoid = configinfoid;
	}
	
}
