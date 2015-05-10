package org.scheming.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scheming.dao.DaoFactory;
import org.scheming.dao.UserDao;

@WebServlet("/base/update.action")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		UserDao dao = (UserDao) DaoFactory.getUserDaoInstance();
		Map<String, String> newUser = new HashMap<String, String>();
		newUser.put("class", request.getParameter("input_class"));
		newUser.put("tel", request.getParameter("input_tel"));
		newUser.put("qq", request.getParameter("input_qq"));
		newUser.put("name", request.getParameter("input_name"));
		dao.updateUser(request.getSession().getAttribute("user_id").toString(),
				newUser);
		response.sendRedirect("contact.jsp");

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
