package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Admin;
import model.AdminModelDM;

/**
 * Servlet implementation class LoginAdmin
 */
@WebServlet("/LoginAdmin")
public class LoginAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		String redirectedPage;
		try {
			checkLogin(username, password);
			request.getSession().setAttribute("adminFilterRoles", true);
			redirectedPage = "/areariservata.jsp";
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(redirectedPage);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			request.getSession().removeAttribute("adminFilterRoles");
			redirectedPage = "/login-form-filter.jsp";
			response.sendRedirect(request.getContextPath() + redirectedPage);
		}
	}
	
	private void checkLogin(String email, String password) throws Exception {
		AdminModelDM adminModel = new AdminModelDM();
		Admin admin = adminModel.doRetrieveByKey(email);
		if (admin != null && admin.getEmail().equals(email) && admin.getPassword().equals(password)) {
			//
		} else {
			throw new Exception("Invalid login and password");
		}
	}

}
