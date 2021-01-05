package control;

import java.util.GregorianCalendar;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendingEmail {

	private String userEmail;
	private String id;
	
	public SendingEmail(String userEmail, String id) {
		this.userEmail = userEmail;
		this.id = id;
	}
	
	public void sendMail() {
		// Enter the email address and password for the account from which verification link will be send
		String email = "fattoriarosabella1@gmail.com";
		String password = "Lautaro.1";
		
		Properties theProperties = new Properties();
		
		theProperties.put("mail.smtp.auth", "true");
		theProperties.put("mail.smtp.starttls.enable", "true");
		theProperties.put("mail.smtp.host", "smtp.gmail.com");
		theProperties.put("mail.smtp.port", "587");
		
		Session session = Session.getDefaultInstance(theProperties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});
		
		try {
			GregorianCalendar dataAttuale = new GregorianCalendar();
			int hour = dataAttuale.get(GregorianCalendar.HOUR);
			int minute = dataAttuale.get(GregorianCalendar.MINUTE);
			int second = dataAttuale.get(GregorianCalendar.SECOND);
			int sendTime = second + (minute*60) + (hour*3600);
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(userEmail));
			message.setSubject("Email Verification Link");
			message.setText("Click this link to confirm your email address and complete setup for your account."
					+ "\n\nVerification Link: " + "http://localhost:8080/Fattoria-Rosabella/AttivaAccount?key1=" + userEmail + "&key2=" + id + "&key3=" + sendTime);
			
			Transport.send(message);
			
			System.out.println("Successfully sent Verification Link");
			
		} catch (Exception e) {
			System.out.println("Error at SendingEmail.java: " + e);
		}
		
	}
	
}
