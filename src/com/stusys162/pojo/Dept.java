package com.stusys162.pojo;

public class Dept {
	private int deptid;
	private String deptinfo;
	private String deptname;

	@Override
	public String toString() {
		return "Dept [deptid=" + deptid + ", deptinfo=" + deptinfo + ", deptname=" + deptname + "]";
	}

	public int getDeptid() {
		return deptid;
	}

	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}

	public String getDeptinfo() {
		return deptinfo;
	}

	public void setDeptinfo(String deptinfo) {
		this.deptinfo = deptinfo;
	}

	public String getDeptname() {
		return deptname;
	}

	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}

}
