package org.scheming.dao;

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
 * @Date 2015年5月20日 下午8:52:59
 * @TODO
 */
public class ClassDao extends BaseDao {
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
	 * @see org.scheming.dao.BaseDao#add(java.lang.Object)
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
	 * @see org.scheming.dao.BaseDao#update(java.lang.String, java.util.Map)
	 */
	@Override
	public void update(String name, Map<String, String> newData) {
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
	 * （非 Javadoc）
	 * 
	 * @see org.scheming.dao.BaseDao#queryData(java.lang.String)
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
						resultSet.getInt("stu_sum"),
						resultSet.getString("class_notice"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classModel;
	}

	/**
	 * 查询全部班级
	 * 
	 * @return
	 * @author Scheming
	 * @date 2015年5月20日 下午8:50:44
	 * @TODO
	 */
	public List<ClassModel> queryAll() {
		ResultSet resultSet = null;
		ClassModel classModel = null;
		List<ClassModel> classModels = new ArrayList<ClassModel>();
		String sql = "SELECT class_name FROM test.class;";
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while (resultSet.next()) {
				classModel = new ClassModel();
				classModel.setName(resultSet.getString("class_name"));
				classModels.add(classModel);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return classModels;
	}

	/**
	 * 查询班级通知
	 * 
	 * @param name
	 * @return
	 * @author Scheming
	 * @date 2015年5月20日 下午8:50:57
	 * @TODO
	 */
	public String queryNotice(String name) {
		String result = "";
		String sql = "SELECT class_notice FROM test.class where class_name='"
				+ name + "';";
		ResultSet resultSet;

		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				result = resultSet.getString("class_notice");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
}
