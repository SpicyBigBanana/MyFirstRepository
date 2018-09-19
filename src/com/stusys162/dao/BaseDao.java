package com.stusys162.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDao {
	public int exeUpdate(Connection conn, String sql, Object... values) throws SQLException {
		int result = 0;
		PreparedStatement pstms = conn.prepareStatement(sql);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				pstms.setObject(i + 1, values[i]);
			}
		}
		result = pstms.executeUpdate();
		return result;
	}

	public ResultSet exeQuery(Connection conn, String sql, Object... values) throws SQLException {
		ResultSet rs = null;
		PreparedStatement pstms = conn.prepareStatement(sql);
		if (values != null) {
			for (int i = 0; i < values.length; i++) {
				pstms.setObject(i + 1, values[i]);
			}
		}
		rs = pstms.executeQuery();
		return rs;
	}
}
