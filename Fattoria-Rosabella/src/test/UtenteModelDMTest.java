package test;

import java.sql.SQLException;
import java.util.Random;

import beans.RiepilogoOrdine;
import beans.Utente;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.RiepilogoOrdineModelDM;
import model.UtenteModelDM;

public class UtenteModelDMTest extends TestCase {

	private static RiepilogoOrdineModelDM ordineModelDM = new RiepilogoOrdineModelDM();
	private static UtenteModelDM utenteModelDM = new UtenteModelDM();
	private RiepilogoOrdine riep;
	private int re;
	private static Random ra = new Random();
	private Utente utente;
	
	@Override
	protected void setUp() throws Exception {
		re = ra.nextInt();
		utente = new Utente("provaTest@gmail.com", "Carmine", "Pastore", "1234", "salerno", 1, "napoli", "2010-01-01", re);
		riep = new RiepilogoOrdine(re);
		ordineModelDM.doSave(riep);
	}
	
	public void testDoSave() throws SQLException {
		utenteModelDM.doSave(utente);
		assertEquals(utente.toString(), utenteModelDM.doRetrieveByKey("provaTest@gmail.com").toString());
		utenteModelDM.doDelete(utente);
	}
	
	public void testDoRetrieveByKey() throws SQLException {
		utenteModelDM.doSave(utente);
		Utente db = utenteModelDM.doRetrieveByKey("provaTest@gmail.com");
		assertEquals(db.toString(), utente.toString());
		utenteModelDM.doDelete(utente);
	}

	public void testDoUpdate() throws SQLException {
		utenteModelDM.doSave(utente);
		utente.setNome("Pasquale");
		utenteModelDM.doUpdate(utente);
		assertEquals(utente.getNome(), utenteModelDM.doRetrieveByKey("provaTest@gmail.com").getNome());
		utenteModelDM.doDelete(utente);
	}
	
	public void testDoDelete() throws SQLException {
		utenteModelDM.doSave(utente);
		utenteModelDM.doDelete(utente);
		assertEquals(new Utente().toString(), utenteModelDM.doRetrieveByKey("provaTest@gmail.com").toString());
	}
	
	@Override
	protected void tearDown() throws Exception {
		ordineModelDM.doDelete(riep);
	}

	public static Test suite() {
		return new TestSuite(UtenteModelDMTest.class);
	}
}
