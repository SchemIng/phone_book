package org.scheming.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.scheming.dao.ClassDao;
import org.scheming.dao.DaoFactory;
import org.scheming.model.User;


/**
 * 更新通知
 * 
 * @author Scheming
 * @Date 2015年5月20日 下午8:57:42
 * @TODO
 */
@WebServlet("/base/notice.action")
public class UpdateNotice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public UpdateNotice() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String notice = request.getParameter("notice");
		String className = ((User) request.getSession().getAttribute("user"))
				.getCla();
		ClassDao dao = (ClassDao) DaoFactory.getClassDaoInstance();

		Map<String, String> newData = new HashMap<String, String>();
		newData.put("class_notice", notice);
		dao.update(className, newData);
		dao.close();
		response.sendRedirect("contact.jsp");
	}

}
