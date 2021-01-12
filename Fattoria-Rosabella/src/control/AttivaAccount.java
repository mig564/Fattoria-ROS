package control;

import java.io.IOException;
import java.util.GregorianCalendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Utente;
import model.UtenteModelDM;

/**
 * @author pa.ni.ca
 * Servlet implementation class AttivaAccount
 * Questa servlet attiva l'account dell'utente
 */
@WebServlet("/AttivaAccount")
public class AttivaAccount extends HttpServlet {
	private static final long serialVersionUID = 1;
	private UtenteModelDM utenteModelDM = new UtenteModelDM();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("key1");
		String id = request.getParameter("key2");
		int sendTime = Integer.parseInt(request.getParameter("key3"));
		
		GregorianCalendar dataAttuale = new GregorianCalendar();
		int hour = dataAttuale.get(GregorianCalendar.HOUR);
		int minute = dataAttuale.get(GregorianCalendar.MINUTE);
		int second = dataAttuale.get(GregorianCalendar.SECOND);
		int now = second + (minute*60) + (hour*3600);
		
		String error = "";
		try {
			Utente utente = this.utenteModelDM.doRetrieveByKeyAndInattiveState(email, id);
			if(utente == null) {
				error = "Utente non trovato. Per favore, registrati di nuovo.";
	            request.setAttribute("error", error);
	            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
	            dispatcher.forward(request, response);
			} else if((now - sendTime) > 86600) {
				error = "Il link � scaduto. Per favore, registrati di nuovo.";
	            request.setAttribute("error", error);
	            utenteModelDM.doDelete(utente);
	            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
	            dispatcher.forward(request, response);
			} else {
				utenteModelDM.doUpdateState(utente);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/confermaattivazioneaccount.jsp");
	            dispatcher.forward(request, response);
			}
 			
		} catch (Exception e) {
			System.out.println("Error at SendingEmail.java: " + e);
		}
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
