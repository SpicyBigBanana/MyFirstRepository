package com.stusys162.test;

import java.io.IOException;
import java.io.Reader;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.stusys162.pojo.Dept;
import com.stusys162.pojo.Emp;

public class EmpTest {
	@Test
	public void selectAll() {
		String resource = "com/stusys162/resourse/Configuration.xml";
		Reader reader;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();
			List<Emp> emps = sqlSession.selectList("EmpMapper.selectAllJoin");
			for (Emp emp : emps) {
				System.out.println(emp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void insertEmp() {
		String resource = "com/stusys162/resourse/Configuration.xml";
		Reader reader;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();
			Emp emp = new Emp("蛋蛋", new Date(), "dd@qq.com");
			emp.setEmpid(5);
			Dept dept = new Dept();
			dept.setDeptid(2);
			emp.setDept(dept);
			int row = sqlSession.delete("EmpMapper.insertEmp", emp);
			if (row > 0) {
				sqlSession.commit();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void updateEmp() {
		String resource = "com/stusys162/resourse/Configuration.xml";
		Reader reader;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();
			Emp emp = new Emp("蛋蛋2", new Date(), "dd2@qq.com");
			emp.setEmpid(5);
			Dept dept = new Dept();
			dept.setDeptid(2);
			emp.setDept(dept);
			int row = sqlSession.delete("EmpMapper.updateEmp", emp);
			if (row > 0) {
				sqlSession.commit();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void delEmp() {
		String resource = "com/stusys162/resourse/Configuration.xml";
		Reader reader;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();

			int row = sqlSession.delete("EmpMapper.deleteEmp", 5);
			if (row > 0) {
				sqlSession.commit();
			}
			System.out.println(row);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void selectByPage() {
		String resource = "com/stusys162/resourse/Configuration.xml";
		Reader reader;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();
			Map<String, Integer> map = new HashMap<String, Integer>();
			map.put("startindex", 2);
			map.put("pagesize", 2);
			List<Emp> emps = sqlSession.selectList("EmpMapper.selectByPage");
			for (Emp emp : emps) {
				System.out.println(emp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void selectByWhere() {
		String resource = "com/stusys162/resourse/Configuration.xml";
		Reader reader;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();
			Emp empWhere = new Emp();
			empWhere.setEmpname("%zhang%");
			Dept dept = new Dept();
			dept.setDeptid(1);
			empWhere.setDept(dept);

			List<Emp> emps = sqlSession.selectList("EmpMapper.selectByWhere", empWhere);
			for (Emp emp : emps) {
				System.out.println(emp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void selectByWherePage() {
		String resource = "com/stusys162/resourse/Configuration.xml";
		Reader reader;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();
			Map<String, Object> map = new HashMap<String, Object>();
			Emp empWhere = new Emp();
			empWhere.setEmpname("%zhang%");
			Dept dept = new Dept();
			dept.setDeptid(1);
			empWhere.setDept(dept);
			map.put("emp", empWhere);
			map.put("startindex", 0);
			map.put("pagesize", 2);

			List<Emp> emps = sqlSession.selectList("EmpMapper.selectByWherePage", map);
			for (Emp emp : emps) {
				System.out.println(emp);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}

	@Test
	public void delMany() {
		String resource = "com/stusys162/resourse/Configuration.xml";
		Reader reader;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();
			int[] ids = { 5, 6, 7 };
			int row = sqlSession.delete("EmpMapper.delMany", ids);
			if (row > 0) {
				sqlSession.commit();
			}
			System.out.println(row);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}
	}
}
