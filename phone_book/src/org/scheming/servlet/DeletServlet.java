package org.scheming.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scheming.dao.DaoFactory;
import org.scheming.dao.UserDao;

/**
 * ����Աɾ������
 * @author Scheming
 * @Date 2015��5��19�� ����8:33:30
 * @TODO
 */
@WebServlet("/base/delete.action")
public class DeletServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DeletServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("user_id");
		UserDao dao = (UserDao) DaoFactory.getUserDaoInstance();
		//ɾ���û�
		dao.delete(id);
		response.sendRedirect("contact.jsp");
		dao.close();
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
