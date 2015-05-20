package org.scheming.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;


public abstract class BaseDao {

	protected Connection connection;

	
	public abstract void add(Object data);

	
	public abstract void update(String id, Map<String, String> newData);

	
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
