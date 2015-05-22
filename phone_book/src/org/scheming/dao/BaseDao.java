package org.scheming.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * 访问数据库基础类
 * 
 * @author Scheming
 * @Date 2015年5月20日 下午8:48:45
 * @TODO
 */
public abstract class BaseDao {

	/**
	 * 数据库连接
	 */
	protected Connection connection;

	/**
	 * 
	 * 添加数据
	 * 
	 * @param data
	 *            新数据
	 * @author Scheming
	 * @date 2015年5月20日 下午8:49:11
	 * @TODO
	 */
	public abstract void add(Object data);

	/**
	 * 更新数据
	 * 
	 * @param id
	 *            主键
	 * @param newData
	 *            新数据
	 * @author Scheming
	 * @date 2015年5月20日 下午8:49:29
	 * @TODO
	 */
	public abstract void update(String id, Map<String, String> newData);

	/**
	 * 查询数据
	 * 
	 * @param id
	 *            主键
	 * @return
	 * @author Scheming
	 * @date 2015年5月20日 下午8:49:53
	 * @TODO
	 */
	public abstract Object queryData(String id);

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
