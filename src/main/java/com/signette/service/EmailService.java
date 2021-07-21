package com.signette.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;
import java.util.Properties;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    String fromMail;

    @Value("${spring.mail.password}")
    String password;

    public void sendMail(String toEmail, String body, String subject){
        Properties properties = new Properties();
        properties.put("mail.smtp.auth","true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port","587");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator(){
           protected PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(fromMail,password);
           }
        });

        MimeMessage msg = new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(fromMail));
            msg.addRecipients(Message.RecipientType.TO, String.valueOf(new InternetAddress(toEmail)));
            msg.setSubject(subject);
            msg.setText(body);
            Transport.send(msg);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }
}
