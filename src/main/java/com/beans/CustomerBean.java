package com.beans;

import java.io.Serializable;

public class CustomerBean implements Serializable{

	private String cid,cname,pwd,mailid;
	private long phone;
	public CustomerBean() {
		super();
	}
	public CustomerBean(String cid,String cname, String pwd, String mailid, long phone) {
		super();
		this.cid = cid;
		this.cname = cname;
		this.pwd = pwd;
		this.mailid = mailid;
		this.phone = phone;
	}
	
	
	
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
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
	
}
