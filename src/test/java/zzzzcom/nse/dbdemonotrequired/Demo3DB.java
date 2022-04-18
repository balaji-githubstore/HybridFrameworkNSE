package zzzzcom.nse.dbdemonotrequired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo3DB {

	public static void main(String[] args) throws SQLException {

		//jdbc:mysql://host:port/dbname", "username", "password"
		Connection conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/dbfree_db", "dbfree_db", "12345678");


		ResultSet rs = conn.createStatement().executeQuery("select * from Products");

		//print all rows
		while(rs.next()) //true when new row available
		{
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println("---------");
		}
	}

}
