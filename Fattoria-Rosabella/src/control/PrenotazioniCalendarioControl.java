package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Attivita;
import model.AttivitaModelDM;
import moduloai.ModuloAI;

/**
 * @author pa.ni.ca
 * Servlet implementation class PrenotazioniCalendarioControl
 * Questa servlet gestisce le attivita di un giorno selezionato
 */
@WebServlet("/PrenotazioniCalendarioControl")
public class PrenotazioniCalendarioControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AttivitaModelDM attivitaModelDM = new AttivitaModelDM();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Collection<Attivita> attivitas = attivitaModelDM.doRetrieveByAtti((String) request.getParameter("date"), (String) request.getParameter("categoria"));
			boolean bambino = Boolean.getBoolean((String) request.getParameter("adattoBambini"));
			int b, t;
			if (bambino) b = 1;
			else b = 0;
			String tipologia = (String) request.getParameter("tipo");
			if(tipologia.equals("Relax")) t = 0;
			else if(tipologia.equals("Cardio")) t = 1;
			else t = 2;
			int min = Integer.parseInt(request.getParameter("minNumber"));
			int max = Integer.parseInt(request.getParameter("maxNumber"));
			Collection<Attivita> attivita = ModuloAI.cerca(attivitas, b, t, min, max);
			if (attivita.size() > 0) {
				request.removeAttribute("attivitas");
				request.setAttribute("attivitas", attivita);
				request.removeAttribute("date");
				request.setAttribute("date", (String) request.getParameter("date"));
			} else {
				request.removeAttribute("error");
				request.setAttribute("error", "spiacente non ci sono attivita nel giorno selezionato");
			}
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/prenotazioni.jsp");
		    dispatcher.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
