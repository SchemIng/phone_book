package org.scheming.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scheming.db.UserDAO;
import org.scheming.model.User;

@WebServlet("/base/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String input_id;
	private String input_pw;

	public RegisterServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		input_id = request.getParameter("input_id");
		input_pw = request.getParameter("input_pw");

		User user = new User();
		user.setId(input_id);
		user.setPw(input_pw);

		UserDAO dao = new UserDAO();
		if (dao.checkUser(input_id)) {

		} else {
			dao.add(user);
		}

		dao.close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
