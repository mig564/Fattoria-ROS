package control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CartaDiCredito;
import model.CartaDiCreditoModelDM;

/**
 * @author pa.ni.ca
 * Servlet implementation class CartControl
 * Questa servlet gestisce le carte di credito dell'utente
 */
@WebServlet("/CarteControl")
public class CarteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CartaDiCreditoModelDM cartaDiCreditoModelDM = new CartaDiCreditoModelDM();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getSession().getAttribute("email");
		String action = (String) request.getParameter("action");
		try {
			if (action != null) {
				if (action.equals("aggiungi")) {
					String numero = (String) request.getParameter("numero");
					String nome = (String) request.getParameter("nome");
					String cognome = (String) request.getParameter("cognome");
					String mese = (String) request.getParameter("mese");
					String anno = (String) request.getParameter("anno");
					String cvv = (String) request.getParameter("cvv");
					cartaDiCreditoModelDM.doSave(new CartaDiCredito(numero, nome+" "+cognome, mese+"/"+anno, Integer.parseInt(cvv), email));
				} else {
					cartaDiCreditoModelDM.doDelete(new CartaDiCredito(request.getParameter("numero"), "","",0,""));
				}
			}
			request.removeAttribute("carte");
			request.setAttribute("carte", cartaDiCreditoModelDM.doRetrieveAll(email));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/lemiecarte.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
