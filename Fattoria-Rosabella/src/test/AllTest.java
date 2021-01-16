package test;

import junit.framework.Test;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class AllTest {
	
	public static Test suite() {
		TestSuite s = new TestSuite(); 
		s.addTest(AttivitaTest.suite());
		s.addTest(CalendarioTest.suite());
		s.addTest(CartaDiCreditoTest.suite());
		s.addTest(FormareTest.suite());
		s.addTest(GestoreTest.suite());
		s.addTest(PrenotazioneAttivitaTest.suite());
		s.addTest(PrenotazioneTest.suite());
		s.addTest(RiepilogoOrdineTest.suite());
		s.addTest(UtenteTest.suite());
		return s;
	}
	
	public static void main(String[] args) {
		TestRunner.run(suite());
	}

}
