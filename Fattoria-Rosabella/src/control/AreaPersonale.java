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

@WebServlet({"/AreaPersonale"})
public class AreaPersonale extends HttpServlet {
   private static final long serialVersionUID = 1L;
   static UtenteModelDM utenteModelDM = new UtenteModelDM();

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String email = (String)request.getSession().getAttribute("email");
      String action = request.getParameter("action");
      System.out.println(action);
      try {
         if (action == null) {
        	Utente utente = utenteModelDM.doRetrieveByKey(email);
            Utente newUtente = new Utente();
            newUtente.setEmail(utente.getEmail());
            newUtente.setPassword(utente.getPassword());
        	newUtente.setNome(request.getParameter("nome").trim());
        	newUtente.setCognome(request.getParameter("cognome").trim());
        	newUtente.setCitta(request.getParameter("citta").trim());
        	newUtente.setData_nascita(request.getParameter("data_nascita").trim());
        	newUtente.setIndirizzo(request.getParameter("indirizzo").trim());
            utenteModelDM.doUpdate(utente);
         } else {
            request.removeAttribute("utente");
            request.setAttribute("utente", utenteModelDM.doRetrieveByKey(email));
         }
      } catch (Exception var6) {
    	  
      }
      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/ilmioprofilo.jsp");
      dispatcher.forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
}
