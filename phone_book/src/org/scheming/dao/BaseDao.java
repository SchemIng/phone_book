package org.scheming.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * 
 * @author Scheming
 * @Date 2015��5��10�� ����2:01:50
 * @TODO
 */
public abstract class BaseDao {

	protected Connection connection;

	/**
	 * ���
	 * 
	 * @param data
	 * @author Scheming
	 * @date 2015��5��10�� ����5:06:56
	 * @TODO
	 */
	public abstract void add(Object data);

	/**
	 * ����
	 * 
	 * @param id
	 * @param newData
	 * @author Scheming
	 * @date 2015��5��10�� ����5:06:57
	 * @TODO
	 */
	public abstract void updateUser(String id, Map<String, String> newData);

	/**
	 * ��ѯ
	 * 
	 * @param id
	 * @return
	 * @author Scheming
	 * @date 2015��5��10�� ����5:07:00
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
