package beans;

public class RiepilogoOrdine {
   private int id_riepilogo;

   public RiepilogoOrdine() {
   }

   public RiepilogoOrdine(int id_riepilogo) {
      this.id_riepilogo = id_riepilogo;
   }

   public int getId_riepilogo() {
      return this.id_riepilogo;
   }

   public void setId_riepilogo(int id_riepilogo) {
      this.id_riepilogo = id_riepilogo;
   }

   public String toString() {
      return "RiepilogoOrdine [id_riepilogo=" + this.id_riepilogo + "]";
   }
}
