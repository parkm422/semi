package com.semi.vo.managerP;

public class ViewVo {
	private String name;
	private String id;
	private String pname;
	private int psize;
	private String color;
	private int cnt;
	private int price;
	private String status;
	private String delivery;
	
	public ViewVo() {}

	public ViewVo(String name, String id, String pname, int psize, String color, int cnt, int price, String status,
			String delivery) {
		super();
		this.name = name;
		this.id = id;
		this.pname = pname;
		this.psize = psize;
		this.color = color;
		this.cnt = cnt;
		this.price = price;
		this.status = status;
		this.delivery = delivery;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPsize() {
		return psize;
	}

	public void setPsize(int psize) {
		this.psize = psize;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCnt() {
		return cnt;
	}

	public void setCnt(int cnt) {
		this.cnt = cnt;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
