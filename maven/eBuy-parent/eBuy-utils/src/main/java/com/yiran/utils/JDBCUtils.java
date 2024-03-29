package com.yiran.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils {

	// 创建c3p0的连接池
	static ComboPooledDataSource cpds = new ComboPooledDataSource();

	// 获得连接
	public static Connection getConnection() throws Exception {
		// 获得连接
		return cpds.getConnection();
	}
	
	public static DataSource getDataSource() {
		
		return cpds;
	}

	// 释放资源
	public static void release(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		rs = null;

		release(conn, stmt);
	}

	// 释放资源
	public static void release(Connection conn, Statement stmt) {
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		stmt = null;

		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}
}
