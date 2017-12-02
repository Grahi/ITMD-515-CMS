package com.bean;

import java.util.Date;
import java.util.List;

public class Student {
	
	int studentId;
	String studentFirstName;
	String studentLastName;
	String studentContact;
	String studentEmail;
	List<Course> course;
	Date dateCreated;	
	
	public Student() {
		
	}

	public Student(String studentFirstName, String studentLastName, String studentContact, String studentEmail) {
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentContact = studentContact;
		this.studentEmail = studentEmail;
	}
	
	public Student(int studentId,String studentFirstName, String studentLastName, String studentContact, String studentEmail) {
		this.studentId = studentId;
		this.studentFirstName = studentFirstName;
		this.studentLastName = studentLastName;
		this.studentContact = studentContact;
		this.studentEmail = studentEmail;
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentFirstName() {
		return studentFirstName;
	}
	public void setStudentFirstName(String studentFirstName) {
		this.studentFirstName = studentFirstName;
	}
	public String getStudentLastName() {
		return studentLastName;
	}
	public void setStudentLastName(String studentLastName) {
		this.studentLastName = studentLastName;
	}
	public String getStudentContact() {
		return studentContact;
	}
	public void setStudentContact(String studentContact) {
		this.studentContact = studentContact;
	}
	public String getStudentEmail() {
		return studentEmail;
	}
	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentFirstName=" + studentFirstName + ", studentLastName="
				+ studentLastName + ", studentContact=" + studentContact + ", studentEmail=" + studentEmail
				+ ", course=" + course + ", dateCreated=" + dateCreated + "]";
	}	

}
