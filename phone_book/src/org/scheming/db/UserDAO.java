package org.scheming.db;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.scheming.model.User;

public class UserDAO {

	private Connection connection;
	private Statement statement;

	public UserDAO() {
		connection = DBHelp.getConnection();
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void add(User user) {
		String sql = "insert into user values('" + user.getId() + "','"
				+ user.getPw() + "','" + user.getCla() + "','" + user.getTel()
				+ "','" + user.getQq() + "','" + user.getName() + "',"
				+ user.isIsmaster() + ");";
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println(sql);
	}

	public void updateUser(String id, Map<String, String> newData) {
		try {

			for (String key : newData.keySet()) {
				statement.executeUpdate("update user set " + key + "='"
						+ newData.get(key) + "' where id='" + id + "';");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// /**
	// * @param id
	// * @return true 存在该用户
	// */
	// public boolean checkUser(String id) {
	//
	// try {
	// ResultSet results = statement
	// .executeQuery("select * from user where id=" + id + ";");
	// if (results.next()) {
	// return true;
	// }
	//
	// } catch (SQLException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	//
	// return false;
	// }

	// /**
	// * 检查密码
	// *
	// * @param id
	// * @param pw
	// * @return
	// */
	// public boolean checkPw(String id, String pw) {
	// try {
	// ResultSet results = statement
	// .executeQuery("select * from user where id=" + id + ";");
	// if (results.next() && pw.equals(results.getString("pw"))) {
	// return true;
	// } else {
	// return false;
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	// return false;
	// }

	/**
	 * 查询班级里所有人信息
	 * 
	 * @param id
	 * @return
	 */
	public ResultSet queryClassData(String id) {
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

	/**
	 * 查询用户信息
	 * 
	 * @param id
	 * @return
	 */
	public User queryUserData(String id) {
		ResultSet results;
		User user = null;
		try {
			results = statement.executeQuery("select * from user where id="
					+ id + ";");
			while (results.next()) {
				user = new User(results.getString("id"),
						results.getString("name"), results.getString("pw"),
						results.getString("class"), results.getString("tel"),
						results.getString("qq"), false);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
