package com.yamudipak.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.yamudipak.utils.MailsUtils;

import jakarta.servlet.http.HttpSession;

@Controller
public class ContactController {
@Autowired
	private MailsUtils mu;
	@GetMapping("/contact")
	public String getContactForm(HttpSession session) {
		if(session.getAttribute("activeuser")==null) {
			return"Login";
		}
		return"ContactForm";
	}
	
	
	@PostMapping("/sendmail")
	public String sendMail(@RequestParam("toEmail") String toEMail,@RequestParam("subject") String subject
			,@RequestParam("message") String message,Model model) {
		mu.sendEmail(toEMail, subject, message);
		return"ContactForm";
	}
}
