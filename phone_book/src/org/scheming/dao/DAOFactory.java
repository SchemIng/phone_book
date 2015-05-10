package org.scheming.dao;

/**
 * 
 * @author Scheming
 * @Date 2015年5月10日 下午2:37:02
 * @TODO
 */
public class DAOFactory {

	private static IDAO user_dao, class_dao;

	public static IDAO getUserDaoInstance() {
		if (user_dao == null) {
			try {
				user_dao = (IDAO) Class.forName("org.scheming.dao.UserDAO")
						.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		return user_dao;
	}

	public static IDAO getClassDaoInstance() {

		return class_dao;
	}

}
