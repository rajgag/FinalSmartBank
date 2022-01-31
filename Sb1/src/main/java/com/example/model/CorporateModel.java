package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Value;

@Entity
@Table(name="corporate")
public class CorporateModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int corporateid;
	
	@NotEmpty(message = "*required")
	private String corporatename;
	
	@NotEmpty(message = "*required")
	private String corporateadd;
	
	@Pattern(regexp = "^[0-9]{10}$" ,message = "Invalid Ph-No")
	@NotNull
	private String corporatephno;

	private String status;
	
	public CorporateModel() {
		
	}
	public CorporateModel(int i, String name, String add, String pho) {
		this.corporateid=i;
		this.corporatename=name;
		this.corporateadd=add;
		this.corporatephno=pho;	
	}
	public int getCorporateid() {
		return corporateid;
	}
	public void setCorporateid(int corporateid) {
		this.corporateid =corporateid;
	}
	public String getCorporatename() {
		return corporatename;
	}
	public void setCorporatename(String corporatename) {
		this.corporatename = corporatename;
	}
	public String getCorporateadd() {
		return corporateadd;
	}
	public void setCorporateadd(String corporateadd) {
		this.corporateadd = corporateadd;
	}
	public String getCorporatephno() {
		return corporatephno;
	}
	public void setCorporatephno(String corporatephno) {
		this.corporatephno = corporatephno;
	}
	public String getstatus() {
		return status;
	}
	public void setstatus(String status) {
		this.status = status;
	}

}
