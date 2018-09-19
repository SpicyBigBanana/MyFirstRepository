package com.stusys162.pojo;

import java.util.Date;

public class Emp {
	private int empid;
	private String empname;
	private Date joindate;
	private Dept dept;
	private String email;

	public Emp() {
		super();
	}

	public Emp(String empname, Date joindate, String email) {
		super();
		this.empname = empname;
		this.joindate = joindate;
		this.email = email;
	}

	public Emp(String empname, Date joindate, Dept dept, String email) {
		super();
		this.empname = empname;
		this.joindate = joindate;
		this.dept = dept;
		this.email = email;
	}

	public Emp(int id, String empname, Date joindate, Dept dept, String email) {
		super();
		this.empname = empname;
		this.joindate = joindate;
		this.dept = dept;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Emp [empid=" + empid + ", empname=" + empname + ", joindate=" + joindate + ", dept=" + dept + ", email="
				+ email + "]";
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public Date getJoindate() {
		return joindate;
	}

	public void setJoindate(Date joindate) {
		this.joindate = joindate;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
