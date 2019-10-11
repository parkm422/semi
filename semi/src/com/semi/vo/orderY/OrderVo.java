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
	public OrderVo() {}
	public OrderVo(int ornum,int mnum, int amount, String status, String deladd,String delivery,Date orderdate) {
		super();
		this.ornum = ornum;
		this.mnum = mnum;
		this.amount = amount;
		this.status = status;
		this.deladd = deladd;
		this.delivery = delivery;
		this.orderdate = orderdate;
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
	public void setDelivery(String delvery) {
		this.delivery = delvery;
	}
	public Date getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}
	
}
