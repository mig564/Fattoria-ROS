package test;

import java.sql.SQLException;
import java.util.Random;

import beans.Prenotazione;
import beans.PrenotazioneAttivita;
import beans.RiepilogoOrdine;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.PrenotazioneAttivitaModelDM;
import model.PrenotazioneModelDM;
import model.RiepilogoOrdineModelDM;

public class PrenotazioneAttivitaModelDMTest extends TestCase {

	private static PrenotazioneAttivitaModelDM prenotazioneAttivitaModelDM = new PrenotazioneAttivitaModelDM();
	private static PrenotazioneModelDM prenotazioneModelDM = new PrenotazioneModelDM();
	private static RiepilogoOrdineModelDM ordineModelDM = new RiepilogoOrdineModelDM();
	private RiepilogoOrdine riep;
	private Prenotazione prenotazione;
	private PrenotazioneAttivita prenotazioneAttivita;
	int re;
	private static Random ra = new Random();
	
	protected void setUp() throws Exception {
		re = ra.nextInt();
		prenotazioneAttivita = new PrenotazioneAttivita(3, re, "2025-12-01", "08:00:00", 5);
		int idre = ra.nextInt();
		riep = new RiepilogoOrdine(idre);
		ordineModelDM.doSave(riep);
		prenotazione = new Prenotazione(re, "2025-12-01", "08:00:00", 5, idre);
		prenotazioneModelDM.doSave(prenotazione);
	}

	public void testDoSave() throws SQLException {
		prenotazioneAttivitaModelDM.doSave(prenotazioneAttivita);
		assertEquals(prenotazioneAttivita.toString(), prenotazioneAttivitaModelDM.doRetrieveByKey(""+re).toString());
		prenotazioneAttivitaModelDM.doDelete(prenotazioneAttivita);
	}
	
	public void testDoRetrieveByKey() throws SQLException {
		prenotazioneAttivitaModelDM.doSave(prenotazioneAttivita);
		PrenotazioneAttivita db = prenotazioneAttivitaModelDM.doRetrieveByKey(""+re);
		assertEquals(db.toString(), prenotazioneAttivita.toString());
		prenotazioneAttivitaModelDM.doDelete(prenotazioneAttivita);
	}
	
	public void testDoUpdate() throws SQLException {
		prenotazioneAttivitaModelDM.doSave(prenotazioneAttivita);
		prenotazioneAttivita.setPartecipanti(500);
		prenotazioneAttivitaModelDM.doUpdate(prenotazioneAttivita);
		assertEquals(prenotazioneAttivita.getPartecipanti(), prenotazioneAttivitaModelDM.doRetrieveByKey(""+re).getPartecipanti());
		prenotazioneAttivitaModelDM.doDelete(prenotazioneAttivita);
	}
	
	public void testDoDelete() throws SQLException {
		prenotazioneAttivitaModelDM.doSave(prenotazioneAttivita);
		prenotazioneAttivitaModelDM.doDelete(prenotazioneAttivita);
		assertEquals(new PrenotazioneAttivita().toString(), prenotazioneAttivitaModelDM.doRetrieveByKey(""+re).toString());
	}
	
	protected void tearDown() throws Exception {
		prenotazioneModelDM.doDelete(prenotazione);
		ordineModelDM.doDelete(riep);
	}

	public static Test suite() {
		return new TestSuite(PrenotazioneAttivitaModelDMTest.class);
	}
}
