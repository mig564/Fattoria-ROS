package test;

import java.sql.SQLException;
import java.util.Random;

import beans.CartaDiCredito;
import beans.RiepilogoOrdine;
import beans.Utente;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.CartaDiCreditoModelDM;
import model.RiepilogoOrdineModelDM;
import model.UtenteModelDM;

public class CartaDiCreditoModelDMTest extends TestCase {

	private static CartaDiCreditoModelDM cartaModel = new CartaDiCreditoModelDM();
	private static UtenteModelDM utenteModelDM = new UtenteModelDM();
	private static RiepilogoOrdineModelDM ordineModelDM = new RiepilogoOrdineModelDM();
	private CartaDiCredito carta;
	private Utente utente;
	private RiepilogoOrdine riep;
	private static Random ra = new Random();
	
	@Override
	protected void setUp() throws Exception {
		carta = new CartaDiCredito("456263", "pastore", "2025-12-01", 522, "prova@gmail.com");
		int re = ra.nextInt();
		utente = new Utente("prova@gmail.com", "", "", "", "", 456, "", "2010-12-01", re);
		riep = new RiepilogoOrdine(re);
		ordineModelDM.doSave(riep);
		utenteModelDM.doSave(utente);
	}

	public void testDoSave() throws SQLException {
		cartaModel.doSave(carta);
		assertEquals(carta.toString(), cartaModel.doRetrieveByKey("prova@gmail.com").toString());
		cartaModel.doDelete(carta);
	}

	public void testDoRetrieveByKey() throws SQLException {
		cartaModel.doSave(carta);
		CartaDiCredito db = cartaModel.doRetrieveByKey("prova@gmail.com");
		assertEquals(db.toString(), carta.toString());
		cartaModel.doDelete(carta);
	}
	
	public void testDoUpdate() throws SQLException {
		cartaModel.doSave(carta);
		carta.setCvv(500);
		cartaModel.doUpdate(carta);
		assertEquals(carta.getCvv(), cartaModel.doRetrieveByKey("prova@gmail.com").getCvv());
		cartaModel.doDelete(carta);
	}
	
	public void testDoDelete() throws SQLException {
		cartaModel.doSave(carta);
		cartaModel.doDelete(carta);
		assertEquals(new CartaDiCredito().toString(), cartaModel.doRetrieveByKey("prova@gmail.com").toString());
	}
	
	@Override
	protected void tearDown() throws Exception {
		utenteModelDM.doDelete(utente);
		ordineModelDM.doDelete(riep);
	}
	
	public static Test suite() {
		return new TestSuite(CartaDiCreditoModelDMTest.class);
	}
}
