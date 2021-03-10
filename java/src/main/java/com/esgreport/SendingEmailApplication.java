package com.esgreport;

import java.io.File;
import java.io.IOException;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class SendingEmailApplication {

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(String email,String subject,String message) {

		SimpleMailMessage msg = new SimpleMailMessage();
//		msg.setTo("testveertestveer@gmail.com");
//		msg.setSubject("Testing from Spring Boot");
//		msg.setText("Hello World \n Spring Boot Email");
		
		msg.setTo(email);
		msg.setSubject(subject);
		msg.setText(message);

		javaMailSender.send(msg);

	}

	public void sendEmailWithAttachment() throws MessagingException, IOException {

		MimeMessage msg = javaMailSender.createMimeMessage();

		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);

		helper.setTo("testveertestveer@gmail.com");

		helper.setSubject("Testing from Spring Boot");

		// default = text/plain
		// helper.setText("Check attachment for image!");

		// true = text/html
		helper.setText("<h1>Check attachment for image!</h1>", true);

		// hard coded a file path
		FileSystemResource file = new FileSystemResource(new File("C:/Users\\Veeroju\\Pictures\\Camera Roll\\a.jpg"));

		helper.addAttachment("a.png", file);

		javaMailSender.send(msg);

	}

}