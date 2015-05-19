package org.scheming.dao;

/**
 * 
 * @author Scheming
 * @Date 2015年5月10日 下午2:37:02
 * @TODO
 */
public class DaoFactory {

	private static BaseDao user_dao, class_dao;

	/**
	 * 获取用户DAO
	 * @return
	 * @author Scheming
	 * @date 2015年5月19日 下午8:24:36
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
	 * 获取班级DAO
	 * @return
	 * @author Scheming
	 * @date 2015年5月19日 下午8:25:04
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
