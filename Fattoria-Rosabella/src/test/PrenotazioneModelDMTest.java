package test;

import java.sql.SQLException;
import java.util.Random;

import beans.Prenotazione;
import beans.RiepilogoOrdine;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.PrenotazioneModelDM;
import model.RiepilogoOrdineModelDM;

public class PrenotazioneModelDMTest extends TestCase {

	private static PrenotazioneModelDM prenotazioneModelDM = new PrenotazioneModelDM();
	private static RiepilogoOrdineModelDM ordineModelDM = new RiepilogoOrdineModelDM();
	private RiepilogoOrdine riep;
	private int re;
	private static Random ra = new Random();
	private Prenotazione prenotazione;
	
	@Override
	protected void setUp() throws Exception {
		re = ra.nextInt();
		int idre = ra.nextInt();
		prenotazione = new Prenotazione(re, "", "", 5, idre);
		riep = new RiepilogoOrdine(idre);
		ordineModelDM.doSave(riep);
	}

	public void testDoSave() throws SQLException {
		prenotazioneModelDM.doSave(prenotazione);
		assertEquals(prenotazione.toString(), prenotazioneModelDM.doRetrieveByKey(""+re).toString());
		prenotazioneModelDM.doDelete(prenotazione);
	}
	
	public void testDoRetrieveByKey() throws SQLException {
		prenotazioneModelDM.doSave(prenotazione);
		Prenotazione db = prenotazioneModelDM.doRetrieveByKey(""+re);
		assertEquals(db.toString(), prenotazione.toString());
		prenotazioneModelDM.doDelete(prenotazione);
	}
	
	public void testDoUpdate() throws SQLException {
		prenotazioneModelDM.doSave(prenotazione);
		prenotazione.setPrezzo(500);
		prenotazioneModelDM.doUpdate(prenotazione);
		assertEquals(prenotazione.getPrezzo(), prenotazioneModelDM.doRetrieveByKey(""+re).getPrezzo());
		prenotazioneModelDM.doDelete(prenotazione);
	}

	public void testDoDelete() throws SQLException {
		prenotazioneModelDM.doSave(prenotazione);
		prenotazioneModelDM.doDelete(prenotazione);
		assertEquals(new Prenotazione().toString(), prenotazioneModelDM.doRetrieveByKey(""+re).toString());
	}
	
	@Override
	protected void tearDown() throws Exception {
		ordineModelDM.doDelete(riep);
	}

	public static Test suite() {
		return new TestSuite(PrenotazioneModelDMTest.class);
	}
}
