package com.sist.manager;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailManager {
	
	public static void main(String[] args) {
		MailManager m=new MailManager();
		m.mailSender("Hello");
	}

/*	private String style="body{"
			+ "padding:1.5em;"
			+ "background:#F5F5F5;"
			+ "}"
			+ "table{"
			+ "border:1px #EDEDED solid;"
			+ "font-size:.9em;"
			+ "box-shadow:0 2px 5px rgba(0,0,0,.25);"
			+ "width:100%;"
			+ "border-collapse:collapse;"; */
	
	public void mailSender(String result)
	{
		String host="smtp.naver.com";
		String user="simeunwoo11@naver.com";
																																																																																														String password="sim1324!!";
		
		Properties props=new Properties();
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", 587);
		props.put("mail.smtp.auth", true);
		// Naver 인증
		Session session=Session.getDefaultInstance(props,new javax.mail.Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(user,password);
			}
			
		});
		
		try
		{
			MimeMessage message=new MimeMessage(session);
			message.setFrom(new InternetAddress(user));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("simeunwoo11@naver.com"));
			message.setSubject("제목");
			message.setContent(result,"text/html;charset=UTF-8");
		//	message.setContent(html,"text/html;charset=UTF-8");
			Transport.send(message);
			System.out.println("정상 수행");
		}catch(Exception ex)
		{
			System.out.println("비정상 수행");
		}
	}
}
