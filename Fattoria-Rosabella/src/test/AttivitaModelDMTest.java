package test;

import java.sql.SQLException;
import java.util.Collection;

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
		attivita = new Attivita(300, "Escursione", "Cascata della Maronnella", "Escursione presso il punto più bello del bioparco", 32, 25);
		Attivita db = attivitaModelDM.doRetrieveByKey("5");
		attivitaModelDM.doDelete(db);
		db = attivitaModelDM.doRetrieveByKey("2");
		attivitaModelDM.doDelete(db);
	}
	
	public void testDoRetrieveByKey() throws SQLException {
		Attivita db = attivitaModelDM.doRetrieveByKey("300");
		assertEquals(attivita.toString(), db.toString());	
	}
	
	public void testDoRetrieveByAttri() throws SQLException {
		Collection<Attivita> att = attivitaModelDM.doRetrieveByAtti("2020-12-01", "Escursione");
		for (Attivita a : att){
			assertEquals("Escursione", a.getCategoria());		
		}	
	}
	
	public void testdoSave() throws SQLException {
		Attivita atti = new Attivita(2, "Escursione", "Cascata", "", 10, 85);
		attivitaModelDM.doSave(atti);
		assertEquals(atti.toString(), attivitaModelDM.doRetrieveByKey("2").toString());	
	}
	
	public void testDoUpdate() throws SQLException {
		Attivita db = new Attivita(5, "Escursione", "Cascata", "", 45, 41);
		attivitaModelDM.doSave(db);
		db.setNome("RosolinoGay");
		attivitaModelDM.doUpdate(db);
		assertEquals("RosolinoGay", attivitaModelDM.doRetrieveByKey("5").getNome());
		attivitaModelDM.doDelete(db);
	}
	
	public void testDoDelete() throws SQLException {
		Attivita db = attivitaModelDM.doRetrieveByKey("2");
		attivitaModelDM.doDelete(db);
		assertEquals(new Attivita().toString(), attivitaModelDM.doRetrieveByKey("2").toString());
	}
	
	public static Test suite() {
		return new TestSuite(AttivitaModelDMTest.class);
	}
}
