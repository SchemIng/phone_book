package org.scheming.db;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DBHelp {
	private static DataSource dataSource = null;

	static {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			dataSource = (DataSource) envCtx.lookup("jdbc/test");
		} catch (NamingException e) {
			e.printStackTrace();
		}

	}

	
	public static Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

}
