package com.sahoo.camel.aries.example.domain.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Embeddable
public class StudentsBase implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Column(name="UPDATED_BY")
	private String updatedBy;
	
	@Temporal(TemporalType.DATE)
	@Column(name="CREATED_DATE")
	private Date createdDate;
	
	@Temporal(TemporalType.DATE)
	@Column(name="LAST_UPDATED_DATE")
	private Date lastUpdatedDate;

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}

	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	
	public void updateBeforePersist() {
		createdDate = new Date();
		lastUpdatedDate = new Date();
		updatedBy = "MQ";
	}
}
