package beans;

public class Formare {
   private int id_riepilogo;
   private int id_attivita;
   private String date;
   private String ora;
   private int partecipanti;

   public Formare(int id_riepilogo, int id_attivita, String date, String ora, int partecipanti) {
      this.id_riepilogo = id_riepilogo;
      this.id_attivita = id_attivita;
      this.date = date;
      this.ora = ora;
      this.partecipanti = partecipanti;
   }

   public Formare() {
   }

   public int getId_riepilogo() {
      return this.id_riepilogo;
   }

   public void setId_riepilogo(int id_riepilogo) {
      this.id_riepilogo = id_riepilogo;
   }

   public int getId_attivita() {
      return this.id_attivita;
   }

   public void setId_attivita(int id_attivita) {
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

   public int getPartecipanti() {
      return this.partecipanti;
   }

   public void setPartecipanti(int partecipanti) {
      this.partecipanti = partecipanti;
   }

   public String toString() {
      return "Formare [id_riepilogo=" + this.id_riepilogo + ", id_attivita=" + this.id_attivita + ", date=" + this.date + ", ora=" + this.ora + ", partecipanti=" + this.partecipanti + "]";
   }

   @Override
   public boolean equals(Object obj) {
	   if (this == obj)
		   return true;
	   if (obj == null)
		   return false;
	   if (getClass() != obj.getClass())
		   return false;
	   Formare other = (Formare) obj;
	   if (id_attivita != other.id_attivita)
		   return false;
	   return true;
   } 
   
}
