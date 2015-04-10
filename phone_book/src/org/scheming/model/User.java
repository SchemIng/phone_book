package org.scheming.model;

public class User {
	String id;
	String name;
	String pw;
	String cla;
	String tel;
	String qq;
	boolean ismaster;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String id, String name, String pw, String cla, String tel,
			String qq, boolean ismaster) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.cla = cla;
		this.tel = tel;
		this.qq = qq;
		this.ismaster = ismaster;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getCla() {
		return cla;
	}

	public void setCla(String cla) {
		this.cla = cla;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public boolean isIsmaster() {
		return ismaster;
	}

	public void setIsmaster(boolean ismaster) {
		this.ismaster = ismaster;
	}

}
