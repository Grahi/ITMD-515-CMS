package com.bean;


public class Login {
	private String userName;
	private String password;
	private String role;
	private int roleId;	
	
	public Login(){
		
	}
	
	public Login(String userName, String password) {		
		this.userName = userName;
		this.password = password;		
	}
	
	public Login(String userName, String password, String role, int roleId) {		
		this.userName = userName;
		this.password = password;
		this.role = role;
		this.roleId = roleId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public int getRoleId() {
		return roleId;
	}
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public String toString() {
		return "Login [userName=" + userName + ", password=" + password + ", role=" + role + ", roleId=" + roleId + "]";
	}	
	
	
	
}
