package org.scheming.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DBHelp {
	static Connection connection;

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver"); // �������ݿ�������ע�ᵽ����������
			String url = "jdbc:mysql://localhost:3306/test"; // ���ݿ������ַ���
			String username = "root"; // ���ݿ��û���
			String password = "shy66017"; // ���ݿ�����
			connection = DriverManager.getConnection(url, username, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public void createTable(String tab, List<String> column) {

	}
	//
	// public static void destroy() {
	// if (connection != null) {
	// try {
	// connection.close();
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// }
	// }
}
