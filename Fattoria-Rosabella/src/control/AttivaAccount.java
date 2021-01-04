package control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.Utente;
import model.UtenteModelDM;

@WebServlet("/AttivaAccount")
public class AttivaAccount extends HttpServlet {
	private static final long serialVersionUID = 1;
	private UtenteModelDM utenteModelDM = new UtenteModelDM();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("key1");
		String id = request.getParameter("key2");
		String error = "";
		try {
			Utente utente = this.utenteModelDM.doRetrieveByKeyAndInattiveState(email, id);
			if(utente == null) {
				error = "Utente non trovato. Per favore, registrati di nuovo.";
	            request.setAttribute("error", error);
	            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
	            dispatcher.forward(request, response);
			} else {
				utenteModelDM.doUpdateState(utente);
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
	            dispatcher.forward(request, response);
			}
 			
		} catch (Exception e) {
			System.out.println("Error at SendingEmail.java: " + e);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
