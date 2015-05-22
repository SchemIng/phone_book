package org.scheming.dao;

/**
 * DAO����
 * 
 * @author Scheming
 * @Date 2015��5��20�� ����8:53:03
 * @TODO
 */
public class DaoFactory {

	private static BaseDao user_dao, class_dao;

	/**
	 * ȡ���û����ݿ��������
	 * 
	 * @return
	 * @author Scheming
	 * @date 2015��5��20�� ����8:53:06
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
	 * ȡ�ð༶���ݿ��������
	 * 
	 * @return
	 * @author Scheming
	 * @date 2015��5��20�� ����8:53:35
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
