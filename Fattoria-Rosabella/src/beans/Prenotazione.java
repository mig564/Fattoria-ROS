package beans;

public class Prenotazione {
   private int id_prenotazione;
   private int prezzo;
   private int id_riepilogo;

   public Prenotazione() {
   }

   public Prenotazione(int id_prenotazione, String date, String ora, int prezzo, int id_riepilogo) {
      this.id_prenotazione = id_prenotazione;
      this.prezzo = prezzo;
      this.id_riepilogo = id_riepilogo;
   }

   public int getId_prenotazione() {
      return this.id_prenotazione;
   }

   public void setId_prenotazione(int id_prenotazione) {
      this.id_prenotazione = id_prenotazione;
   }

   public int getPrezzo() {
      return this.prezzo;
   }

   public void setPrezzo(int prezzo) {
      this.prezzo = prezzo;
   }

   public int getId_riepilogo() {
      return this.id_riepilogo;
   }

   public void setId_riepilogo(int id_riepilogo) {
      this.id_riepilogo = id_riepilogo;
   }

   public String toString() {
      return "Prenotazione [id_prenotazione=" + this.id_prenotazione + ",prezzo=" + this.prezzo + ", id_riepilogo=" + this.id_riepilogo + "]";
   }
}
