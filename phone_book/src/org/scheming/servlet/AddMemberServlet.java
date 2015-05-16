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

@WebServlet("/addmember.action")
public class AddMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AddMemberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		user.setId(request.getParameter("input_id"));
		user.setPw(request.getParameter("input_id"));
		user.setName(request.getParameter("input_name"));
		user.setQq(request.getParameter("input_qq"));
		user.setTel(request.getParameter("input_tel"));
		user.setCla(request.getParameter("input_class"));

		UserDao dao = (UserDao) DaoFactory.getUserDaoInstance();
		User reUser = (User) dao.queryData(user.getId());
		if (reUser == null) {
			dao.add(user);
			response.sendRedirect("base/contact.jsp");
		} else {

		}
		dao.close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
