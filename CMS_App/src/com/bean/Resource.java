package com.bean;

import java.util.Date;

public class Resource {
	int resourceId;
	String resourceName;
	String resourceType;
	int courseId;
	Date dateCreated;
	
		
	public Resource(int resourceId, String resourceName, String resourceType) {		
		this.resourceId = resourceId;
		this.resourceName = resourceName;
		this.resourceType = resourceType;		
	}
	
	public int getResourceId() {
		return resourceId;
	}
	public void setResourceId(int resourceId) {
		this.resourceId = resourceId;
	}
	public String getResourceName() {
		return resourceName;
	}
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	public String getResourceType() {
		return resourceType;
	}
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@Override
	public String toString() {
		return "Resource [resourceId=" + resourceId + ", resourceName=" + resourceName + ", resourceType="
				+ resourceType + ", courseId=" + courseId + ", dateCreated=" + dateCreated + "]";
	}
	
	
}
