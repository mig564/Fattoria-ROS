/**
 * 
 */
package test;

import beans.Calendario;
import junit.framework.TestCase;
import model.CalendarioModelDM;

public class CalendarioModelDMTest extends TestCase {

	private CalendarioModelDM calmo = new CalendarioModelDM();
	private Calendario calendario;
	
	@Override
	protected void setUp() throws Exception {
		calendario = new Calendario("", "", 4, 300);
		calmo.doSave(calendario);
	}

	@Override
	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
