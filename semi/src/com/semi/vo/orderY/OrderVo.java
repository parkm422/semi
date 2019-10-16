package com.semi.vo.orderY;

import java.sql.Date;

public class OrderVo {
	private int ornum;
	private int mnum;
	private int amount;
	private String status;
	private String deladd;
	private String delivery;
	private Date orderdate;
	private String getname;
	public OrderVo(int ornum, int mnum, int amount, String status, String deladd, String delivery, Date orderdate,
			String getname) {
		super();
		this.ornum = ornum;
		this.mnum = mnum;
		this.amount = amount;
		this.status = status;
		this.deladd = deladd;
		this.delivery = delivery;
		this.orderdate = orderdate;
		this.getname = getname;
	}
	public int getOrnum() {
		return ornum;
	}
	public void setOrnum(int ornum) {
		this.ornum = ornum;
	}
	public int getMnum() {
		return mnum;
	}
	public void setMnum(int mnum) {
		this.mnum = mnum;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDeladd() {
		return deladd;
	}
	public void setDeladd(String deladd) {
		this.deladd = deladd;
	}
	public String getDelivery() {
		return delivery;
	}
	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	public String getGetname() {
		return getname;
	}
	public void setGetname(String getname) {
		this.getname = getname;
	}
	
	
}
