package org.scheming.servlet;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.scheming.model.User;

@WebServlet("/base/export.action")
public class ExportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExportServlet() {
		super();
	}

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		List<User> lists = (List<User>) getServletContext().getAttribute(
				"lists_" + request.getSession().getAttribute("user_id"));

		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition", "inline; filename="
				+ "phone_book.xls");

		OutputStream outputStream = response.getOutputStream();
		doExcle(outputStream, lists);

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

	private void doExcle(OutputStream outputStream, List<User> lists) {

		String[] column = { "学号", "姓名", "电话", "QQ" };

		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet(lists.get(0).getCla());
		sheet.setDefaultColumnWidth(20);

		for (int i = 0; i < lists.size() + 1; i++) {
			HSSFRow row = sheet.createRow(i);
			if (i == 0) {
				for (int j = 0; j < column.length; j++) {
					HSSFCell cell = row.createCell(j);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell.setCellValue(column[j]);
				}
			} else {
				User user = lists.get(i - 1);
				for (int j = 0; j < column.length; j++) {
					HSSFCell cell = row.createCell(j);
					cell.setCellType(HSSFCell.CELL_TYPE_STRING);
					switch (j) {
					case 0:
						cell.setCellValue(user.getId());
						break;
					case 1:
						cell.setCellValue(user.getName());
						break;
					case 2:
						cell.setCellValue(user.getTel());
						break;
					case 3:
						cell.setCellValue(user.getQq());
						break;
					}
				}
			}

		}

		try {
			workbook.write(outputStream);
			outputStream.flush();
			outputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
