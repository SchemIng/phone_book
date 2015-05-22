package org.scheming.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

/**
 * �������ݿ������
 * 
 * @author Scheming
 * @Date 2015��5��20�� ����8:48:45
 * @TODO
 */
public abstract class BaseDao {

	/**
	 * ���ݿ�����
	 */
	protected Connection connection;

	/**
	 * 
	 * �������
	 * 
	 * @param data
	 *            ������
	 * @author Scheming
	 * @date 2015��5��20�� ����8:49:11
	 * @TODO
	 */
	public abstract void add(Object data);

	/**
	 * ��������
	 * 
	 * @param id
	 *            ����
	 * @param newData
	 *            ������
	 * @author Scheming
	 * @date 2015��5��20�� ����8:49:29
	 * @TODO
	 */
	public abstract void update(String id, Map<String, String> newData);

	/**
	 * ��ѯ����
	 * 
	 * @param id
	 *            ����
	 * @return
	 * @author Scheming
	 * @date 2015��5��20�� ����8:49:53
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
