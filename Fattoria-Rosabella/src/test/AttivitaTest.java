package test;

import beans.Attivita;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AttivitaTest extends TestCase {
	
	private Attivita attivita;
	
	@Override
	protected void setUp() throws Exception {
		
		attivita = new Attivita(17, "escursione", "corsa", "descrizione", 21, 12); 
	}
	
	public void testSetId() {
		attivita.setId_attivita(12);
		assertEquals(12, attivita.getId_attivita());
		
	}
	
	public void testSetCategoria() {
		attivita.setCategoria("corsetta");
		assertEquals("corsetta", attivita.getCategoria());
		
	}
	
	public void testSetNome() {
		attivita.setNome("trota");
		assertEquals("trota", attivita.getNome());
		
	}
	
	public void testSetDescrizione() {
		attivita.setDescrizione("nuova");
		assertEquals("nuova", attivita.getDescrizione());
	
	}
	
	public void testSetMax() {
		attivita.setMax_persone(12);
		assertEquals(12, attivita.getMax_persone());
	
	}
	
	public void testSetPrezzo() {
		attivita.setPrezzo(123);
		assertEquals(123, attivita.getPrezzo());
	
	}
	
	public static Test suite() {
		return new TestSuite(AttivitaTest.class);
		
	}

}
