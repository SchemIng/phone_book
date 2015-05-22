package org.scheming.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.scheming.db.DBHelp;
import org.scheming.model.User;

/**
 * 
 * @author Scheming
 * @Date 2015年5月20日 下午8:54:01
 * @TODO
 */
public class UserDao extends BaseDao {

	private Statement statement;

	{
		try {
			connection = DBHelp.getConnection();
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see org.scheming.dao.BaseDao#add(java.lang.Object)
	 */
	@Override
	public void add(Object data) {
		User user = (User) data;
		String sql = "insert into test.user (`id`,`pw`,`class`,`tel`,`qq`,`name`,`ismaster`) values('"
				+ user.getId()
				+ "','"
				+ user.getPw()
				+ "','"
				+ user.getCla()
				+ "','"
				+ user.getTel()
				+ "','"
				+ user.getQq()
				+ "','"
				+ user.getName() + "'," + user.isIsmaster() + ");";
		try {
			statement.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see org.scheming.dao.BaseDao#update(java.lang.String, java.util.Map)
	 */
	@Override
	public void update(String id, Map<String, String> newData) {
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
	 * 查询用户的同班同学
	 * 
	 * @param id
	 * @return
	 * @author Scheming
	 * @date 2015年5月20日 下午8:51:35
	 * @TODO
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

	/*
	 * （非 Javadoc）
	 * 
	 * @see org.scheming.dao.BaseDao#queryData(java.lang.String)
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
						results.getString("qq"), results.getString("path"),
						results.getBoolean("ismaster"));
				user.setPath(results.getString("path"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

	/**
	 * 删除用户
	 * 
	 * @param id
	 *            用户学号
	 * @author Scheming
	 * @date 2015年5月20日 下午8:52:07
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
	 * 搜索
	 * 
	 * @param name
	 * @return
	 * @author Scheming
	 * @date 2015年5月20日 下午8:52:25
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
						.getString("qq"), results.getString("path"), results
						.getBoolean("ismaster")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}

}
