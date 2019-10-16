package com.semi.vo.deliveryl;

public class DeliveryVo {
	private int ornum;
	private String pname;
	private String getname;
	private String delivery;
	
	public DeliveryVo() {}

	public DeliveryVo(int ornum, String pname, String getname, String delivery) {
		super();
		this.ornum = ornum;
		this.pname = pname;
		this.getname = getname;
		this.delivery = delivery;
	}

	public int getOrnum() {
		return ornum;
	}

	public void setOrnum(int ornum) {
		this.ornum = ornum;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getGetname() {
		return getname;
	}

	public void setGetname(String getname) {
		this.getname = getname;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}

	
}
