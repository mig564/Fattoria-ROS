package control;

import beans.RiepilogoOrdine;
import beans.Utente;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.RiepilogoOrdineModelDM;
import model.UtenteModelDM;

@WebServlet({"/Registration"})
public class Registration extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private UtenteModelDM utenteModelDM = new UtenteModelDM();
   private RiepilogoOrdineModelDM riepilogoOrdineModelDM = new RiepilogoOrdineModelDM();

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      Random random = new Random();
      Utente utente = new Utente();
      utente.setEmail(request.getParameter("email").trim());
      utente.setNome(request.getParameter("nome").trim());
      utente.setCognome(request.getParameter("cognome").trim());
      utente.setCitta(request.getParameter("citta").trim());
      utente.setData_nascita(request.getParameter("data_nascita").trim());
      utente.setPassword(request.getParameter("password").trim());
      utente.setIndirizzo(request.getParameter("indirizzo").trim());
      utente.setId_riepilogo(random.nextInt());

      try {
         this.riepilogoOrdineModelDM.doSave(new RiepilogoOrdine(utente.getId_riepilogo()));
         this.utenteModelDM.doSave(utente);
      } catch (SQLException var6) {
      }

      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
      dispatcher.forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
}
