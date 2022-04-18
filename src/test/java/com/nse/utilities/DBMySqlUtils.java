package com.nse.utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBMySqlUtils {
	public Connection dbConnect(String db_connect_string, String db_userid, String db_password) {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(db_connect_string, db_userid, db_password);
			System.out.println("connected");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Connection getConnection() {
		DBMySqlUtils connServer = new DBMySqlUtils();
		return connServer.dbConnect("jdbc:mysql://db4free.net:3306/dbfree_db", "dbfree_db", "12345678");
	}

	public  static String executeQuery(String queryString) {
		try {
			
			Statement statement = getConnection().createStatement();
			ResultSet rs = statement.executeQuery(queryString);
			System.out.println("Executed Query: " + queryString);
			while (rs.next()) {
				System.out.println(rs.getString(1));
				return rs.getString(1);
			}
		} catch (Exception e) {
//		   e.printStackTrace();
			return null;
		}
		return null;

	}

	public static String executeQueryForMultipleRow(String queryString, int rowNum, String columnName) {
		try {
			Statement statement = getConnection().createStatement();
			ResultSet rs = statement.executeQuery(queryString);
			System.out.println("Executed Query: " + queryString);
			for (int i = 0; i < rowNum; i++) {
				rs.next();
			}
			return rs.getString(rs.findColumn(columnName));
		} catch (Exception e) {
//		   e.printStackTrace();
			return null;
		}
	}

	public static String executeUpdateInsertDelete( String queryString) {
		try {
			Statement statement = getConnection().createStatement();
			statement.execute(queryString);
			System.out.println("Executed Query: " + queryString);

		} catch (Exception e) {
//		   e.printStackTrace();
			return null;
		}
		return null;

	}
}