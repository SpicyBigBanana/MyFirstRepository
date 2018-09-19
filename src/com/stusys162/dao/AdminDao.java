package com.stusys162.

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.ling.pojo.AdminInfo;

public interface AdminDao {
	public int insertAdmin(Connection conn, Admininfo aInfo) throws SQLException;

	public int updateAdmin(Connection conn, Admininfo aInfo) throws SQLException;

	public int deleteAdmin(Connection conn, int id) throws SQLException;

	public AdminInfo selectAdminByUsername(Connection conn, String username) throws SQLException;

	public AdminInfo selectAdminById(Connection conn, int id) throws SQLException;

	public List<AdminInfo> selectAdminAll(Connection conn) throws SQLException;
}
