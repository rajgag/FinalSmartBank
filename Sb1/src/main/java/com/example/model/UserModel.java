package com.example.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name="users") 
public class UserModel {

	private int corporateid;
	
	@NotEmpty(message = "*Required")
	@Size(max = 15,message="max 15 char only")
	@Id
	private String username;
	
	@NotEmpty(message = "*Required")
	private String password;
	
	@NotEmpty(message = "*Required")
	private String address;
	
	@NotEmpty(message = "*Required")
	private String dept;

	@Pattern(regexp = "^[0-9]{10}$" ,message = "Invalid Ph-No")
	private String phno;
	
	private boolean active;
	
	private String status;
	
	private String passchanged;
	
	private String role;
	

	public int getCorporateid() {
		return corporateid;
	}

	public void setCorporateid(int corporateid) {
		this.corporateid = corporateid;
	}

	public String getUseradd() {
		return address;
	}

	public void setUseradd(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
	}

	public String getPasschanged() {
		return passchanged;
	}

	public void setPasschanged(String passchanged) {
		this.passchanged = passchanged;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}


	public boolean isActive() {
		
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
