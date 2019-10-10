package com.semi.email;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuthentication extends Authenticator {
	PasswordAuthentication pa;
	private static final String ID = "ui_01hwc@naver.com";
	private static final String PW = "#chilete10.";
	
	public MyAuthentication() {
        pa = new PasswordAuthentication(ID, PW);
	}
	
	public PasswordAuthentication getPasswordAuthentication() {
		return pa;
	}
}