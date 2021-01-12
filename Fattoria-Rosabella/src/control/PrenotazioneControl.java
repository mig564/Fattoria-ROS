package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.PrenotazioneModelDM;

/**
 * @author pa.ni.ca
 * Servlet implementation class PrenotazioneControl
 * Questa servlet gestisce le prenotazioni dell'utente
 */
@WebServlet({"/PrenotazioneControl"})
public class PrenotazioneControl extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private static PrenotazioneModelDM prenotazioneModelDM = new PrenotazioneModelDM();

   /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      int id_carrello = (Integer) request.getSession().getAttribute("carrello");
      try {
    	  request.removeAttribute("prenotazioni");
    	  request.setAttribute("prenotazioni", prenotazioneModelDM.doRetrieveByCarr(id_carrello));
      } catch (SQLException var5) {
    	  var5.printStackTrace();
      }
      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/lemieprenotazioni.jsp");
      dispatcher.forward(request, response);
   }

   /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
}
