package sarthak.corp.rest_api.mail.sending;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.mail.Authenticator;
import jakarta.mail.MessagingException;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMessage.RecipientType;

@Service
public class ServiceImpl {
	@Autowired
	InterPersistent persistent;
	
//	saving the object
	public Student save(Student entity) {
		if(entity!=null) {
			persistent.save(entity);
			// call the mail sending method
			sendMail(entity);
			return entity;
		}
		return null;
	}
	private void sendMail(Student std) {
		String from="sarthaknalage@gmail.com";
		String to=std.getStdMail();
		String subject="Testing Java API for mail sending";
		String msg="Security and confirmation check of java api sending ";
		
		// creating the property file and setting the configuration data
		Properties property= System.getProperties();
		System.out.println(property);
		property.setProperty("mail.smtp.host", "smtp.gmail.com");
		property.setProperty("mail.smtp.port","465");
		property.setProperty("mail.smtp.ssl.enable", "true");
		property.setProperty("mail.smtp.auth", "true");
		
		// creating session object with the authentication of user sender
		Session session= Session.getInstance(property,new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(from, "sarthak@1312003");
			}
		});
		
		MimeMessage mime= new MimeMessage(session);
		try {
			mime.setFrom(from);
			mime.setSubject(subject);
			mime.addRecipient(RecipientType.TO, new InternetAddress(to));
			mime.setText(msg);
			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		try {
			Transport.send(mime);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
}
