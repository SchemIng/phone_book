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
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param id
	 * @param name
	 * @param pw
	 * @param cla
	 * @param tel
	 * @param qq
	 * @param path
	 * @param ismaster
	 */
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
		this.path = "user_head_default.png";
	}

	/**
	 * @return path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path
	 *            要设置的 path
	 */
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

	/* （非 Javadoc）
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", pw=" + pw + ", cla="
				+ cla + ", tel=" + tel + ", qq=" + qq + ", path=" + path
				+ ", ismaster=" + ismaster + "]";
	}

}
