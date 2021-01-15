package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Formare;

/**
 * Servlet implementation class CarrelloAjax
 */
@WebServlet("/CarrelloAjax")
public class CarrelloAjax extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		@SuppressWarnings("unchecked")
		ArrayList<Formare> formCart = (ArrayList<Formare>) request.getSession().getAttribute("formCart");
		String id = request.getParameter("id");
		String partecipanti = (String) request.getParameter("partecipanti");
		if (request.getParameter("act") != null) {
			Formare formare = cercaElemento(formCart, id);
       	 	formare.setOra((String) request.getParameter("ora"));
       	 	formare.setPartecipanti(Integer.parseInt(partecipanti));
       	 	formCart.set(formCart.indexOf(formare), formare); 
		} else {
			formCart.add(new Formare((int)request.getSession().getAttribute("carrello"), Integer.parseInt(id), (String)request.getParameter("date"), (String)request.getParameter("ora"), Integer.parseInt(partecipanti)));
		}
		request.getSession().setAttribute("formCart", formCart);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
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
