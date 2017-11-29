package com.bean;

import java.util.Date;
import java.util.List;

public class Course {
	
	int courseId;
	String courseCode;
	String courseName;
	String location;
	String syllabus;	
	Date dateCreated;
	List<Resource> resourceList;
	List<Assignment> assignmentList;
	List<TA> taList;
	List<Schedule> scheduleList;
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseCode() {
		return courseCode;
	}
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}	
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getSyllabus() {
		return syllabus;
	}
	public void setSyllabus(String syllabus) {
		this.syllabus = syllabus;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public List<Resource> getResourceList() {
		return resourceList;
	}
	public void setResourceList(List<Resource> resourceList) {
		this.resourceList = resourceList;
	}
	public List<Assignment> getAssignmentList() {
		return assignmentList;
	}
	public void setAssignmentList(List<Assignment> assignmentList) {
		this.assignmentList = assignmentList;
	}
	public List<TA> getTaList() {
		return taList;
	}
	public void setTaList(List<TA> taList) {
		this.taList = taList;
	}
	public List<Schedule> getScheduleList() {
		return scheduleList;
	}
	public void setScheduleList(List<Schedule> scheduleList) {
		this.scheduleList = scheduleList;
	}
	
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseCode=" + courseCode + ", courseName=" + courseName
				+ ", location=" + location + ", syllabus=" + syllabus + ", dateCreated=" + dateCreated
				+ ", resourceList=" + resourceList + ", assignmentList=" + assignmentList + ", taList=" + taList
				+ ", scheduleList=" + scheduleList + "]";
	}
	
	
	
	

}
