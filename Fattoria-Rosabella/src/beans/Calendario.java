package beans;

public class Calendario {
   private String date;
   private String ora;
   private int id_attivita;

   public Calendario() {
   }

   public Calendario(String date, String ora, int id_attivita) {
      this.date = date;
      this.ora = ora;
      this.id_attivita = id_attivita;
   }

   public String getDate() {
      return this.date;
   }

   public void setDate(String date) {
      this.date = date;
   }

   public String getOra() {
      return this.ora;
   }

   public void setOra(String ora) {
      this.ora = ora;
   }

   public int getId_attivita() {
      return this.id_attivita;
   }

   public void setId_attivita(int id_attivita) {
      this.id_attivita = id_attivita;
   }

   public String toString() {
      return this.getClass().getName() + "[date=" + this.date + ", ora=" + this.ora + ", id_attivita=" + this.id_attivita + "]";
   }
}
