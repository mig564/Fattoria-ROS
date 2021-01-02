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
            Utente utente = new Utente();
            utente.setEmail(request.getParameter("email").trim());
            utente.setNome(request.getParameter("nome").trim());
            utente.setCognome(request.getParameter("cognome").trim());
            utente.setCitta(request.getParameter("citta").trim());
            utente.setData_nascita(request.getParameter("data_nascita").trim());
            utente.setPassword(request.getParameter("password").trim());
            utente.setIndirizzo(request.getParameter("indirizzo").trim());
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
