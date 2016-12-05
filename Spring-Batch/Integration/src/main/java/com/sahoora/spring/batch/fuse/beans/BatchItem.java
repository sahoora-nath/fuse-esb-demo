package com.sahoora.spring.batch.fuse.beans;

import java.io.Serializable;
import java.util.Date;

public class BatchItem implements Serializable {

	private static final long serialVersionUID = -327681983236461711L;
	
	private Date lastUpdatedDate;
	private String itemStatusType;
	private String itemAmount;
	
	public Date getLastUpdatedDate() {
		return lastUpdatedDate;
	}
	public void setLastUpdatedDate(Date lastUpdatedDate) {
		this.lastUpdatedDate = lastUpdatedDate;
	}
	public String getItemStatusType() {
		return itemStatusType;
	}
	public void setItemStatusType(String itemStatusType) {
		this.itemStatusType = itemStatusType;
	}
	public String getItemAmount() {
		return itemAmount;
	}
	public void setItemAmount(String itemAmount) {
		this.itemAmount = itemAmount;
	}
}
