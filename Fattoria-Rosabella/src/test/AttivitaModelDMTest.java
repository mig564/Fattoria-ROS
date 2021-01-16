package test;

import java.sql.SQLException;

import beans.Attivita;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.AttivitaModelDM;

public class AttivitaModelDMTest extends TestCase {

	private static AttivitaModelDM attivitaModelDM = new AttivitaModelDM();
	private Attivita attivita;
	
	@Override
	protected void setUp() throws Exception {
		attivita = new Attivita(1, "Escursione", "Cascata della Maronnella","Escursione presso il punto più bello del bioparco" , 15, 21);
		attivitaModelDM.doSave(attivita);
	}

	public void testDoRietrieveByKey() throws SQLException {
		Attivita db = attivitaModelDM.doRetrieveByKey("1");
		assertEquals(attivita.toString(), db.toString());
	}
	
	public void testDoUpdate() throws SQLException {
		attivita.setMax_persone(54);
		attivitaModelDM.doUpdate(attivita);
		Attivita db = attivitaModelDM.doRetrieveByKey("1");
		assertEquals(attivita.toString(), db.toString());
	}
	
	@Override
	protected void tearDown() throws Exception{
		attivitaModelDM.doDelete(attivita);
	}
	
	public static Test suite() {  
		return new TestSuite(AttivitaModelDMTest.class);
	}
}
