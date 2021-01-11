package control;

import beans.Formare;
import beans.RiepilogoOrdine;
import beans.Utente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.FormareModelDM;
import model.RiepilogoOrdineModelDM;
import model.UtenteModelDM;

/**
 * Servlet implementation class Login
 */
@WebServlet({"/Login"})
public class Login extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private UtenteModelDM utenteModelDM = new UtenteModelDM();
   private RiepilogoOrdineModelDM riepilogoOrdineModelDM = new RiepilogoOrdineModelDM();
   private FormareModelDM formareModelDM = new FormareModelDM();

   /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String error = "";
      String email = request.getParameter("email");
      String password = request.getParameter("password");

      try {
         Utente utente = this.utenteModelDM.doRetrieveByKey(email);
         if (utente == null || utente.getEmail() == null || utente.getEmail().equals("") || !utente.getPassword().equals(password) || utente.getAttivo() == 0) {
            error = "Errore. Riprova.";
            request.setAttribute("error", error);
            RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
            dispatcher.forward(request, response);
         } else {
        	 HttpSession session = request.getSession(true);
        	 if (session != null) {
        		session.setAttribute("email", email);
        		RiepilogoOrdine riepilogo = this.riepilogoOrdineModelDM.doRetrieveByKey("" + utente.getId_riepilogo());
        		session.setAttribute("carrello", riepilogo.getId_riepilogo());
        		ArrayList<Formare> formCart = this.formareModelDM.doRetrieveByIdCarrello(riepilogo.getId_riepilogo());
        		session.setAttribute("formCart", formCart);
        		response.sendRedirect("index.jsp");
        	 } else {
        		 RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
        		 dispatcher.forward(request, response);
        	 }
         }
      } catch (SQLException var10) {
    	  response.sendRedirect("error.html");
      }
   }

   /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
}
