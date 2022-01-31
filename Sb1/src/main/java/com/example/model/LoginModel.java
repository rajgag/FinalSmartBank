package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users1")
public class LoginModel {
	
	@Id
	private String username;
	private String userpassword;
	private String roles;
	private String corporateid;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	public String getCorporateid() {
		return corporateid;
	}
	public void setCorporateid(String corporateid) {
		this.corporateid = corporateid;
	}


}
