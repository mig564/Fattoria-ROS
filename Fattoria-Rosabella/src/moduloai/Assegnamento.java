package moduloai;

public class Assegnamento {
	private int bambino, meteo, partecipanti, tipo;
	
	public Assegnamento() {
		bambino = -1;
		meteo = -1;
		partecipanti = -1;
		tipo = -1;
	}
	
	public boolean isCompleto() {
		if(bambino == -1 || meteo == -1 || partecipanti == -1 || tipo == -1) return false;
		return true;
	}
	
	public int getVariabile() {
		if(bambino == -1) return 0;
		if(tipo == -1) return 1;
		if(meteo == -1) return 2;
		if(partecipanti == -1) return 3;
		return 4;
	}
	
	public void setValore(int valore) {
		switch (valore) {
		case 0:	this.setBambino(1); break;
		case 1:	this.setTipo(1); break;
		case 2:	this.setMeteo(1); break;
		case 3:	this.setPartecipanti(1); break;
		default:
			break;
		}
	}

	public int isBambino() {
		return bambino;
	}

	public void setBambino(int bambino) {
		this.bambino = bambino;
	}

	public int isMeteo() {
		return meteo;
	}

	public void setMeteo(int meteo) {
		this.meteo = meteo;
	}

	public int isPartecipanti() {
		return partecipanti;
	}

	public void setPartecipanti(int partecipanti) {
		this.partecipanti = partecipanti;
	}

	public int isTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Assegnamento [bambino=" + bambino + ", meteo=" + meteo + ", partecipanti=" + partecipanti + ", tipo="
				+ tipo + "]";
	}
}
