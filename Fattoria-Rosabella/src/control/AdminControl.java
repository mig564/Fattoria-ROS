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
						if(action.equals("tutto")) {
							request.removeAttribute("attivita");
							request.setAttribute("attivita", attivitaModelDM.doRetrieveAll(""));
						}
						else if (action.equals("aggiungi")) {
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
								} else if(mese.equals("Aprile")) {
									calendar.set(2021, Calendar.APRIL, 1);
								} else if(mese.equals("Maggio")) {
									calendar.set(2021, Calendar.MAY, 1);
								} else if(mese.equals("Giugno")) {
									calendar.set(2021, Calendar.JUNE, 1);
								} else if(mese.equals("Luglio")) {
									calendar.set(2021, Calendar.JULY, 1);
								} else if(mese.equals("Agosto")) {
									calendar.set(2021, Calendar.AUGUST, 1);
								} else if(mese.equals("Settembre")) {
									calendar.set(2021, Calendar.SEPTEMBER, 1);
								} else if(mese.equals("Ottobre")) {
									calendar.set(2021, Calendar.OCTOBER, 1);
								} else if(mese.equals("Novembre")) {
									calendar.set(2021, Calendar.NOVEMBER, 1);
								} else if(mese.equals("Dicembre")) {
									calendar.set(2021, Calendar.DECEMBER, 1);
								}
								lastDay = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
								for(int i=1; i<=lastDay; i++) {
									Calendar c = new GregorianCalendar();
									c.set(2021, calendar.get(Calendar.MONTH), i);
									for(String giorno : giorni) {
										if(giorno.equals("Lunedi")) {
											if(c.get(Calendar.DAY_OF_WEEK) == 2) {
												for(String orario : orari) {
													Calendario cal = new Calendario();
													String m = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DAY_OF_MONTH);
													cal.setDate(m);
													cal.setOra(orario);
													cal.setPartecipanti(Integer.parseInt(request.getParameter("numeroParticipanti")));
													cal.setId_attivita(id);
													calendarioModelDM.doSave(cal);
												}
											}
										}
										if(giorno.equals("Martedi")) {
											if(c.get(Calendar.DAY_OF_WEEK) == 3) {
												for(String orario : orari) {
													Calendario cal = new Calendario();
													String m = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DAY_OF_MONTH);
													cal.setDate(m);
													cal.setOra(orario);
													cal.setPartecipanti(Integer.parseInt(request.getParameter("numeroParticipanti")));
													cal.setId_attivita(id);
													calendarioModelDM.doSave(cal);
												}
											}
										}
										if(giorno.equals("Mercoledi")) {
											if(c.get(Calendar.DAY_OF_WEEK) == 4) {
												for(String orario : orari) {
													Calendario cal = new Calendario();
													String m = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DAY_OF_MONTH);
													cal.setDate(m);
													cal.setOra(orario);
													cal.setPartecipanti(Integer.parseInt(request.getParameter("numeroParticipanti")));
													cal.setId_attivita(id);
													calendarioModelDM.doSave(cal);
												}
											}
										}
										if(giorno.equals("Giovedi")) {
											if(c.get(Calendar.DAY_OF_WEEK) == 5) {
												for(String orario : orari) {
													Calendario cal = new Calendario();
													String m = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DAY_OF_MONTH);
													cal.setDate(m);
													cal.setOra(orario);
													cal.setPartecipanti(Integer.parseInt(request.getParameter("numeroParticipanti")));
													cal.setId_attivita(id);
													calendarioModelDM.doSave(cal);
												}
											}
										}
										if(giorno.equals("Venerdi")) {
											if(c.get(Calendar.DAY_OF_WEEK) == 6) {
												for(String orario : orari) {
													Calendario cal = new Calendario();
													String m = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DAY_OF_MONTH);
													cal.setDate(m);
													cal.setOra(orario);
													cal.setPartecipanti(Integer.parseInt(request.getParameter("numeroParticipanti")));
													cal.setId_attivita(id);
													calendarioModelDM.doSave(cal);
												}
											}
										}
										if(giorno.equals("Sabato")) {
											if(c.get(Calendar.DAY_OF_WEEK) == 7) {
												for(String orario : orari) {
													Calendario cal = new Calendario();
													String m = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DAY_OF_MONTH);
													cal.setDate(m);
													cal.setOra(orario);
													cal.setPartecipanti(Integer.parseInt(request.getParameter("numeroParticipanti")));
													cal.setId_attivita(id);
													calendarioModelDM.doSave(cal);
												}
											}
										}
										if(giorno.equals("Domenica")) {
											if(c.get(Calendar.DAY_OF_WEEK) == 1) {
												for(String orario : orari) {
													Calendario cal = new Calendario();
													String m = c.get(Calendar.YEAR) + "-" + (c.get(Calendar.MONTH)+1) + "-" + c.get(Calendar.DAY_OF_MONTH);
													cal.setDate(m);
													cal.setOra(orario);
													cal.setPartecipanti(Integer.parseInt(request.getParameter("numeroParticipanti")));
													cal.setId_attivita(id);
													calendarioModelDM.doSave(cal);
												}
											}
										}
									}
								}
								
							}
						} else if (action.equals("rimuovi")) {
							String id_attivita = request.getParameter("id");
							attivitaModelDM.doDelete(new Attivita(Integer.parseInt(id_attivita), "", "", "", 0, 0));
						} else if (action.equals("update")) {
							Attivita attivita = new Attivita();
							attivita.setId_attivita(Integer.parseInt(request.getParameter("idattivita")));
							attivita.setNome(request.getParameter("nome"));
							attivita.setCategoria(request.getParameter("categoria"));
							attivita.setDescrizione(request.getParameter("descrizioneAttivit‡"));
							attivita.setMax_persone(Integer.parseInt(request.getParameter("numeroParticipanti")));
							attivita.setPrezzo(Integer.parseInt(request.getParameter("prezzoAttivit‡")));
							attivitaModelDM.doUpdate(attivita);
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
