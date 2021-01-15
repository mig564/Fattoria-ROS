package control;

import beans.Attivita;
import beans.Formare;
import model.AttivitaModelDM;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pa.ni.ca
 * Servlet implementation class CarrelloControl
 * Questa Servlet gestisce il carrello dell'admin
 */
@WebServlet({"/CarrelloControl"})
public class CarrelloControl extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private AttivitaModelDM attivitaModelDM = new AttivitaModelDM();
   
   /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      @SuppressWarnings("unchecked")
      ArrayList<Formare> formCart = (ArrayList<Formare>) request.getSession().getAttribute("formCart");
      ArrayList<Attivita> list = new ArrayList<Attivita>();
      String action = request.getParameter("action");
      
      if (action != null) {
         String id_attivita = request.getParameter("id");
         if (action.equals("aggiungi")) {
        	 if (cercaElemento(formCart, id_attivita).getId_attivita() == 0) {
        		 String partecipanti = (String) request.getParameter("partecipanti");
        		 formCart.add(new Formare((int)request.getSession().getAttribute("carrello"), Integer.parseInt(id_attivita), (String)request.getAttribute("data"), (String)request.getParameter("ora"), Integer.parseInt(partecipanti)));
        	 }
         } else if (action.equals("rimuovi")) {
            formCart.remove(cercaElemento(formCart, id_attivita));
         } else if(action.equals("svuotaCarrello")) {
        	formCart.clear(); 
         } else if (action.equals("modifica")) {
        	 String partecipanti = (String) request.getParameter("partecipanti");
        	 Formare formare = cercaElemento(formCart, id_attivita);
        	 formare.setOra((String) request.getParameter("ora"));
        	 System.out.println(formare.getOra());
        	 formare.setPartecipanti(Integer.parseInt(partecipanti));
        	 formCart.set(formCart.indexOf(formare), formare); 
		}
      }
      request.getSession().setAttribute("formCart", formCart);
      list.clear();
      for (Formare formare : formCart) {
    	  try {
			list.add(attivitaModelDM.doRetrieveByKey(""+formare.getId_attivita()));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      }
      request.removeAttribute("attivita");
      request.setAttribute("attivita", list);
      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/riepilogo.jsp");
      dispatcher.forward(request, response);
   }

   /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   this.doGet(request, response);
   }
   
   /**
    * Questo metodo cerca elemento all'interno del carrello
    * @param formCart carrello utente
    * @param id_attivita id dell'attivita da cercare
    * @return attivita trovata o un attivita vuota
    */
   private Formare cercaElemento(ArrayList<Formare> formCart, String id_attivita) {
  		int id = Integer.parseInt(id_attivita);
  		for (Formare formare : formCart) {
  			if (formare.getId_attivita() == id)
  				return formare;
  		}
  		return new Formare();
	}
}
