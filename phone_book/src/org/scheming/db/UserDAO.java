package org.scheming.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.scheming.model.User;

public class UserDAO {

	private Connection connection;
	private Statement statement;

	public UserDAO() {
		connection = DBHelp.getConnection();
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void add(User user) {
		try {
			statement.execute("insert into user values('" + user.getId()
					+ "','" + user.getPw() + "');");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param id
	 * @return true 存在该用户
	 */
	public boolean checkUser(String id) {

		try {
			ResultSet results = statement
					.executeQuery("select * from user where id=" + id + ";");
			if (results.next()) {
				return true;
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	public boolean checkPw(String id, String pw) {
		try {
			ResultSet results = statement
					.executeQuery("select * from user where pw=" + pw + ";");
			if (results.next() && pw.equals(results.getString("pw"))) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public ResultSet queryData(String id) {
		String cla = null;
		ResultSet results = null;
		try {
			results = statement.executeQuery("select * from user where id="
					+ id + ";");
			if (results.next()) {
				cla = results.getString("class");
			}
			results = statement.executeQuery("select * from user where class='"
					+ cla + "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return results;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
