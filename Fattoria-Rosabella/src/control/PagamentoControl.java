package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.CartaDiCredito;
import beans.Formare;
import beans.Prenotazione;
import beans.PrenotazioneAttivita;
import model.CartaDiCreditoModelDM;
import model.PrenotazioneAttivitaModelDM;
import model.PrenotazioneModelDM;

/**
 * @author pa.ni.ca
 * Servlet implementation class PagamentoControl
 * Questa servlet gestisce il pagamento da parte dell'utente
 */
@WebServlet("/PagamentoControl")
public class PagamentoControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static CartaDiCreditoModelDM cartaDiCreditoModelDM = new CartaDiCreditoModelDM();
	private static PrenotazioneModelDM prenotazioneModelDM = new PrenotazioneModelDM();
	private static PrenotazioneAttivitaModelDM prenotazioneAttivitaModelDM = new PrenotazioneAttivitaModelDM();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = (String) request.getSession().getAttribute("email");
		int carrello = (int) request.getSession().getAttribute("carrello");
		String error = "";
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
					cartaDiCreditoModelDM.doSave(new CartaDiCredito(numero, nome+cognome, mese+"/"+anno, Integer.parseInt(cvv), email));
					request.removeAttribute("carte");
					request.setAttribute("carte", cartaDiCreditoModelDM.doRetrieveAll(email));
					RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/pagamento.jsp");
				    dispatcher.forward(request, response);
				} else if (action.equals("paga")){
					@SuppressWarnings("unchecked")
					ArrayList<Formare> formares = (ArrayList<Formare>) request.getSession().getAttribute("formCart");
					if (formares.isEmpty()) {
						error = "Errore. Riprova.";
				        request.setAttribute("error", error);
					} else {
						Date date = new Date();
						String data = date.toInstant().toString();
						System.out.println(data);
						Random random = new Random();
						int id_prenotazione = random.nextInt();
						prenotazioneModelDM.doSave(new Prenotazione(id_prenotazione, data.substring(11, 19), "", 0, carrello));
						for (Formare formare : formares) {
							prenotazioneAttivitaModelDM.doSave(new PrenotazioneAttivita(formare.getId_attivita(), id_prenotazione, formare.getDate(), formare.getOra()));
						}
						formares.clear();
						request.getSession().setAttribute("formCart", formares);
						response.sendRedirect("index.jsp");
					}
				}
			} else {
				request.removeAttribute("carte");
				request.setAttribute("carte", cartaDiCreditoModelDM.doRetrieveAll(email));
				RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/pagamento.jsp");
			    dispatcher.forward(request, response);
			}
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
