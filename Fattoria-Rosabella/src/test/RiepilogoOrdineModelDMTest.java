package test;

import java.sql.SQLException;
import java.util.Random;

import beans.RiepilogoOrdine;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.RiepilogoOrdineModelDM;

public class RiepilogoOrdineModelDMTest extends TestCase {

	private static RiepilogoOrdineModelDM ordineModelDM = new RiepilogoOrdineModelDM();
	private RiepilogoOrdine riep;
	private int re;
	private static Random ra = new Random();
	
	protected void setUp() throws Exception {
		re = ra.nextInt();
		riep = new RiepilogoOrdine(re);
	}
	
	public void testDoSave() throws SQLException {
		ordineModelDM.doSave(riep);
		assertEquals(riep.toString(), ordineModelDM.doRetrieveByKey(""+re).toString());
		ordineModelDM.doDelete(riep);
	}
	
	public void testDoRetrieveByKey() throws SQLException {
		ordineModelDM.doSave(riep);
		RiepilogoOrdine db = ordineModelDM.doRetrieveByKey(""+re);
		assertEquals(db.toString(), riep.toString());
		ordineModelDM.doDelete(riep);
	}

	public void testDoDelete() throws SQLException {
		ordineModelDM.doSave(riep);
		ordineModelDM.doDelete(riep);
		assertEquals(new RiepilogoOrdine().toString(), ordineModelDM.doRetrieveByKey(""+re).toString());
	}
	
	public static Test suite() {
		return new TestSuite(RiepilogoOrdineModelDMTest.class);
	}
}
