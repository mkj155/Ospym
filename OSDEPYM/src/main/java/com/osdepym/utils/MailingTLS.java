package com.osdepym.utils;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class MailingTLS {
	
	private static final Logger logger = Logger.getLogger(MailingTLS.class);
	private String fileName = "parameter.properties";
	
	public void sendMailTLS(String mailTo, String subject, String text) {
		
		try {
			Properties props = new Properties();
			logger.info("intentando cargar archivo: " + fileName);
			Properties parameters = ReadPropertyFile.readFile(fileName);
			props.setProperty("mail.smtp.auth", parameters.getProperty("mail.smtp.auth"));
			props.setProperty("mail.smtp.starttls.enable", parameters.getProperty("mail.smtp.starttls.enable"));
			props.setProperty("mail.smtp.host", parameters.getProperty("mail.smtp.host"));
			props.setProperty("mail.smtp.port", parameters.getProperty("mail.smtp.port"));
			
			String username = parameters.getProperty("username");
			String password = parameters.getProperty("password");

			logger.info("autenticando sesion");
			Session session = Session.getInstance(props, new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication(username, password);
				}
			});
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(mailTo));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mailTo));
			message.setSubject(subject);
			message.setText(text);
			
			Transport.send(message);
			logger.info("mail enviado con exito");
		} catch (Exception e) {
			logger.error("error en el envio del mail ", e);
			throw new RuntimeException(e);
		}
	}
	
}
