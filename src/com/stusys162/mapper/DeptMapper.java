package com.stusys162.mapper;

import java.util.List;

import com.stusys162.pojo.Dept;

public interface DeptMapper {
	public List<Dept> selectAll();

	public Dept selectByName(String name);

	public Dept selectById(int id);

	public int insertDept(Dept dept);

	public int delDept(int deptid);
}
