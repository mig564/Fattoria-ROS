package moduloai;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;

import beans.Attivita;

public class ModuloAI {
	private static ArrayList<Integer> i = new ArrayList<Integer>();
	private static Dominio dominio;
	
	public static Collection<Attivita> cerca(Collection<Attivita> attivitas, int bambino, int tipologia, int min, int max) {
		Assegnamento assegnamento = new Assegnamento();
		Collection<Attivita> attivita = new LinkedList<Attivita>();
		for (Attivita a : attivitas) {
			dominio = new Dominio(a);
			if(backtracking(assegnamento, bambino, tipologia, min, max).isCompleto()) {
				attivita.add(a);
			}
		}
		return attivita;
	}
	
	private static Assegnamento backtracking(Assegnamento assegnamento, int bambino2, int tipologia, int min, int max) {
		
		if(assegnamento.isCompleto()) return assegnamento;
		
		int var = assegnamento.getVariabile(); // Scegliamo la variabile pi� piccola non assegnata (Passo 1: bambino)
		
		if(var == 0) i = dominio.getBambino();
		else if(var == 1) i = dominio.getTipo();
		else if(var == 2) i = dominio.getMeteo();
		else if(var == 3) i = dominio.getPartecipanti();

		for(Integer valore : i) { // Per ogni valore (true o false) assegnamo un valore (Passo 2: bambino = true)
			if(assegnamentoConsistente(var, valore,  bambino2, tipologia, min, max)) { // Controllo se assegnamento � consistente (Passo 3: utente ha messo si, dunque per bambino = true assegnamento consistente)
				assegnamento.setValore(var); // Aggiungi ad attivit�
				assegnamento = backtracking(assegnamento, bambino2, tipologia, min, max); // Richiamiamo backtracking
			}
			if(assegnamento.isCompleto()) return assegnamento;	
		}
		return assegnamento;
	}

	private static boolean assegnamentoConsistente(int var, int valore, int bambino2, int tipologia, int min, int max) {
		if(var == 0) {
			if ((valore == bambino2) && bambino2 == 0) return true; 
			else if ((valore == bambino2) && bambino2 == 1) {
				if (dominio.getAttivita().getCategoria().equals("Visita guidata") || dominio.getAttivita().getCategoria().equals("Ristoro")) 
					return true;
			}
		}
		if(var == 1) {
			if((valore == tipologia) && tipologia == 0) {
				if (dominio.getAttivita().getCategoria().equals("Balneazione"))
					return true;
			}
			else if((valore == tipologia) && tipologia == 1) {
				if (dominio.getAttivita().getCategoria().equals("Escursione"))
					return true;
			}
			else if((valore == tipologia) && tipologia == 2) {
				if (dominio.getAttivita().getCategoria().equals("Visita guidata"))
					return true;
			}
		}
		if(var == 2) {
			return true; //Aggiungere check meteo
		}
		if(var == 3) {
			if(min <= valore && max >= valore) return true;
		}
		return false;
	}



	/*private static boolean condizioniMeteo() throws IOException {
		System.out.println("STAMPA CONDIZIONE METEO PRIMA");
		URL url = new URL("https://www.meteo.it/meteo/avellino-64008");
		Scanner scanner = new Scanner(url.openStream());
		while(scanner.hasNext()) {
			String riga = scanner.next();
			if(riga.subSequence(0, 3).equals("alt=")) {
				System.out.println(riga);
			}
		}
		scanner.close();
		System.out.println("STAMPA CONDIZIONE METEO DOPO");
		return false;
	}*/
	
}
