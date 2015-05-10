package org.scheming.model;

/**
 * 
 * @author Scheming
 * @Date 2015��5��10�� ����4:58:23
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
	 *            Ҫ���õ� id
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
	 *            Ҫ���õ� name
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
	 *            Ҫ���õ� sum
	 */
	public void setSum(int sum) {
		this.sum = sum;
	}

}
