package beans;

public class CartaDiCredito {
   private int numero;
   private String intestatrio;
   private String scadenza;
   private int cvv;
   private String email;

   public CartaDiCredito(int numero, String intestatrio, String scadenza, int cvv, String email) {
      this.numero = numero;
      this.intestatrio = intestatrio;
      this.scadenza = scadenza;
      this.cvv = cvv;
      this.email = email;
   }

   public CartaDiCredito() {
   }

   public int getNumero() {
      return this.numero;
   }

   public void setNumero(int numero) {
      this.numero = numero;
   }

   public String getIntestatrio() {
      return this.intestatrio;
   }

   public void setIntestatrio(String intestatrio) {
      this.intestatrio = intestatrio;
   }

   public String getScadenza() {
      return this.scadenza;
   }

   public void setScadenza(String scadenza) {
      this.scadenza = scadenza;
   }

   public int getCvv() {
      return this.cvv;
   }

   public void setCvv(int cvv) {
      this.cvv = cvv;
   }

   public String getEmail() {
      return this.email;
   }

   public void setEmail(String email) {
      this.email = email;
   }

   public String toString() {
      return "CartaDiCredito [numero=" + this.numero + ", intestatrio=" + this.intestatrio + ", scadenza=" + this.scadenza + ", cvv=" + this.cvv + ", email=" + this.email + "]";
   }
}
