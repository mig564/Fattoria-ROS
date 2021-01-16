package test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import beans.Admin;

public class GestoreTest extends TestCase {
	private Admin gs;
	
	
	protected void setUp() throws Exception {
		gs = new Admin( "mario@rossi.it","Rossi007");
	}
	
	public void testSetEmail() {
		gs.setEmail("giannigianni@gmail.com");
		assertEquals("giannigianni@gmail.com", gs.getEmail());
		
	}
	
	public void testSetPassword() {
		gs.setPassword("BluJeans");
		assertEquals("BluJeans",gs.getPassword());
	}
	
	public static Test suite() {
		return new TestSuite(GestoreTest.class);
		
	}

	

}
