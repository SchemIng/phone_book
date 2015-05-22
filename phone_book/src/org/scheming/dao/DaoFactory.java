package org.scheming.dao;

/**
 * DAO工厂
 * 
 * @author Scheming
 * @Date 2015年5月20日 下午8:53:03
 * @TODO
 */
public class DaoFactory {

	private static BaseDao user_dao, class_dao;

	/**
	 * 取得用户数据库操作对象
	 * 
	 * @return
	 * @author Scheming
	 * @date 2015年5月20日 下午8:53:06
	 * @TODO
	 */
	public static BaseDao getUserDaoInstance() {
		try {
			user_dao = (BaseDao) Class.forName("org.scheming.dao.UserDao")
					.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return user_dao;
	}

	/**
	 * 取得班级数据库操作对象
	 * 
	 * @return
	 * @author Scheming
	 * @date 2015年5月20日 下午8:53:35
	 * @TODO
	 */
	public static BaseDao getClassDaoInstance() {
		try {
			class_dao = (BaseDao) Class.forName("org.scheming.dao.ClassDao")
					.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		return class_dao;
	}

}
