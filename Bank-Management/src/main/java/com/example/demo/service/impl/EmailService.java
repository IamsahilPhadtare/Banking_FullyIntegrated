package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendLoginConfirmationEmail(String toEmail, String name) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(toEmail);
            helper.setSubject("🛡️ FEINBank - Login Alert");

            String htmlContent = "<div style='font-family: Arial, sans-serif; padding: 20px; background-color: #f5f5f5;'>"
                    + "<div style='max-width: 600px; margin: auto; background: #ffffff; border-radius: 10px; padding: 20px;'>"
                    + "<h2 style='color: #8D1B3D;'>Welcome back, " + name + "!</h2>"
                    + "<p style='font-size: 16px;'>🎉 You have successfully logged into your <strong>FEINBank</strong> account.</p>"
                    + "<p>If this wasn't you, please <a href='#' style='color: #d9534f;'></a> contact our support team immediately.</p>"
                    + "<hr style='margin: 20px 0;'/>"
                    + "<p style='font-size: 14px; color: #777;'>This is an automated message from VaultMaster. Please do not reply.</p>"
                    + "</div></div>";

            helper.setText(htmlContent, true); // Enable HTML

            mailSender.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException("Failed to send login email", e);
        }
}
}