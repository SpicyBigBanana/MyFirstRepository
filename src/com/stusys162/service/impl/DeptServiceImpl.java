package com.stusys162.service.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.stusys162.mapper.DeptMapper;
import com.stusys162.pojo.Dept;
import com.stusys162.service.DeptService;
import com.stusys162.test.MybatisUtils;

public class DeptServiceImpl implements DeptService {
	private DeptMapper mapper = null;

	@Override
	public int addDept(Dept dept) {
		int result = 0;
		SqlSessionFactory factory = MybatisUtils.createFactory();
		SqlSession sqlSession = factory.openSession();
		try {
			mapper = sqlSession.getMapper(DeptMapper.class);
			Dept realdept = mapper.selectByName(dept.getDeptname());
			if (realdept == null) {
				result = mapper.insertDept(dept);
				sqlSession.commit();
			} else {
				result = -1;
			}
		} catch (Exception e) {

		} finally {
			sqlSession.close();
		}
		return result;
	}

}
