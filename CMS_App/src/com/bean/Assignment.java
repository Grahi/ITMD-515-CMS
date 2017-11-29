package com.bean;

import java.util.Date;

public class Assignment {
	int assignmentId;
	String assignmentText;
	int courseId;
	Date datePosted;
	Date dueDate;
		
	public Assignment(int assignmentId, String assignmentText, Date datePosted, Date dueDate) {		
		this.assignmentId = assignmentId;
		this.assignmentText = assignmentText;		
		this.datePosted = datePosted;
		this.dueDate = dueDate;
	}
	
	public int getAssignmentId() {
		return assignmentId;
	}
	public void setAssignmentId(int assignmentId) {
		this.assignmentId = assignmentId;
	}
	public String getAssignmentText() {
		return assignmentText;
	}
	public void setAssignmentText(String assignmentText) {
		this.assignmentText = assignmentText;
	}
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public Date getDatePosted() {
		return datePosted;
	}
	public void setDatePosted(Date datePosted) {
		this.datePosted = datePosted;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	
	@Override
	public String toString() {
		return "Assignment [assignmentId=" + assignmentId + ", assignmentText=" + assignmentText + ", courseId="
				+ courseId + ", datePosted=" + datePosted + ", dueDate=" + dueDate + "]";
	}
	
}
