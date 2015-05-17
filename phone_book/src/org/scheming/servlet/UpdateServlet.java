package org.scheming.servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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

	}

	/**
	 * @param request
	 * @author Scheming
	 * @date 2015年5月17日 下午1:22:25
	 * @TODO
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String path = "F:/user_head/user_head_";
		String name = "";

		UserDao dao = (UserDao) DaoFactory.getUserDaoInstance();
		Map<String, String> newUser = new HashMap<String, String>();

		Iterator<FileItem> iterator = Init(request);
		FileItem head = null;

		while (iterator.hasNext()) {
			FileItem item = iterator.next();
			if (!item.isFormField() && item.getString() != null) {
				name = item.getName();
				try {
					head = item;
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (item.isFormField()) {
				newUser.put(item.getFieldName(), item.getString("UTF-8"));
			}
		}
		name = name.substring(name.indexOf('.'));
		try {
			head.write(new File(path + newUser.get("id") + name));
		} catch (Exception e) {
			e.printStackTrace();
		}

		newUser.put("path", "user_head_" + newUser.get("id") + name);
		dao.updateUser(newUser.get("id"), newUser);
		response.sendRedirect("contact.jsp");
		dao.close();
	}

	/**
	 * @param request
	 * @return
	 * @author Scheming
	 * @date 2015年5月17日 下午3:03:47
	 * @TODO
	 */
	private Iterator<FileItem> Init(HttpServletRequest request) {
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();

		// Configure a repository (to ensure a secure temp location is used)
		ServletContext servletContext = this.getServletConfig()
				.getServletContext();
		File repository = (File) servletContext
				.getAttribute("javax.servlet.context.tempdir");
		factory.setRepository(repository);

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);

		// Parse the request
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}

		// Process the uploaded items
		Iterator<FileItem> iterator = items.iterator();
		return iterator;
	}

}
