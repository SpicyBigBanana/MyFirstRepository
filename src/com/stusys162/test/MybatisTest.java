package com.stusys162.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.stusys162.pojo.Admininfo;

public class MybatisTest {
	@Test
	public void insertAdmin() {
		String resource = "com/stusys162/config/Configuration.xml";
		Reader reader;
		SqlSessionFactory sqlSessionFactory = null;
		SqlSession sqlSession = null;
		try {
			reader = Resources.getResourceAsReader(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSession = sqlSessionFactory.openSession();
			Admininfo admin = new Admininfo("wanger", "789456", "王二");
			int result = sqlSession.insert("AdminMapper.insertAdmin", admin);
			sqlSession.commit();
			System.out.println(result);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			sqlSession.close();
		}

	}
}
