package zzzzcom.nse.dbdemonotrequired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo2DB {

	public static void main(String[] args) throws SQLException {

		//jdbc:mysql://host:port/dbname", "username", "password"
		Connection conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/dbfree_db", "dbfree_db", "12345678");

		//using selenium in webpage - you added a product with description "amazon" 

		ResultSet rs = conn.createStatement().executeQuery("select count(*) from Products where description='amazon'");

		System.out.println(rs.next());//move to 1st row and return true if row available
		System.out.println(rs.getString(1));
	}

}
