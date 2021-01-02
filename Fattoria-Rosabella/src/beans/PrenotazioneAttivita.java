package beans;

public class PrenotazioneAttivita {

	private int id_attivita;
	private int id_prenotazione;
	private String date;
	private String ora;
	
	public PrenotazioneAttivita() {
	}
	
	public PrenotazioneAttivita(int id_attivita, int id_prenotazione, String date, String ora) {
		this.id_attivita = id_attivita;
		this.id_prenotazione = id_prenotazione;
		this.date = date;
		this.ora = ora;
	}

	public int getId_attivita() {
		return id_attivita;
	}

	public void setId_attivita(int id_attivita) {
		this.id_attivita = id_attivita;
	}

	public int getId_prenotazione() {
		return id_prenotazione;
	}

	public void setId_prenotazione(int id_prenotazione) {
		this.id_prenotazione = id_prenotazione;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOra() {
		return ora;
	}

	public void setOra(String ora) {
		this.ora = ora;
	}

	@Override
	public String toString() {
		return "PrenotazioneAttivita [id_attivita=" + id_attivita + ", id_prenotazione=" + id_prenotazione + ", date="
				+ date + ", ora=" + ora + "]";
	}
	
}
