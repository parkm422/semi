package com.semi.email;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	private static final int PORT = 587;
	private static final String SERVER = "smtp.naver.com";
	private static final String EMAIL_ADDRESS = "ui_01hwc<ui_01hwc@naver.com>";
	
	public void send(String email, String content) {
		Properties p = System.getProperties();
		Authenticator auth = new MyAuthentication();
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.stmp.host", SERVER);
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.port", PORT);
		
		Session session = Session.getDefaultInstance(p, auth);
		MimeMessage msg = new MimeMessage(session);
		
		try {
           InternetAddress from = new InternetAddress(EMAIL_ADDRESS);
           InternetAddress to = new InternetAddress(email);
           
           msg.setFrom(from);
           msg.setRecipient(Message.RecipientType.TO, to);
           
           msg.setSentDate(new Date());
           msg.setSubject("비밀번호 재설정 이메일입니다.", "UTF-8");
           msg.setText(content);
           msg.setHeader("content-Type", "text/plain");
           javax.mail.Transport.send(msg);
		} catch (AddressException ae) {
			ae.printStackTrace();
		} catch (MessagingException me) {
			me.printStackTrace();
		}
	}
}