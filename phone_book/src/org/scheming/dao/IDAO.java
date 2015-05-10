package org.scheming.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Scheming
 * @Date 2015��5��10�� ����2:01:50
 * @TODO
 */
public interface IDAO {
	/**
	 * ���
	 * 
	 * @param data
	 * @author Scheming
	 * @date 2015��5��10�� ����5:06:56
	 * @TODO
	 */
	public void add(Object data);

	/**
	 * ����
	 * 
	 * @param id
	 * @param newData
	 * @author Scheming
	 * @date 2015��5��10�� ����5:06:57
	 * @TODO
	 */
	public void updateUser(String id, Map<String, String> newData);

	/**
	 * ��ѯ
	 * 
	 * @param id
	 * @return
	 * @author Scheming
	 * @date 2015��5��10�� ����5:07:00
	 * @TODO
	 */
	public Object queryData(String id);

}
