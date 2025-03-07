package com.yamudipak.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Component
public class MailsUtils {
	@Autowired
	private JavaMailSender sendmail;
public void sendEmail(String toEmail,String subject,String message) {
	SimpleMailMessage  mail=new SimpleMailMessage();
	mail.setTo(toEmail);
	mail.setSubject(subject);
	mail.setText(message);
	sendmail.send(mail);
}
}
