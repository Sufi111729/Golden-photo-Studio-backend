// MailService.java
package com.sufi.photoStudio.Service.impl;


import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.sufi.photoStudio.Service.IMailService;

@Service
public class MailService implements IMailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendBookingConfirmation(String to, String subject, String content) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true); // true = HTML enabled

            mailSender.send(message);
            System.out.println("Email sent to " + to);
        } catch (MessagingException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to send email", e);
        }
    }
}
