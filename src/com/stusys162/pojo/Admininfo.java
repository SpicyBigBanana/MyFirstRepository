package com.stusys162.pojo;

public class Admininfo {
	private int adminid;
	private String username;
	private String password;
	private String realname;

	public Admininfo(String username, String password, String realname) {
		super();
		this.username = username;
		this.password = password;
		this.realname = realname;
	}

	public Admininfo() {
		super();
	}

	public Admininfo(int adminid, String username, String password, String realname) {
		super();
		this.adminid = adminid;
		this.username = username;
		this.password = password;
		this.realname = realname;
	}

	public int getAdminid() {
		return adminid;
	}

	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRealname() {
		return realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

	@Override
	public String toString() {
		return "Admininfo [adminid=" + adminid + ", username=" + username + ", password=" + password + ", realname="
				+ realname + "]";
	}

}
