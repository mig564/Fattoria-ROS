package test;


import beans.RiepilogoOrdine;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class RiepilogoOrdineTest extends TestCase{
	private RiepilogoOrdine ro;
	
	@Override
	protected void setUp() throws Exception {
		ro = new RiepilogoOrdine(777);
	}
	
	public void testSetId_R() {
		ro.setId_riepilogo(187);
		assertEquals(187, ro.getId_riepilogo());
	}
	
	public static Test suite() {
		return new TestSuite(RiepilogoOrdineTest.class);
		
	}

}
