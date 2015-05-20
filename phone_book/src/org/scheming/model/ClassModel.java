package org.scheming.model;


public class ClassModel {

	private int id;
	private String name;
	private int sum;
	private String notice;

	
	public ClassModel() {
	}
	

	
	public ClassModel(int id, String name, int sum, String notice) {
		super();
		this.id = id;
		this.name = name;
		this.sum = sum;
		this.notice = notice;
	}



	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public int getSum() {
		return sum;
	}

	
	public void setSum(int sum) {
		this.sum = sum;
	}

	
	public String getNotice() {
		return notice;
	}

	
	public void setNotice(String notice) {
		this.notice = notice;
	}

}
