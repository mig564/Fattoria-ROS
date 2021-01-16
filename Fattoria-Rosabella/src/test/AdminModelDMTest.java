package test;

import java.sql.SQLException;

import beans.Admin;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.AdminModelDM;

public class AdminModelDMTest extends TestCase {
	
	private static AdminModelDM am = new AdminModelDM();
	private Admin gs;
	
	@Override
	protected void setUp() throws Exception {
		gs = new Admin("root@root.it", "root");
	}
	
	public void testDoRietrieveByKey() throws SQLException {
		Admin db = am.doRetrieveByKey("root@root.it");
		assertEquals(gs.toString(), db.toString());
	}
	
	public static Test suite() {  
		return new TestSuite(AdminModelDMTest.class);
	}

}
