package test;

import beans.Utente;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class UtenteTest extends TestCase{
	private Utente utente;
	
	
	@Override
	protected void setUp() throws Exception {
		utente = new Utente("giacomo@gmail.com", "giacomo", "poretti", "Sforza21" ,"via dei mille", 1, "milano", "2000-12-12", 147);
	}
	
	
	public void testSetEmail() {
		utente.setEmail("giannigianni@gmail.com");
		assertEquals("giannigianni@gmail.com", utente.getEmail());
		
	}
	
	public void testSetNome() {
		utente.setNome("gianni");
		assertEquals("gianni",utente.getNome());
		
	}
	
	public void testSetCognome() {
		utente.setCognome("rossi");
		assertEquals("rossi",utente.getCognome());
		
		
	}

	public void testSetPassword() {
		utente.setPassword("BluJeans");
		assertEquals("BluJeans",utente.getPassword());
	}

	public void testSetIndirizzo() {
		utente.setIndirizzo("VDC");
		assertEquals("VDC",utente.getIndirizzo());
	
	}
	
	public void testSetAttivo() {
		utente.setAttivo(0);
		assertEquals(0,utente.getAttivo());
	
	}

	public void testSetCitta() {
		utente.setCitta("Avellino");
		assertEquals("Avellino",utente.getCitta());	
	}

	public void testSetNascita() {
		utente.setData_nascita("1999-12-12");
		assertEquals("1999-12-12",utente.getData_nascita());
	}

	public void testSetRiepilogo() {
		utente.setId_riepilogo(100);
		assertEquals(100,utente.getId_riepilogo());
	}
	
	public static Test suite() {
		return new TestSuite(UtenteTest.class);
		
	}


}
