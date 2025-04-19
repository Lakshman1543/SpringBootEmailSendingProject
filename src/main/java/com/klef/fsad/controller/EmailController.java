package com.klef.fsad.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.klef.fsad.model.EmailRequest;
import com.klef.fsad.services.EmailService;

@RestController
public class EmailController {
	
	@Autowired
	private EmailService emailService;

	@GetMapping("/")
	public String  main() {
		return "Spring Boot Email Sending Project is Running Successfully..!!";
	}
	
	@PostMapping("sendEmail")
	public String sendEmail(@RequestBody EmailRequest request) {
		return emailService.sendEmail(request);
	}
}
