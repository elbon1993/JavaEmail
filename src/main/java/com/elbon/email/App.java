package com.elbon.email;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class App 
{
    public static void main( String[] args )
    {
    	
    	final String from = "chandrahas.chatta@gmail.com";
    	String to = "gadikatlavaralakshmi@gmail.com";
    	String host = "smtp.gmail.com";
    	
    	Properties props = new Properties();
    	 props.put("mail.smtp.host", "smtp.gmail.com");
         props.put("mail.smtp.port", "587");
         props.put("mail.smtp.auth", "true");
         props.put("mail.smtp.starttls.enable", "true"); //TLS
    	
//    	props.put("mail.smtp.port", "465");
//    	props.put("mail.smtp.socketFactory.port", "465");
//        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        
    	Session session = Session.getInstance(props, new Authenticator() {
    		protected PasswordAuthentication getPasswordAuthentication() {
    			return new PasswordAuthentication("chandrahas.chatta@gmail.com", "Chandu!2486");
    		}
		});
    	
    	try {
    		Message message = new MimeMessage(session);
    		message.setFrom(new InternetAddress(from));
    		message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
    		message.setSubject("Love you forever chittoda..");
    		message.setText("chitti naannalooooooooooo..");
    		Transport.send(message);
    		System.out.println("Sent successfully");
    		
    	} catch (MessagingException e) {
    		e.printStackTrace();
    	}
    }
}
