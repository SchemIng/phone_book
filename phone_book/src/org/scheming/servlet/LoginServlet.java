package org.scheming.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scheming.dao.DaoFactory;
import org.scheming.dao.UserDao;
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
		UserDao dao = (UserDao) DaoFactory.getUserDaoInstance();
		User user = (User) dao.queryData(input_id);
		if (user == null) {
			request.setAttribute("error_msg", "用户不存在");
			request.getRequestDispatcher("base/error.jsp").forward(request,
					response);
			// response.sendRedirect("/base/error.jsp");
		} else {
			if (input_pw.equals(user.getPw())) {
				request.getSession().setAttribute("user_id", input_id);
				request.getSession().setAttribute("user", user);
				request.getSession()
						.setAttribute("ismaster", Boolean.valueOf(user.isIsmaster()));
				response.sendRedirect("base/contact.jsp");
			} else {
				request.setAttribute("error_msg", "密码错误");
				request.getRequestDispatcher("base/error.jsp").forward(request,
						response);
			}
		}
		dao.close();

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
