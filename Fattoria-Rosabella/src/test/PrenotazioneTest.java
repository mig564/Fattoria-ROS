package test;

import beans.Prenotazione;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class PrenotazioneTest extends TestCase {
	private Prenotazione p ;
	
	@Override
	protected void setUp() throws Exception {
		p = new Prenotazione(444, "2021-11-11", "14:00:10", 45, 478);
	}
	
	public void testSetId_P() {
		p.setId_prenotazione(12);
		assertEquals(12, p.getId_prenotazione());
	}

	public void testSetPrezzo() {
		p.setPrezzo(123);
		assertEquals(123, p.getPrezzo());
	}

	public void testSetId_R() {
		p.setId_riepilogo(187);
		assertEquals(187, p.getId_riepilogo());
	}
	
	public static Test suite() {
		return new TestSuite(PrenotazioneTest.class);
	}

}
