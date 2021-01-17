/**
 * 
 */
package test;

import java.sql.SQLException;

import beans.Calendario;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.CalendarioModelDM;

public class CalendarioModelDMTest extends TestCase {

	private CalendarioModelDM calmo = new CalendarioModelDM();
	private Calendario calendario;
	
	@Override
	protected void setUp() throws Exception {
		calendario = new Calendario("2025-12-02", "08:00:00", 4, 300);
		calmo.doDelete(calendario);
	}
	
	public void testDoSave() throws SQLException {
		calmo.doSave(calendario);
		assertEquals(calendario.toString(), calmo.doRetrieveByKey("2025-12-02").toString());
		calmo.doDelete(calendario);
	}
	
	public void testDoRetrieveByKey() throws SQLException {
		calmo.doSave(calendario);
		Calendario db = calmo.doRetrieveByKey("2025-12-02");
		assertEquals(db.toString(), calendario.toString());
		calmo.doDelete(calendario);
	}
	
	public void testDoDelete() throws SQLException {
		calmo.doSave(calendario);
		calmo.doDelete(calendario);
		assertEquals(new Calendario().toString(), calmo.doRetrieveByKey("2025-12-02").toString());
	}
	
	public static Test suite() {
		return new TestSuite(CalendarioModelDMTest.class);
	}

}
