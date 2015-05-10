package org.scheming.dao;

import java.util.List;
import java.util.Map;

/**
 * 
 * @author Scheming
 * @Date 2015年5月10日 下午2:01:50
 * @TODO
 */
public interface IDAO {
	public void add(Object data);

	public void updateUser(String id, Map<String, String> newData);

	public List<Object> queryData(String id);

}
