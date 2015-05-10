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
	/**
	 * 添加
	 * 
	 * @param data
	 * @author Scheming
	 * @date 2015年5月10日 下午5:06:56
	 * @TODO
	 */
	public void add(Object data);

	/**
	 * 更新
	 * 
	 * @param id
	 * @param newData
	 * @author Scheming
	 * @date 2015年5月10日 下午5:06:57
	 * @TODO
	 */
	public void updateUser(String id, Map<String, String> newData);

	/**
	 * 查询
	 * 
	 * @param id
	 * @return
	 * @author Scheming
	 * @date 2015年5月10日 下午5:07:00
	 * @TODO
	 */
	public Object queryData(String id);

}
