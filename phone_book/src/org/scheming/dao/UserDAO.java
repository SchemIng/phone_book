package org.scheming.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.scheming.db.DBHelp;
import org.scheming.model.User;

public class UserDAO implements IDAO {

	private Connection connection;
	private Statement statement;

	{
		try {
			connection = DBHelp.getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 添加用户
	 * 
	 * @param data
	 */
	@Override
	public void add(Object data) {
		User user = (User) data;
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

	@Override
	public void updateUser(String id, Map<String, String> newData) {
		try {

			for (String key : newData.keySet()) {
				String sql = "update user set " + key + "='" + newData.get(key)
						+ "' where id='" + id + "';";
				statement.executeUpdate(sql);
				System.out.println(sql);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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
	@Override
	public List<Object> queryData(String id) {
		ResultSet results;
		List<Object> users = new ArrayList<Object>();
		User user = null;
		try {
			results = statement.executeQuery("select * from user where id="
					+ id + ";");
			while (results.next()) {
				user = new User(results.getString("id"),
						results.getString("name"), results.getString("pw"),
						results.getString("class"), results.getString("tel"),
						results.getString("qq"), false);
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
