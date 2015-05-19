package org.scheming.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * 
 * @author Scheming
 * @Date 2015年5月10日 下午2:01:50
 * @TODO
 */
public abstract class BaseDao {

	protected Connection connection;

	/**
	 * 添加
	 * 
	 * @param data
	 * @author Scheming
	 * @date 2015年5月10日 下午5:06:56
	 * @TODO
	 */
	public abstract void add(Object data);

	/**
	 * 更新
	 * 
	 * @param id
	 * @param newData
	 * @author Scheming
	 * @date 2015年5月10日 下午5:06:57
	 * @TODO
	 */
	public abstract void updateUser(String id, Map<String, String> newData);

	/**
	 * 查询
	 * 
	 * @param id
	 * @return
	 * @author Scheming
	 * @date 2015年5月10日 下午5:07:00
	 * @TODO
	 */
	public abstract Object queryData(String id);

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		connection = null;
	}

}
