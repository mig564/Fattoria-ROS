package test;

import beans.Admin;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AdminTest extends TestCase {
	private Admin admin;
	
	@Override
	protected void setUp() throws Exception {
		admin = new Admin( "mario@rossi.it","Rossi007");
	}
	
	public void testSetEmail() {
		admin.setEmail("giannigianni@gmail.com");
		assertEquals("giannigianni@gmail.com", admin.getEmail());
		
	}
	
	public void testSetPassword() {
		admin.setPassword("BluJeans");
		assertEquals("BluJeans",admin.getPassword());
	}
	
	public static Test suite() {
		return new TestSuite(AdminTest.class);
		
	}
	
	
	
	
	

}
