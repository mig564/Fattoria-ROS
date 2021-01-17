package test;

import beans.CartaDiCredito;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class CartaDiCreditoTest extends TestCase{
	private CartaDiCredito cc;
	
	@Override
	protected void setUp() throws Exception {
		cc = new CartaDiCredito("12345698712365470" , "gianni rossi", "2024-11-11", 458, "rossigiuseppe@gmail.com");
	}
	
	public void testSetEmail() {
		cc.setEmail("giannigianni@gmail.com");
		assertEquals("giannigianni@gmail.com", cc.getEmail());
	}
	
	public void testSetIntestatario() {
		cc.setIntestatrio("clemente russo");
		assertEquals("clemente russo",cc.getIntestatrio());
	}
	
	public void testSetScadenza() {
		cc.setScadenza("2030-11-01");
		assertEquals("2030-11-01", cc.getScadenza());
	}
	
	public void testSetCvv() {
		cc.setCvv(144);
		assertEquals(144, cc.getCvv());
	}
	
	public void testSetNumero() {
		cc.setNumero("44448888777733331111");
		assertEquals("44448888777733331111", cc.getNumero());
	}
	
	public static Test suite() {
		return new TestSuite(CartaDiCreditoTest.class);
	}

}
