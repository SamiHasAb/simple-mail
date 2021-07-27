package com.example.simplemail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.mail.MessagingException;

@SpringBootApplication
public class SimplemailApplication {

	@Autowired
	private EmailSenderService emailSenderService;



		public static void main(String[] args) {
		SpringApplication.run(SimplemailApplication.class, args);


	}


	@EventListener(ApplicationReadyEvent.class)
	public void sendMail() throws MessagingException {

		emailSenderService.sendSimpleEmail( "toguest@example.com",
											"this is the body of the message",
											"this is the subject of the message");

		emailSenderService.sendEmailWithAttachment( "toguest@example.com",
													"this is the body of the message",
													"this is the subject of the message",
													"C:\\Users\\sami_\\Downloads\\car.jpg");
		}
}
