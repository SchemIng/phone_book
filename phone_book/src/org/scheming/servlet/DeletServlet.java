package org.scheming.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scheming.dao.DaoFactory;
import org.scheming.dao.UserDao;

@WebServlet("/base/delete.action")
public class DeletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String id;

	public DeletServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		id = request.getParameter("user_id");
		((UserDao) DaoFactory.getUserDaoInstance()).delete(id);
		response.sendRedirect("contact.jsp");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
