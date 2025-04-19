package com.klef.fsad.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.klef.fsad.model.Email;
import com.klef.fsad.model.EmailRequest;
import com.klef.fsad.repository.EmailRepository;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@Autowired
	private EmailRepository emailRepo;

	/* Sends an email and saves the email details to the database 
	 *  EmailRequest it is going to contain email recipient, subject, and message 
	 * Once email was sent successfully you're going to get success message (or)
	 * you're going to get failure message
	 */
	@Override
	public String sendEmail(EmailRequest request) {
		try {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setTo(request.getTo());
			message.setSubject(request.getSubject());
			message.setText(request.getMessage());
			
			mailSender.send(message);
			
			/* Save email details in the database*/
			Email email = new Email(request.getTo(), request.getSubject(), request.getMessage());
			emailRepo.save(email);
			
			return "Email Sent Successfully";
		}
		catch(Exception e) {
			return "Error occurred while sending an email";
		}
	}
	
}
