package org.scheming.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scheming.dao.DAOFactory;
import org.scheming.dao.UserDAO;
import org.scheming.model.User;

@WebServlet("/register.action")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		User user = new User();
		user.setId(request.getParameter("input_id"));
		user.setPw(request.getParameter("input_pw"));
		user.setName(request.getParameter("input_name"));
		user.setQq(request.getParameter("input_qq"));
		user.setTel(request.getParameter("input_tel"));
		user.setCla(request.getParameter("input_class"));

		UserDAO dao = (UserDAO) DAOFactory.getUserDaoInstance();
		User reUser = (User) dao.queryData(user.getId()).get(0);
		if (reUser == null) {
			dao.add(user);
		} else {

		}

		dao.close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
