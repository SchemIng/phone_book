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

	/**
	 * @param id
	 * @param name
	 * @param sum
	 */
	public ClassModel(int id, String name, int sum) {
		super();
		this.id = id;
		this.name = name;
		this.sum = sum;
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

}
