package org.scheming.model;

/**
 * 
 * @author Scheming
 * @Date 2015年5月10日 下午4:58:23
 * @TODO
 */
public class ClassModel {

	private int id;
	private String name;
	private int sum;
	private String notice;

	/**
	 * 
	 */
	public ClassModel() {
	}
	

	/**
	 * @param id
	 * @param name
	 * @param sum
	 * @param notice
	 */
	public ClassModel(int id, String name, int sum, String notice) {
		super();
		this.id = id;
		this.name = name;
		this.sum = sum;
		this.notice = notice;
	}



	/**
	 * @return id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            要设置的 id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            要设置的 name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return sum
	 */
	public int getSum() {
		return sum;
	}

	/**
	 * @param sum
	 *            要设置的 sum
	 */
	public void setSum(int sum) {
		this.sum = sum;
	}

	/**
	 * @return notice
	 */
	public String getNotice() {
		return notice;
	}

	/**
	 * @param notice
	 *            要设置的 notice
	 */
	public void setNotice(String notice) {
		this.notice = notice;
	}

}
