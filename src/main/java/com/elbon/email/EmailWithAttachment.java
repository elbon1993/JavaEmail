package com.elbon.email;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailWithAttachment {
	public static void main(String[] args) {

		final String from = "chandrahas.chatta@gmail.com";
		String to = "gadikatlavaralakshmi@gmail.com";
		String host = "smtp.gmail.com";

		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true"); // TLS

		// props.put("mail.smtp.port", "465");
		// props.put("mail.smtp.socketFactory.port", "465");
		// props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("chandrahas.chatta@gmail.com", "Chandu!2486");
			}
		});

		try {
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(from));
			message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject("Lovvuuuuuuuu..");
//			message.setText("chitti naannalooooooooooo..");
			
			
			Multipart multiPart = new MimeMultipart("related");
			
			// Part 1
			BodyPart bodyPart = new MimeBodyPart();
			bodyPart.setContent("<H2>Doyyyyyy</H2><br /><H5>Ekkadara chittodu...</H5><br /><img src=\"cid:image\">", "text/html");
			multiPart.addBodyPart(bodyPart);
			
			// Part 2
			bodyPart = new MimeBodyPart();
			bodyPart.setHeader("Content-ID", "<image>");
			bodyPart.setDataHandler(new DataHandler(new FileDataSource("C:\\Users\\Asus\\Desktop\\3rd mon\\IMG_2809.JPG")));
			bodyPart.setFileName("Chitti Thalli");
			multiPart.addBodyPart(bodyPart);
			
			message.setContent(multiPart);
			Transport.send(message);
			System.out.println("Sent successfully");

		} catch (MessagingException e) {
			e.printStackTrace();
		}

	}
}
