package test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import beans.PrenotazioneAttivita;

public class PrenotazioneAttivitaTest extends TestCase {
	private PrenotazioneAttivita pa;
	
	@Override
	protected void setUp() throws Exception {
		pa = new PrenotazioneAttivita(21, 14, "2021-12-12", "11:00:00", 33);
	}
	
	public void testSetData() {
		pa.setDate("2021-11-11");
		assertEquals("2021-11-11", pa.getDate());
	}
	
	public void testSetOra() {
		pa.setOra("17:00:00");
		assertEquals("17:00:00", pa.getOra());
	}
	
	public void testSetPartecipanti() {
		pa.setPartecipanti(55);
		assertEquals(55, pa.getPartecipanti());
	}
	
	public void testSetId_A() {
		pa.setId_attivita(87);
		assertEquals(87, pa.getId_attivita());
	}
	
	public void testSetId_P() {
		pa.setId_prenotazione(158);
		assertEquals(158,  pa.getId_prenotazione());
	}
	
	public static Test suite() {
		return new TestSuite(PrenotazioneAttivitaTest.class);
	}

}
