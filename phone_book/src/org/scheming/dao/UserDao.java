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

public class UserDao implements IDAO {

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
	}

	@Override
	public void updateUser(String id, Map<String, String> newData) {
		try {

			for (String key : newData.keySet()) {
				String sql = "update user set " + key + "='" + newData.get(key)
						+ "' where id='" + id + "';";
				statement.executeUpdate(sql);
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
	public Object queryData(String id) {
		ResultSet results;
		User user = null;
		try {
			results = statement.executeQuery("select * from user where id="
					+ id + ";");
			while (results.next()) {
				user = new User(results.getString("id"),
						results.getString("name"), results.getString("pw"),
						results.getString("class"), results.getString("tel"),
						results.getString("qq"), results.getBoolean("ismaster"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	/**
	 * 删除
	 * 
	 * @param id
	 * @author Scheming
	 * @date 2015年5月15日 下午2:15:09
	 * @TODO
	 */
	public void delete(String id) {
		try {
			statement.execute("DELETE FROM `test`.`user` WHERE `id`='" + id
					+ "';");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param name
	 * @return
	 * @author Scheming
	 * @date 2015年5月15日 下午2:25:14
	 * @TODO
	 */
	public List<User> queryByName(String name) {
		List<User> users = new ArrayList<User>();
		try {
			ResultSet results = statement
					.executeQuery("select * from user where name='" + name
							+ "';");
			while (results.next()) {
				users.add(new User(results.getString("id"), results
						.getString("name"), results.getString("pw"), results
						.getString("class"), results.getString("tel"), results
						.getString("qq"), results.getBoolean("ismaster")));
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
