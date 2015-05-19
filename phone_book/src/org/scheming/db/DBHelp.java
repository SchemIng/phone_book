package org.scheming.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBHelp {
	private static DataSource dataSource = null;

	//JNDI��ʼ��
	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/test");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	/**
	 * ��ȡ���ݿ�����
	 * @return
	 * @throws SQLException
	 * @author Scheming
	 * @date 2015��5��19�� ����8:25:28
	 * @TODO
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
