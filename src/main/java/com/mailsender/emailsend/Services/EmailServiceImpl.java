package com.mailsender.emailsend.Services;

import com.mailsender.emailsend.Config.EmailConfig;
import com.mailsender.emailsend.Model.EmailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class EmailServiceImpl implements EmailService{
    @Autowired
    private EmailConfig emailConfig;

    @Override
    public void sendMail(EmailResponse email) {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(emailConfig.getHost());
        mailSender.setPort(emailConfig.getPort());
        mailSender.setUsername(emailConfig.getUsername());
        mailSender.setPassword(emailConfig.getPassword());

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smtp.starttls.enable", "true");
        javaMailProperties.put("mail.smtp.auth", "true");
        javaMailProperties.put("mail.transport.protocol", "smtp");
        javaMailProperties.put("mail.debug", "true");
        mailSender.setJavaMailProperties(javaMailProperties);

        SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setTo(email.getEmailTo());
        mailMessage.setSubject(email.getSubject());
        mailMessage.setText(email.getMessage());
        mailMessage.setFrom("sender.mail.from.java@gmail.com");

        mailSender.send(mailMessage);
    }
}
