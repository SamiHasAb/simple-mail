package com.example.simplemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service

public class EmailSenderService {


    @Autowired
    private JavaMailSender mailSender;



    //simple mail
    public void sendSimpleEmail(  String toEmail,
                                  String body,
                                  String subject){

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("spring.boot.conformationmail.test@gmail.com");
        message.setTo(toEmail);
        message.setText(body);
        message.setSubject(subject);

        mailSender.send(message);

        System.out.println("Mail Sent........");
    }


    //mail with attachment

    public void sendEmailWithAttachment( String toEmail,
                                     String body,
                                     String subject,
                                     String attachment) throws MessagingException {

      MimeMessage mimeMessage = mailSender.createMimeMessage();

        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true);

        messageHelper.setFrom("spring.boot.conformationmail.test@gmail.com");
        messageHelper.setTo(toEmail);
        messageHelper.setText(body);
        messageHelper.setSubject(subject);


        FileSystemResource file = new FileSystemResource(new File(attachment));

        messageHelper.addAttachment(file.getFilename(), file);


        mailSender.send(mimeMessage);
        System.out.println("Mail Sent.......");

    }

}
