package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="accounts")
public class AccountModel {
	
	private int corporateid;
	
	@NotNull(message = "*required")
	@Min(value =10000000,message = "Invalid Account No")
	@Max(value=99999999,message="Invalid Account No")
	@Id
	private int accountno;
	
	@NotEmpty(message = "*required")
	private String accountname;
	
	private String accountbranch;
	
	private String currency;
	
	@NotNull(message = "*required")
	private double availablebalance;
	
	private String accountstatus;
	
	
	public int getCorporateid() {
		return corporateid;
	}
	public void setCorporateid(int corporateid) {
		this.corporateid = corporateid;
	}
	public int getAccountno() {
		return accountno;
	}
	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}
	public String getAccountname() {
		return accountname;
	}
	public void setAccountname(String accountname) {
		this.accountname = accountname;
	}
	public String getAccountbranch() {
		return accountbranch;
	}
	public void setAccountbranch(String accountbranch) {
		this.accountbranch = accountbranch;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public double getAvailablebalance() {
		return availablebalance;
	}
	public void setAvailablebalance(double availablebalance) {
		this.availablebalance = availablebalance;
	}
	public String getAccountstatus() {
		return accountstatus;
	}
	public void setAccountstatus(String accountstatus) {
		this.accountstatus = accountstatus;
	}

}
