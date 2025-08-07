package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendLoginConfirmationEmail(String toEmail, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("🛡️ FEINBank - Login Alert");

        String body = String.format(
            "Hi %s,\n\n" +
            "🎉 Welcome back to FEINBank!\n\n" +
            "This is a confirmation that you have successfully logged into your account.\n" +
            "If this wasn't you, please contact our support team.\n\n" +
            "🔒 Stay safe,\n" +
            "FEINBank Security Team\n" +
            "--------------------------------------\n" +
            "This is an automated message. Please do not reply to this email.",
            name
        );

        message.setText(body);
        mailSender.send(message);
    }
}
