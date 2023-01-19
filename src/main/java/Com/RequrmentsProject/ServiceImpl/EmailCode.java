package Com.RequrmentsProject.ServiceImpl;

import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import Com.RequrmentsProject.Entity.User;
@Service
public class EmailCode {

	public static void email(User user) {
		
		System.out.println("Sending message!...");
		String random=RandomString.make(10);
		String message="your password is "+ random;
		String subject="send password";
		String to=user.getEmail();
		String from="mayuriy.bca2021@ssism.org";
		
		sendEmail(message,subject,to,from);
		

	}


//	this was responsible for send email
	public static void sendEmail(String message, String subject, String to, String from) {
		
//		variable for gmail
		
		
		
		String host="smtp.gmail.com";
		
//		get the system.properties
	Properties properties = System.getProperties();
	System.out.println("Properties"+properties);
	
	
//	setting important information to properties object

//	host set
	properties.put("mail.smtp.host",host);
	properties.put("mail.smtp.port","465");
	properties.put("mail.smtp.ssl.enable","true");
	properties.put("mail.smtp.auth","true");
	
	
//	get session object
	Session session=Session.getInstance(properties, new Authenticator() {

		@Override
		protected PasswordAuthentication getPasswordAuthentication() {
			
			return new PasswordAuthentication("mayuriy.bca2021@ssism.org","9752725274");
		}
		
	});
	
	session.setDebug(true);
	
//	compose message
	MimeMessage m=new MimeMessage(session);
	try {
//	from email
	m.setFrom(from);
	
//	adding recepient to message
	m.addRecipient(Message.RecipientType.TO,new InternetAddress(to));
	
//	adding subject to message
	m.setSubject(subject);
	
	
//	adding text tob message
	m.setText(message);
	
//	send
//	send the message using transport
	Transport.send(m);
	
	System.out.println("Send sucess.............");
	
	
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	}
}
