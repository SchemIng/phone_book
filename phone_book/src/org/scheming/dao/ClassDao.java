package org.scheming.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.scheming.db.DBHelp;
import org.scheming.model.ClassModel;

/**
 * 
 * @author Scheming
 * @Date 2015年5月10日 下午5:03:34
 * @TODO
 */
public class ClassDao implements IDAO {
	private Connection connection;

	{
		try {
			connection = DBHelp.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see org.scheming.dao.IDAO#add(java.lang.Object)
	 */
	@Override
	public void add(Object data) {
		ClassModel classModel = (ClassModel) data;
		String sql = "INSERT INTO `test`.`class` (`class_name`, `stu_sum`) VALUES ('"
				+ classModel.getName() + "', '" + classModel.getSum() + "');";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/*
	 * （非 Javadoc）
	 * 
	 * @see org.scheming.dao.IDAO#updateUser(java.lang.String, java.util.Map)
	 */
	@Override
	public void updateUser(String name, Map<String, String> newData) {
		for (String key : newData.keySet()) {
			String sql = "UPDATE `test`.`class` SET `" + key + "`='"
					+ newData.get(key) + "' WHERE `class_name`='" + name + "';";
			try {
				PreparedStatement preparedStatement = connection
						.prepareStatement(sql);
				preparedStatement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/*
	 * （非 Javadoc） UPDATE `test`.`class` SET `stu_sum`='4' WHERE `id`='2';
	 * SELECT * FROM test.class where class_name='软件1302';
	 * 
	 * @see org.scheming.dao.IDAO#queryData(java.lang.String)
	 */
	@Override
	public Object queryData(String name) {
		ResultSet resultSet = null;
		ClassModel classModel = null;
		String sql = "SELECT * FROM test.class where class_name='" + name
				+ "';";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (resultSet.next()) {
				classModel = new ClassModel(resultSet.getInt("id"),
						resultSet.getString("class_name"),
						resultSet.getInt("stu_sum"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classModel;
	}

	public List<ClassModel> queryAll() {
		ResultSet resultSet = null;
		ClassModel classModel = null;
		List<ClassModel> classModels = new ArrayList<ClassModel>();
		String sql = "SELECT * FROM test.class;";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (resultSet.next()) {
				classModel = new ClassModel(resultSet.getInt("id"),
						resultSet.getString("class_name"),
						resultSet.getInt("stu_sum"));
				classModels.add(classModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classModels;
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
