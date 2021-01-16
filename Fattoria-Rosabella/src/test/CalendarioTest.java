package test;

import beans.Calendario;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CalendarioTest extends TestCase {
	
	private Calendario calendario;
	
	@Override
	protected void setUp() throws Exception {
		calendario = new Calendario("2020-11-11","08:00:00", 15, 174);
	}
	
	public void testSetData() {
		calendario.setDate("2021-11-11");
		assertEquals("2021-11-11", calendario.getDate());
		
	}
	
	public void testSetOra() {
		calendario.setOra("17:00:00");
		assertEquals("17:00:00",calendario.getOra());
		
	}

	public void testSetId_Attivita() {
		calendario.setId_attivita(87);
		assertEquals(87, calendario.getId_attivita());
	
	}

	public void testSetParticipanti() {
		calendario.setPartecipanti(55);
		assertEquals(55, calendario.getPartecipanti());
	
	}
	
	public static Test suite() {
		return new TestSuite(CalendarioTest.class);
		
	}
}
