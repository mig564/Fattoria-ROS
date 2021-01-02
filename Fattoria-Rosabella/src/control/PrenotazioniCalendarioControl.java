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

/**
 * Servlet implementation class PrenotazioniCalendarioControl
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
			if (attivitas.size() > 0) {
				request.removeAttribute("attivitas");
				request.setAttribute("attivitas", attivitas);
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
