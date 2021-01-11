package control;

import java.io.IOException;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author panica
 * Servlet implementation class SendingInfoEmailControl
 */
@WebServlet("/SendingInfoEmailControl")
public class SendingInfoEmailControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public SendingInfoEmailControl() {
        super(); 
    }

    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = (String) request.getParameter("nome");
		String cognome = (String) request.getParameter("cognome");
		String email = (String) request.getParameter("email");
		String msg = (String) request.getParameter("messaggio");
		
		if(msg.equals("")) {
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/contatti.jsp");
		    dispatcher.forward(request, response);
		}
		
		sendMail(msg, email, nome, cognome);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/paginaringraziamento.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	
	/**
	 * 
	 * @param msg
	 * @param emailUtente
	 * @param nomeUtente
	 * @param cognomeUtente
	 */
	public void sendMail(String msg, String emailUtente, String nomeUtente, String cognomeUtente) {
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
			MimeMessage message = new MimeMessage(session);
			message.setFrom(new InternetAddress(email));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(email));
			message.addRecipient(Message.RecipientType.CC, new InternetAddress(emailUtente));
			message.setSubject("Richiesta informazioni da form contatto");
			message.setText("messaggio lasciato da : " + nomeUtente + " " + cognomeUtente + "\n" + msg );
			
			Transport.send(message);
			
			System.out.println("Successfully sent Verification Link");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
