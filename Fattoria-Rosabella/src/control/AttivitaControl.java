package control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AttivitaModelDM;

@WebServlet({"/AttivitaControl"})
public class AttivitaControl extends HttpServlet {
   private static final long serialVersionUID = 1L;
   static AttivitaModelDM attivitaModelDM = new AttivitaModelDM();

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      request.removeAttribute("attivita");

      try {
         request.setAttribute("attivita", attivitaModelDM.doRetrieveAll(""));
      } catch (SQLException var4) {
    	  // TODO
      }
      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/attivita.jsp");
      dispatcher.forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
}
