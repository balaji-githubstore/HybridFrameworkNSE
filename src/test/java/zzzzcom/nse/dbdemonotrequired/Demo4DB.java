package zzzzcom.nse.dbdemonotrequired;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//update, delete, insert
public class Demo4DB {

	public static void main(String[] args) throws SQLException {

		//jdbc:mysql://host:port/dbname", "username", "password"
		Connection conn = DriverManager.getConnection("jdbc:mysql://db4free.net:3306/dbfree_db", "dbfree_db", "12345678");

		
		ResultSet rs = conn.createStatement().executeQuery("select * from Products where product_id='5013'");

		while(rs.next()) //true when new row available
		{
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println("---------");
		}
		
		//update the record
		conn.createStatement().execute("update Products set description='amazon india' where product_id='5013'");
		
		
		rs = conn.createStatement().executeQuery("select * from Products where product_id='5013'");

		while(rs.next()) //true when new row available
		{
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println("---------");
		}
		
		conn.createStatement().execute("delete from Products where product_id='5013'");
		
		rs = conn.createStatement().executeQuery("select * from Products where product_id='5013'");
		System.out.println(rs.next());
		
	

		while(rs.next()) //true when new row available
		{
			System.out.println(rs.getString(1));
			System.out.println(rs.getString(2));
			System.out.println(rs.getString(3));
			System.out.println("---------");
		}
	}

}
