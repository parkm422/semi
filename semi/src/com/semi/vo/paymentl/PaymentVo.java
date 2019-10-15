package com.semi.vo.paymentl;


public class PaymentVo {
	private int pnum;
	private int ornum;
	private int mnum;
	private int payamount;
	private int enpay;
	private String varchar;
	
	public PaymentVo() {}

	public PaymentVo(int pnum, int ornum, int mnum, int payamount, int enpay, String varchar) {
		super();
		this.pnum = pnum;
		this.ornum = ornum;
		this.mnum = mnum;
		this.payamount = payamount;
		this.enpay = enpay;
		this.varchar = varchar;
	}

	public int getPnum() {
		return pnum;
	}

	public void setPnum(int pnum) {
		this.pnum = pnum;
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

	public int getPayamount() {
		return payamount;
	}

	public void setPayamount(int payamount) {
		this.payamount = payamount;
	}

	public int getEnpay() {
		return enpay;
	}

	public void setEnpay(int enpay) {
		this.enpay = enpay;
	}

	public String getVarchar() {
		return varchar;
	}

	public void setVarchar(String varchar) {
		this.varchar = varchar;
	}
	
}
