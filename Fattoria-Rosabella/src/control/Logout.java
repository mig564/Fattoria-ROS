package control;

import beans.Formare;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.FormareModelDM;

@WebServlet({"/Logout"})
public class Logout extends HttpServlet {
   private static final long serialVersionUID = 1L;
   private static FormareModelDM formareModelDM = new FormareModelDM();

   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      HttpSession session = request.getSession(true);
      if (session != null) {
         @SuppressWarnings("unchecked")
		ArrayList<Formare> formCart = (ArrayList<Formare>)request.getSession().getAttribute("formCart");

         try {
            formareModelDM.doDelete(new Formare((Integer)request.getAttribute(""), 0, "", "", 0));
            Iterator<Formare> var6 = formCart.iterator();

            while(var6.hasNext()) {
               Formare formare = (Formare)var6.next();
               formareModelDM.doSave(formare);
            }
         } catch (SQLException var7) {
         }

         session.invalidate();
         response.sendRedirect("index.jsp");
      }

   }

   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request, response);
   }
}
