package com.bean;

import java.util.Date;
import java.util.List;

public class TA {

	int taId;
	String taFirstName;
	String taLastName;
	String taContact;	
	String taEmail;
	String taPassword;
	List<Course> cources;
	Date dateCreated;
		
	public TA() {
		
	}

	public TA(int taId, String taFirstName, String taLastName, String taContact, String taEmail) {		
		this.taId = taId;
		this.taFirstName = taFirstName;
		this.taLastName = taLastName;
		this.taContact = taContact;
		this.taEmail = taEmail;
	}
	
	public TA(int taId, String taFirstName, String taLastName, String taContact, String taEmail, Date dateCreated) {		
		this.taId = taId;
		this.taFirstName = taFirstName;
		this.taLastName = taLastName;
		this.taContact = taContact;
		this.taEmail = taEmail;
		this.dateCreated = dateCreated;
	}
		
	public List<Course> getCources() {
		return cources;
	}

	public void setCources(List<Course> cources) {
		this.cources = cources;
	}

	public int getTaId() {
		return taId;
	}
	public void setTaId(int taId) {
		this.taId = taId;
	}
	public String getTaFirstName() {
		return taFirstName;
	}
	public void setTaFirstName(String taFirstName) {
		this.taFirstName = taFirstName;
	}
	public String getTaLastName() {
		return taLastName;
	}
	public void setTaLastName(String taLastName) {
		this.taLastName = taLastName;
	}
	public String getTaContact() {
		return taContact;
	}
	public void setTaContact(String taContact) {
		this.taContact = taContact;
	}
	public String getTaEmail() {
		return taEmail;
	}
	public void setTaEmail(String taEmail) {
		this.taEmail = taEmail;
	}
	public String getTaPassword() {
		return taPassword;
	}
	public void setTaPassword(String taPassword) {
		this.taPassword = taPassword;
	}
	
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "TA [taId=" + taId + ", taFirstName=" + taFirstName + ", taLastName=" + taLastName + ", taContact="
				+ taContact + ", taEmail=" + taEmail + ", taPassword=" + taPassword + ", cources=" + cources
				+ ", dateCreated=" + dateCreated + "]";
	}	
	
}
