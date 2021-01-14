package control;

import beans.Utente;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.UtenteModelDM;

/**
 * @author pa.ni.ca
 * Servlet implementation class AreaPersonale
 * Questa servlet gestige l'area personale dell'utente
 */
@WebServlet({"/AreaPersonale"})
public class AreaPersonale extends HttpServlet {
   private static final long serialVersionUID = 1L;
   static UtenteModelDM utenteModelDM = new UtenteModelDM();
   
   /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String email = (String)request.getSession().getAttribute("email");
      String action = request.getParameter("action");
      System.out.println(action);
      try {
         if (action == null) {
        	Utente utente = utenteModelDM.doRetrieveByKey(email);
            utente.setEmail(utente.getEmail());
            utente.setPassword(utente.getPassword());
        	utente.setNome(request.getParameter("nome").trim());
        	utente.setCognome(request.getParameter("cognome").trim());
        	utente.setCitta(request.getParameter("citta").trim());
        	utente.setData_nascita(request.getParameter("data_nascita").trim());
        	utente.setIndirizzo(request.getParameter("indirizzo").trim());
            utenteModelDM.doUpdate(utente);
         } else {
            request.removeAttribute("utente");
            request.setAttribute("utente", utenteModelDM.doRetrieveByKey(email));
         }
      } catch (Exception var6) {
    	  var6.printStackTrace();
      }
      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ilmioprofilo.jsp");
      dispatcher.forward(request, response);
   }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
}
