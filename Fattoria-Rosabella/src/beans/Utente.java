package beans;

public class Utente {
   private String email;
   private String password;
   private String nome;
   private String cognome;
   private String data_nascita;
   private String citta;
   private String indirizzo;
   private int attivo;
   private int id_riepilogo;

   public Utente(String email, String nome, String cognome, String password, String indirizzo, int attivo, String citta, String data_nascita, int id_riepilogo) {
      this.email = email;
      this.nome = nome;
      this.cognome = cognome;
      this.password = password;
      this.indirizzo = indirizzo;
      this.attivo = attivo;
      this.citta = citta;
      this.data_nascita = data_nascita;
      this.id_riepilogo = id_riepilogo;
   }

   public Utente() {
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String getNome() {
      return this.nome;
   }

   public void setNome(String nome) {
      this.nome = nome;
   }

   public String getCognome() {
      return this.cognome;
   }

   public void setCognome(String cognome) {
      this.cognome = cognome;
   }

   public String getPassword() {
      return this.password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getIndirizzo() {
      return this.indirizzo;
   }

   public void setIndirizzo(String indirizzo) {
      this.indirizzo = indirizzo;
   }

   public String getCitta() {
      return this.citta;
   }

   public void setCitta(String citta) {
      this.citta = citta;
   }
   
   public int getAttivo() {
	      return this.attivo;
	   }

	   public void setAttivo(int attivo) {
	      this.attivo = attivo;
	   }

   public String getData_nascita() {
      return this.data_nascita;
   }

   public void setData_nascita(String data_nascita) {
      this.data_nascita = data_nascita;
   }

   public int getId_riepilogo() {
      return this.id_riepilogo;
   }

   public void setId_riepilogo(int id_riepilogo) {
      this.id_riepilogo = id_riepilogo;
   }

   public String toString() {
      return "Utente [email=" + this.email + ", password=" + this.password + ", nome=" + this.nome + ", cognome=" + this.cognome + ", data_nascita=" + this.data_nascita + ", citta=" + this.citta + ", indirizzo=" + this.indirizzo + ", id_riepilogo=" + this.id_riepilogo + "]";
   }
}
