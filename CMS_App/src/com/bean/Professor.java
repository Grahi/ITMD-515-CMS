package com.bean;

import java.util.Date;
import java.util.List;

public class Professor {
	
	int profId;
	String profFirstName;
	String profLastName;	
	String profContact;
	String profEmail;
	List<Course> course;
	Date dateCreated;
	
	public Professor(int profId,String profFirstName, String profLastName, String profContact, String profEmail) {		
		this.profId = profId;
		this.profFirstName = profFirstName;
		this.profLastName = profLastName;
		this.profContact = profContact;
		this.profEmail = profEmail;
	}
	
	public Professor(String profFirstName, String profLastName, String profContact, String profEmail) {		
		this.profFirstName = profFirstName;
		this.profLastName = profLastName;
		this.profContact = profContact;
		this.profEmail = profEmail;
	}
	
	public Professor() {
		
	}

	public int getProfId() {
		return profId;
	}
	public void setProfId(int profId) {
		this.profId = profId;
	}
	public String getProfFirstName() {
		return profFirstName;
	}
	public void setProfFirstName(String profFirstName) {
		this.profFirstName = profFirstName;
	}
	public String getProfLastName() {
		return profLastName;
	}
	public void setProfLastName(String profLastName) {
		this.profLastName = profLastName;
	}
	
	public String getProfContact() {
		return profContact;
	}
	public void setProfContact(String profContact) {
		this.profContact = profContact;
	}
	public String getProfEmail() {
		return profEmail;
	}
	public void setProfEmail(String profEmail) {
		this.profEmail = profEmail;
	}
	
	public List<Course> getCourse() {
		return course;
	}
	public void setCourse(List<Course> course) {
		this.course = course;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	@Override
	public String toString() {
		return "Professor [profId=" + profId + ", profFirstName=" + profFirstName + ", profLastName=" + profLastName
				+ ", profContact=" + profContact + ", profEmail=" + profEmail + ", course=" + course + ", dateCreated="
				+ dateCreated + "]";
	}
	
	
	

}
