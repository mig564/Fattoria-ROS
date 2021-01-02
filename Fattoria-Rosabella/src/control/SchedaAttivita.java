package control;

import beans.Attivita;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AttivitaModelDM;

@WebServlet({"/SchedaAttivita"})
public class SchedaAttivita extends HttpServlet {
   private static final long serialVersionUID = 1L;
   AttivitaModelDM attivitaModelDM = new AttivitaModelDM();

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      String id = request.getParameter("id");
      if (id != null) {
         request.removeAttribute("attivita");

         try {
            Attivita attivita = this.attivitaModelDM.doRetrieveByKey(id);
            request.setAttribute("attivita", attivita);
         } catch (SQLException var5) {
        	 // TODO
         }
      }
      RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/schedaattivita.jsp");
      dispatcher.forward(request, response);
   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
}
