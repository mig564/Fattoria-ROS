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

/**
 * @author pa.ni.ca
 * Servlet implementation class Registration
 * Questa servlet gestisce la registrazione di un utente
 */
@WebServlet({"/Registration"})
public class Registration extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private UtenteModelDM utenteModelDM = new UtenteModelDM();
   private RiepilogoOrdineModelDM riepilogoOrdineModelDM = new RiepilogoOrdineModelDM();

   /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
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
      utente.setAttivo(0);
      utente.setId_riepilogo(random.nextInt(3000));

      try {
         this.riepilogoOrdineModelDM.doSave(new RiepilogoOrdine(utente.getId_riepilogo()));
         this.utenteModelDM.doSave(utente);
         System.out.println("Email: " + utente.getEmail());
         System.out.println("    id: " + utente.getId_riepilogo()+"");
         SendingEmail se = new SendingEmail(utente.getEmail(), utente.getId_riepilogo()+"");
         se.sendMail();
      } catch (SQLException var6) {
    	  // TODO
    	  var6.printStackTrace();
      }

      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/attivazioneaccount.jsp");
      dispatcher.forward(request, response);
   }

   /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
   
}
