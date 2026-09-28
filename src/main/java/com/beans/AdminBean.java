package com.beans;

import java.io.Serializable;

public class AdminBean implements Serializable{

	private String aname,pwd,fname,lname,mailid;
	private long phone;
	public AdminBean() {
		super();
	}
	
	
	public AdminBean(String aname, String pwd, String fname, String lname, String mailid, long phone) {
		super();
		this.aname = aname;
		this.pwd = pwd;
		this.fname = fname;
		this.lname = lname;
		this.mailid = mailid;
		this.phone = phone;
	}


	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getMailid() {
		return mailid;
	}
	public void setMailid(String mailid) {
		this.mailid = mailid;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	@Override
	public String toString() {
		return "AdmiinBean [aname=" + aname + ", pwd=" + pwd + ", fname=" + fname + ", lname=" + lname + ", mailid="
				+ mailid + ", phone=" + phone + "]";
	}
	
	
}
