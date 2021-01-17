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
	
	public void testDoRetrieveAll() throws SQLException {
		Collection<Attivita> att = attivitaModelDM.doRetrieveAll("");
		assertEquals(att.size(), 12);								//TODO 12 � il numero di attivit� al momento, se aggiungo un attivit� al db il tests dar� errore	
	}
	
	public void testdoSave() {
		
	}
	
	public void testDoUpdate() throws SQLException {
		attivita.setNome("RosolinoGay");
		attivitaModelDM.doUpdate(attivita);
		assertEquals("RosolinoGay", attivitaModelDM.doRetrieveByKey("300").getNome());
	}
	
}
