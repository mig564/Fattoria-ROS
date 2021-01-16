package test;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.SQLException;
import java.util.ArrayList;


import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import beans.Utente;
import model.UtenteModelDM;

@TestInstance(Lifecycle.PER_CLASS)
public class RegistrazioneTest {
	 private ArrayList<Utente> all;
	 private UtenteModelDM model;
	
	@Before
	public void salvaUtente()  {
		
		all = new ArrayList<Utente>();
		model = new UtenteModelDM();
		
		
		try {
			
			Utente utente = new Utente();
			utente.setAttivo(1);
			utente.setCitta("Avellino");
			utente.setCognome("Razzo");
			utente.setData_nascita("1999-11-10");
			utente.setEmail("pastssorecarmine@gmail.com");
			utente.setId_riepilogo(154);
			utente.setIndirizzo("via dei mille");
			utente.setNome("Marco");
			utente.setPassword("Educazione12");
			
			System.out.println(utente.toString());
			
			all.add(utente);
			model.doSave(utente);
			
			Utente utente1 = new Utente();
			utente.setAttivo(1);
			utente.setCitta("Avellino");
			utente.setCognome("Rossi");
			utente.setData_nascita("1999-11-10");
			utente.setEmail("lucamazza@gmail.com");
			utente.setId_riepilogo(54);
			utente.setIndirizzo("via de concilis");
			utente.setNome("Aldo");
			utente.setPassword("Diavolo2");
			
			all.add(utente1);
			model.doSave(utente1);
			
			Utente utente2 = new Utente();
			utente.setAttivo(1);
			utente.setCitta("Pratola Serra");
			utente.setCognome("Bavaro");
			utente.setData_nascita("1999-11-10");
			utente.setEmail("luigibavaro@gmail.com");
			utente.setId_riepilogo(52);
			utente.setIndirizzo("via de concilis");
			utente.setNome("Luigi");
			utente.setPassword("Dragobianco");
			
			all.add(utente2);
			model.doSave(utente2);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	
	}
	
	@Test
	void test() throws SQLException {
		
		for(Utente u : all ) {
			System.out.println("hello " + u.toString());
			Utente u2 = model.doRetrieveByKey(u.getEmail());
			assertEquals(u2,u );
			
		}
	}
	

}
