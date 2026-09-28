package com.beans;

public class BuyProductBean {

	private String pid,pname;
	private double price,totalBill;
	private int rQty;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(double totalBill) {
		this.totalBill = totalBill;
	}
	public int getrQty() {
		return rQty;
	}
	public void setrQty(int rQty) {
		this.rQty = rQty;
	}
	
}
