package test;

import java.sql.SQLException;
import java.util.Random;

import beans.Attivita;
import beans.Formare;
import beans.RiepilogoOrdine;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import model.AttivitaModelDM;
import model.FormareModelDM;
import model.RiepilogoOrdineModelDM;

public class FormareModelTest extends TestCase {

	private static FormareModelDM modelForm = new FormareModelDM();
	private static RiepilogoOrdineModelDM ordineModelDM = new RiepilogoOrdineModelDM();
	private static AttivitaModelDM attivitaModelDM = new AttivitaModelDM();
	private static Random ra = new Random();
	private RiepilogoOrdine riep;
	private Attivita attivita;
	private Formare form;
	private int re;
	
	@Override
	protected void setUp() throws Exception {
		re = ra.nextInt();
		form  = new Formare(re, re, "2025-12-01", "05:00:00", 5);
		riep = new RiepilogoOrdine(re);
		attivita =new Attivita(re, "", "", "", 5, 5);
		attivitaModelDM.doSave(attivita);
		ordineModelDM.doSave(riep);
	}

	public void testDoSave() throws SQLException {
		modelForm.doSave(form);
		assertEquals(form.toString(), modelForm.doRetrieveByKey(""+re).toString());
		modelForm.doDelete(form);
	}
	
	public void testDoRetrieveByKey() throws SQLException {
		modelForm.doSave(form);
		Formare db = modelForm.doRetrieveByKey(""+re);
		assertEquals(db.toString(), form.toString());
		modelForm.doDelete(form);
	}
	
	public void testDoUpdate() throws SQLException {
		modelForm.doSave(form);
		form.setPartecipanti(500);
		modelForm.doUpdate(form);
		assertEquals(form.getPartecipanti(), modelForm.doRetrieveByKey(""+re).getPartecipanti());
		modelForm.doDelete(form);
	}
	
	public void testDoDelete() throws SQLException {
		modelForm.doSave(form);
		modelForm.doDelete(form);
		assertEquals(new Formare().toString(), modelForm.doRetrieveByKey(""+re).toString());
	}
	
	@Override
	protected void tearDown() throws Exception {
		ordineModelDM.doDelete(riep);
		attivitaModelDM.doDelete(attivita);
	}

	public static Test suite() {
		return new TestSuite(FormareModelTest.class);
	}
}
