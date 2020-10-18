/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonout.util;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/**
 *
 * @author 51968
 */
public class Email {
    
    private final Properties props;

	public Email() {
		props = new Properties();

		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		props.put("from", "carbonouthackbbva@gmail.com");
		props.put("username", "carbonouthackbbva@gmail.com");
		props.put("password", "carbonout123");
	}

	public void enviar(String to, String subject, String content) throws MessagingException {
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(props.getProperty("username"), props.getProperty("password"));
			}
		});

		Message message = new MimeMessage(session);
		message.setFrom(new InternetAddress(props.getProperty("from")));
		message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
		message.setSubject(subject);
		message.setText(content);
		Transport.send(message);

		System.out.println("Mensaje enviado!");
	}

	/*public static void main(String[] args) throws MessagingException {
		Email e = new Email();
		e.enviar("fioredonqui910@gmail.com", "Hola Fiore <3!", "ejemplo de email enviado con Jakarta Mail");
	}*/
   
}
