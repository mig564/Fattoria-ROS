package test;

import beans.Formare;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FormareTest extends TestCase{
	private Formare f;
	
	@Override
	protected void setUp() throws Exception {
		f = new Formare(12, 14, "2021-11-11", "12:00:00", 11);
	}
	
	public void testSetId_R() {
		f.setId_riepilogo(187);
		assertEquals(187, f.getId_riepilogo());
	}
	
	public void testSetId_A() {
		f.setId_attivita(87);
		assertEquals(87, f.getId_attivita());
	}

	public void testSetData() {
		f.setDate("2021-11-11");
		assertEquals("2021-11-11", f.getDate());
	}

	public void testSetOra() {
		f.setOra("17:00:00");
		assertEquals("17:00:00",f.getOra());
	
	}

	public void testSetPartecipanti() {
		f.setPartecipanti(55);
		assertEquals(55, f.getPartecipanti());
	}
	
	public static Test suite() {
		return new TestSuite(FormareTest.class);
	}

}
