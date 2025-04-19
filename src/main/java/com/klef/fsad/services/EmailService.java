package com.klef.fsad.services;

import com.klef.fsad.model.EmailRequest;

public interface EmailService {

	public String sendEmail(EmailRequest request);
}
