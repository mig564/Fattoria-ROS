package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Attivita;
import beans.Prenotazione;
import model.AttivitaModelDM;
import model.PrenotazioneModelDM;

/**
 * Servlet implementation class AdminControl
 */
@WebServlet("/AdminControl")
public class AdminControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AttivitaModelDM attivitaModelDM = new AttivitaModelDM();
	private static PrenotazioneModelDM prenotazioneModelDM = new PrenotazioneModelDM();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tipo = (String) request.getParameter("tipo");
		String action = (String) request.getParameter("action");
		if (tipo != null) {
			try {
				if (action != null) {
					if (tipo.equals("attivita")) {
						if (action.equals("aggiungi")) {
							attivitaModelDM.doSave(new Attivita(Integer.parseInt(request.getParameter("id_attivita")), request.getParameter("categoria"), request.getParameter("nome"), request.getParameter("descrizione"), Integer.parseInt(request.getParameter("maxpersone")), Integer.parseInt(request.getParameter("prezzo"))));
						} else if (action.equals("rimuovi")) {
							attivitaModelDM.doDelete(new Attivita(Integer.parseInt(request.getParameter("id_attivita")), "", "", "", 0, 0));
						} else if (action.equals("update")) {
							attivitaModelDM.doUpdate(new Attivita(Integer.parseInt(request.getParameter("id_attivita")), request.getParameter("categoria"), request.getParameter("nome"), request.getParameter("descrizione"), Integer.parseInt(request.getParameter("maxpersone")), Integer.parseInt(request.getParameter("prezzo"))));
						}
						RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/attivitariservate.jsp");
					    dispatcher.forward(request, response);
					} else if (tipo.equals("prenotazioni")) {
						if (action.equals("")) {
							
						} else if (action.equals("rimuovi")) {
							prenotazioneModelDM.doDelete(new Prenotazione(Integer.parseInt(request.getParameter("id_prenotazione")), "", "", 0, 0));
						} else if (action.equals("update")) {
							
						}
						RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/prenotazioniriservate.jsp");
					    dispatcher.forward(request, response);
					}
				}
			} catch (NumberFormatException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
