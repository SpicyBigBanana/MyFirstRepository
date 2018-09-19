package com.stusys162.test;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtils {
	private static SqlSessionFactory factory = null;

	public static SqlSessionFactory createFactory() {
		String resource = "com/stusys162/resourse/Configuration.xml";
		Reader reader;
		try {
			if (factory == null) {
				reader = Resources.getResourceAsReader(resource);

				factory = new SqlSessionFactoryBuilder().build(reader);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return factory;
	}
}
