package beans;

public class Attivita {
   private int id_attivita;
   private String categoria;
   private String nome;
   private String descrizione;
   private int max_persone;
   private int prezzo;

   public Attivita() {
   }

   public Attivita(int id_attivita, String categoria, String nome, String descrizione, int max_persone, int prezzo) {
      this.id_attivita = id_attivita;
      this.categoria = categoria;
      this.nome = nome;
      this.descrizione = descrizione;
      this.max_persone = max_persone;
      this.prezzo = prezzo;
   }

   public int getId_attivita() {
      return this.id_attivita;
   }

   public void setId_attivita(int id_attivita) {
      this.id_attivita = id_attivita;
   }

   public String getCategoria() {
      return this.categoria;
   }

   public void setCategoria(String categoria) {
      this.categoria = categoria;
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getDescrizione() {
	   return descrizione;
   }
   
   public void setDescrizione(String descrizione) {
	   this.descrizione = descrizione;
   }
   
   public int getMax_persone() {
      return this.max_persone;
   }

   public void setMax_persone(int max_persone) {
      this.max_persone = max_persone;
   }

   public int getPrezzo() {
      return this.prezzo;
   }

   public void setPrezzo(int prezzo) {
      this.prezzo = prezzo;
   }

   public String toString() {
      return "Attivita [id_attivita=" + this.id_attivita + ", categoria=" + this.categoria + ",descrizione="+ descrizione + ",nome=" + this.nome + ", max_persone=" + this.max_persone + ", prezzo=" + this.prezzo + "]";
   }
}
