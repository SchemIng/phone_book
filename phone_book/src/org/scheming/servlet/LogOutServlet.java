package org.scheming.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登出
 * 
 * @author Scheming
 * @Date 2015年5月20日 下午8:55:55
 * @TODO
 */
@WebServlet("/base/logout.action")
public class LogOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LogOutServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		request.removeAttribute("user_id");
		request.removeAttribute("user");
		request.removeAttribute("ismaster");
		response.sendRedirect("../index.html");
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

}
