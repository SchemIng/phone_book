package org.scheming.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBHelp {
	private static DataSource dataSource = null;

	//JNDI初始化
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
	 * 获取数据库连接
	 * @return
	 * @throws SQLException
	 * @author Scheming
	 * @date 2015年5月19日 下午8:25:28
	 * @TODO
	 */
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
