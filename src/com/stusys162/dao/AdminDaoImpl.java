package com.stusys162.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.stusys162.pojo.Admininfo;

public class AdminDaoImpl extends BaseDao implements AdminDao {

	@Override
	public int insertAdmin(Connection conn, Admininfo aInfo) throws SQLException {
		String sql = "insert into t_adminusers(username,password,realname)values(?,?,?)";
		int result = super.execUpdate(conn, sql, aInfo.getUsername(), aInfo.getPassword(), aInfo.getReslname());
		return result;
	}

	@Override
	public int updateAdmin(Connection conn, Admininfo aInfo) throws SQLException {
		String sql = "update t_adminusers set username = ? ,password = ?,realname = ? where adminId = ?";
		int result = super.execUpdate(conn, sql, aInfo.getUsername(), aInfo.getPassword(), aInfo.getReslname(),
				aInfo.getAdminId());
		return result;
	}

	@Override
	public int deleteAdmin(Connection conn, int id) throws SQLException {
		String sql = "delete from t_adminusers where adminId = ?";
		int result = super.execUpdate(conn, sql, id);
		return result;
	}

	@Override
	public AdminInfo selectAdminByUsername(Connection conn, String username) throws SQLException {
		String sql = "select * from t_adminusers where username = ?";
		ResultSet rs = super.execQuery(conn, sql, username);
		AdminInfo aInfo = null;
		if (rs.next()) {
			aInfo = new AdminInfo();
			aInfo.setAdminId(rs.getInt("adminId"));
			aInfo.setUsername(rs.getString("username"));
			aInfo.setPassword(rs.getString("password"));
			aInfo.setReslname(rs.getString("realname"));
		}
		return aInfo;
	}

	@Override
	public AdminInfo selectAdminById(Connection conn, int id) throws SQLException {
		String sql = "select * from t_adminusers where id = ?";
		ResultSet rs = super.execQuery(conn, sql, id);
		AdminInfo aInfo = null;
		if (rs.next()) {
			aInfo = new AdminInfo();
			aInfo.setAdminId(rs.getInt("adminId"));
			aInfo.setUsername(rs.getString("username"));
			aInfo.setPassword(rs.getString("password"));
			aInfo.setReslname(rs.getString("realname"));
		}
		return aInfo;
	}

	@Override
	public List<AdminInfo> selectAdminAll(Connection conn) throws SQLException {
		String sql = "select * from t_adminusers";
		ResultSet rs = super.execQuery(conn, sql);
		List<AdminInfo> adminInfos = new ArrayList<>();
		if (rs.next()) {
			AdminInfo aInfo = new AdminInfo();
			aInfo.setAdminId(rs.getInt("adminId"));
			aInfo.setUsername(rs.getString("username"));
			aInfo.setPassword(rs.getString("password"));
			aInfo.setReslname(rs.getString("realname"));
			adminInfos.add(aInfo);
		}
		return adminInfos;
	}

}
