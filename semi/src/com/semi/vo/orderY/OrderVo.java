package com.semi.vo.orderY;

import java.sql.Date;

public class OrderVo {
	private int ornum;
	private int mnum;
	private int amount;
	private int cnt;
	private String status;
	private String deladd;
	private String delivery;
	private Date orderdate;
	private String getname;
	private String pname;
	private String color;
	private int psize;
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

	public OrderVo(int ornum, String pname, int psize, String color,int cnt, String deladd, String delivery, int amount,Date orderdate) {
		super();
		this.ornum = ornum;
		this.pname = pname;
		this.psize = psize;
		this.color = color;
		this.cnt = cnt;
		this.deladd = deladd;
		this.delivery = delivery;
		this.amount=amount;
		this.orderdate = orderdate;
	}
	
	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPsize() {
		return psize;
	}

	public void setPsize(int psize) {
		this.psize = psize;
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
