package com.stusys162.mapper;

import java.util.List;
import java.util.Map;

import com.stusys162.pojo.Emp;

public interface EmpMapper {
	public List<Emp> selectAll();

	public List<Emp> selectByPage(Map map);

	public List<Emp> selectByWhere(Emp emp);

	public List<Emp> selectByWherePage(Map map);

	public List<Emp> selectAllJoin();

	public Emp selectByName(String name);

	public Emp selectById(int id);

	public int insertEmp(Emp emp);

	public int updateEmp(Emp emp);

	public int deleteEmp(int id);

	public int delMany(List<Integer> ids);

}
