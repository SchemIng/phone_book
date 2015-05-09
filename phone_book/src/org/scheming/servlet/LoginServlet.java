package org.scheming.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scheming.db.UserDAO;
import org.scheming.model.User;

@WebServlet("/login.action")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String input_id;
	private String input_pw;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		input_id = request.getParameter("input_id");
		input_pw = request.getParameter("input_pw");
		UserDAO dao = new UserDAO();
		User user = dao.queryUserData(input_id);
		if (user == null) {
			request.setAttribute("error_msg", "�û�������");
			request.getRequestDispatcher("base/error.jsp").forward(request,
					response);
			// response.sendRedirect("/base/error.jsp");
		} else {
			if (input_pw.equals(user.getPw())) {
//				getServletContext().setAttribute(input_id, user);
//				request.getRequestDispatcher("base/contact.jsp").forward(
//						request, response);

				request.getSession().setAttribute("user_id", input_id);
				 response.sendRedirect("base/contact.jsp");
			} else {
				request.setAttribute("error_msg", "�������");
				request.getRequestDispatcher("base/error.jsp").forward(request,
						response);
			}
		}

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
