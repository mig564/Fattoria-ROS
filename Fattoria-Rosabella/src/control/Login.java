package control;

import beans.Admin;
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

import model.AdminModelDM;
import model.FormareModelDM;
import model.RiepilogoOrdineModelDM;
import model.UtenteModelDM;

/**
 * @author pa.ni.ca
 * Servlet implementation class Login
 * Questa servlet effetua il login dell'utente
 */
@WebServlet({"/Login"})
public class Login extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private UtenteModelDM utenteModelDM = new UtenteModelDM();
   private AdminModelDM adminModelDM = new AdminModelDM();
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
    	  if(isGestore(email)) {
    		  AdminModelDM adminModel = new AdminModelDM();
    		  Admin admin = adminModel.doRetrieveByKey(email);
    		  if (admin != null && admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
    				request.getSession().setAttribute("adminFilterRoles", true);
    				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/areariservata.jsp");
    				dispatcher.forward(request, response);
    			} else {
    				throw new Exception("Invalid login and password");
    			}
    	  }
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
      } catch (Exception e) {
		e.printStackTrace();
	}
   }

   /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
   
   private boolean isGestore(String email) throws SQLException {
	   Admin admin = this.adminModelDM.doRetrieveByKey(email);
	   if(admin == null || admin.getEmail() == null || admin.getEmail().equals("")) return false;
	   else return true;
   }
}
