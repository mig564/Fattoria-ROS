package control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Attivita;
import beans.Calendario;
import beans.Prenotazione;
import model.AttivitaModelDM;
import model.CalendarioModelDM;
import model.PrenotazioneModelDM;

/**
 * @author pa.ni.ca
 * Servlet implementation class AdminControl
 * Questa servlet gestisce tutte le attivita che pu√≤ fare l'admin
 */
@WebServlet("/AdminControl")
public class AdminControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static AttivitaModelDM attivitaModelDM = new AttivitaModelDM();
	private static PrenotazioneModelDM prenotazioneModelDM = new PrenotazioneModelDM();
	private static CalendarioModelDM calendarioModelDM = new CalendarioModelDM();
	
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
							Attivita attivita = new Attivita();
							Random random = new Random();
							int id = random.nextInt(700);
							attivita.setId_attivita(id);
							attivita.setNome(request.getParameter("nome"));
							attivita.setCategoria(request.getParameter("categoria"));
							attivita.setDescrizione(request.getParameter("descrizioneAttivit‡"));
							attivita.setMax_persone(Integer.parseInt(request.getParameter("numeroParticipanti")));
							attivita.setPrezzo(Integer.parseInt(request.getParameter("prezzoAttivit‡")));
							attivitaModelDM.doSave(attivita);
							String orari[] = request.getParameterValues("orario");
							String giorni[] = request.getParameterValues("giorno");
							String mesi[] = request.getParameterValues("mese");
							for(String mese : mesi) {
								Calendar calendar = new GregorianCalendar();
								int lastDay;
								if(mese.equals("Gennaio")) {
									calendar.set(2021, Calendar.JANUARY, 1);
								} else if(mese.equals("Febbraio")) {
									calendar.set(2021, Calendar.FEBRUARY, 1);
								} else if(mese.equals("Marzo")) {
									calendar.set(2021, Calendar.MARCH, 1);
								}
								lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
								for(int i=1; i<=lastDay; i++) {
									Calendar c = new GregorianCalendar();
									c.set(2021, calendar.getMaximum(Calendar.MONTH), i);
									for(String giorno : giorni) {
										if(giorno.equals("LunedÏ")) {
											if(c.getActualMaximum(Calendar.DAY_OF_WEEK) == 1) {
												for(String orario : orari) {
													Calendario cal = new Calendario();
													cal.setDate(c.toString());
													cal.setOra(orario);
													cal.setPartecipanti(Integer.parseInt(request.getParameter("numeroParticipanti")));
													calendarioModelDM.doSave(cal);
												}
											}
										}
									}
								}
								
							}
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
