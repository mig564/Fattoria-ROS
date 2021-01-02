package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

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
			ArrayList<Attivita> attivitas = (ArrayList<Attivita>) attivitaModelDM.doRetrieveByAtti((String) request.getAttribute("date"), (String) request.getAttribute("categoria"));
			
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
