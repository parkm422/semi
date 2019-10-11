package com.semi.vo.managerK;

public class ManagerVO {
	
	private int adnum;
	private String id;
	private String pwd;
	
	public ManagerVO() {
		
	}

	public ManagerVO(int adnum, String id, String pwd) {
		super();
		this.adnum = adnum;
		this.id = id;
		this.pwd = pwd;
	}

	public int getAdnum() {
		return adnum;
	}

	public void setAdnum(int adnum) {
		this.adnum = adnum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
}
