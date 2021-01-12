package control;

import beans.Formare;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.FormareModelDM;

/**
 * @author pa.ni.ca
 * Servlet implementation class Logout
 * Questa servlet fa il logout dell'utente
 */
@WebServlet({"/Logout"})
public class Logout extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private static FormareModelDM formareModelDM = new FormareModelDM();

   /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession(true);
      if (session != null) {
        @SuppressWarnings("unchecked")
		ArrayList<Formare> formCart = (ArrayList<Formare>) request.getSession().getAttribute("formCart");
        int id_riepilogo = (int) request.getSession().getAttribute("carrello");
        try {
            formareModelDM.doDelete(new Formare(id_riepilogo, 0, "", "", 0));
            for (Formare formare : formCart) {
            	formareModelDM.doSave(formare);
            }
         } catch (SQLException var7) {
        	 var7.printStackTrace();
         }
         session.invalidate();
         response.sendRedirect("index.jsp");
      }
   }
   
   /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
}
