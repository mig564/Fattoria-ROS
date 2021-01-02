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

@WebServlet({"/Carrello"})
public class Carrello extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private AttivitaModelDM attivitaModelDM = new AttivitaModelDM();
   
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      @SuppressWarnings("unchecked")
      ArrayList<Formare> formCart = (ArrayList<Formare>) request.getSession().getAttribute("formCart");
      ArrayList<Attivita> list = new ArrayList<Attivita>();
      String action = request.getParameter("action");
      
      if (action != null) {
         String id_attivita = request.getParameter("id");
         if (action.equals("Aggiungi")) {
        	 if (cercaElemento(formCart, id_attivita).getId_attivita()!=0) {
        		 formCart.add(new Formare((Integer)request.getSession().getAttribute("carrello"), Integer.parseInt(id_attivita), (String)request.getAttribute("data"), (String)request.getAttribute("ora"), 1));
        	 }
         } else if (action.equals("Rimuovi")) {
            formCart.remove(cercaElemento(formCart, id_attivita));
         } else if(action.equals("SvuotaCarrello")) {
        	formCart.clear(); 
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

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   this.doGet(request, response);
   }
   
   private Formare cercaElemento(ArrayList<Formare> formCart, String id_attivita) {
  		int id = Integer.parseInt(id_attivita);
  		for (Formare formare : formCart) {
  			if (formare.getId_attivita() == id)
  				return formare;
  		}
  		return new Formare();
	}
}
