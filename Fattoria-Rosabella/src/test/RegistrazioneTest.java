package test;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import beans.RiepilogoOrdine;
import beans.Utente;
import model.RiepilogoOrdineModelDM;
import model.UtenteModelDM;

public class RegistrazioneTest {
	private ArrayList<Utente> all;
	private UtenteModelDM model;
	private RiepilogoOrdineModelDM riep;
	private Utente utente;
	private Utente utente1;
	private Utente utente2;

	@Before
	public void salvaUtente() throws SQLException {
		all = new ArrayList<Utente>();
		model = new UtenteModelDM();
		riep = new RiepilogoOrdineModelDM();

		utente = new Utente();
		utente.setAttivo(1);
		utente.setCitta("Avellino");
		utente.setCognome("Razzo");
		utente.setData_nascita("1999-11-10");
		utente.setEmail("pastssorecarmine@gmail.com");
		utente.setId_riepilogo(160);
		utente.setIndirizzo("via dei mille");
		utente.setNome("Marco");
		utente.setPassword("Educazione12");

		riep.doSave(new RiepilogoOrdine(160));
		model.doSave(utente);
		all.add(utente);

		utente1 = new Utente();
		utente1.setAttivo(1);
		utente1.setCitta("Avellino");
		utente1.setCognome("Rossi");
		utente1.setData_nascita("1999-11-10");
		utente1.setEmail("lucamazza@gmail.com");
		utente1.setId_riepilogo(90);
		utente1.setIndirizzo("via de concilis");
		utente1.setNome("Aldo");
		utente1.setPassword("Diavolo2");

		riep.doSave(new RiepilogoOrdine(90));
		model.doSave(utente1);
		all.add(utente1);

		utente2 = new Utente();
		utente2.setAttivo(1);
		utente2.setCitta("Pratola Serra");
		utente2.setCognome("Bavaro");
		utente2.setData_nascita("1999-11-10");
		utente2.setEmail("luigibavaro@gmail.com");
		utente2.setId_riepilogo(3);
		utente2.setIndirizzo("via de concilis");
		utente2.setNome("Luigi");
		utente2.setPassword("Dragobianco");

		model.doSave(utente2);
		all.add(utente2);
	}

	@Test
	public void test() throws SQLException {
		for (Utente u : all) {
			Utente u2 = model.doRetrieveByKey(u.getEmail());
			assertEquals(u2, u);
		}
	}

	@After
	public void eliminate() throws SQLException {
		model.doDelete(utente);
		riep.doDelete(new RiepilogoOrdine(160));
		model.doDelete(utente1);
		riep.doDelete(new RiepilogoOrdine(90));
		model.doDelete(utente2);
	}
}
