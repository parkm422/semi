package com.semi.vo.deliveryl;

public class DeliveryVo {
	private int ornum;
	private String pname;
	private String status;
	private String delivery;
	
	public DeliveryVo() {}

	public DeliveryVo(int ornum,  String pname, String status, String delivery) {
		super();
		this.ornum = ornum;
		
		this.pname = pname;
		this.status = status;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDelivery() {
		return delivery;
	}

	public void setDelivery(String delivery) {
		this.delivery = delivery;
	}
	
	
}
