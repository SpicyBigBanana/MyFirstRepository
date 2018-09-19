package com.stusys162.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTest {
	public void main(String args) {
		// java和数据库之间的一个桥梁
		Connection connection = null;
		String url = "";
		String uid = "root";
		String pwd = "root";
		// statement
		PreparedStatement pStatement = null;
		// 专门用来存储select语句的执行结果
		ResultSet rSet = null;
		try {
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(url, uid, pwd);
			// 计划好要做的事情
			String sql = "sql语句";
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			while (rSet.next()) {
				int adminid = rSet.getInt("adminId");
				String username = rSet.getString("username");
				String password = rSet.getString("password");
				String realname = rSet.getString("realname");
				System.out.println(adminid + ":" + username + ":" + password + ":" + realname);
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (rSet != null) {
				try {
					rSet.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	public void testInsert() {
		// java和数据库之间的一个桥梁
		Connection connection = null;
		String url = "";
		String uid = "root";
		String pwd = "root";
		// statement
		PreparedStatement pStatement = null;
		// 专门用来存储select语句的执行结果
		ResultSet rSet = null;
		try {
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(url, uid, pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
