package moduloai;

import java.util.ArrayList;

import beans.Attivita;

public class Dominio {
	
	private Attivita attivita;
	private ArrayList<Integer> bambino;
	private ArrayList<Integer> tipo; //0=relax, 1=cardio, 2=culturale
	private ArrayList<Integer> meteo;
	private ArrayList<Integer> partecipanti;
	
	public Dominio(Attivita attivita) {
		this.attivita = attivita;
		bambino = new ArrayList<Integer>();
		bambino.add(0);
		bambino.add(1);
		
		tipo = new ArrayList<Integer>();
		for(int i=0; i<3; i++) tipo.add(i);
		
		meteo = new ArrayList<Integer>();
		for(int i=0; i<1; i++) meteo.add(i);
		
		partecipanti = new ArrayList<Integer>();
		for(int i=1; i<=attivita.getMax_persone(); i++) partecipanti.add(i);
	}

	public Attivita getAttivita() {
		return attivita;
	}

	public void setAttivita(Attivita attivita) {
		this.attivita = attivita;
	}

	public ArrayList<Integer> getBambino() {
		return bambino;
	}

	public void setBambino(ArrayList<Integer> bambino) {
		this.bambino = bambino;
	}

	public ArrayList<Integer> getTipo() {
		return tipo;
	}

	public void setTipo(ArrayList<Integer> tipo) {
		this.tipo = tipo;
	}

	public ArrayList<Integer> getMeteo() {
		return meteo;
	}

	public void setMeteo(ArrayList<Integer> meteo) {
		this.meteo = meteo;
	}

	public ArrayList<Integer> getPartecipanti() {
		return partecipanti;
	}

	public void setPartecipanti(ArrayList<Integer> partecipanti) {
		this.partecipanti = partecipanti;
	}

	@Override
	public String toString() {
		return "Dominio [bambino=" + bambino + ", tipo=" + tipo + ", meteo=" + meteo + ", partecipanti=" + partecipanti
				+ "]";
	}
}
