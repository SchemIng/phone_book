package org.scheming.model;


public class User {
	String id;
	String name;
	String pw;
	String cla;
	String tel;
	String qq;
	String path;
	boolean ismaster;

	public User() {
	}

	public User(String id, String name, String pw, String cla, String tel,
			String qq, String path, boolean ismaster) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.cla = cla;
		this.tel = tel;
		this.qq = qq;
		this.path = path;
		this.ismaster = ismaster;
	}




	public String getPath() {
		return path;
	}

	
	public void setPath(String path) {
		this.path = path;
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

	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pw=" + pw + ", cla="
				+ cla + ", tel=" + tel + ", qq=" + qq + ", path=" + path
				+ ", ismaster=" + ismaster + "]";
	}

}
