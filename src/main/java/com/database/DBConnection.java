package com.database;

import java.sql.DriverManager;

import java.sql.Connection;

public class DBConnection {

	private static Connection con=null;
	
	private DBConnection() {}
	
	public static Connection getConnection()
	{
		try
		{
			if(con==null)
			{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:FREE","GANU","123");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return con;
	}
}
//
//String driver="oracle.jdbc.driver.OracleDriver";
//String url="jdbc:oracle:thin:@localhost:1521:FREE";
//String username="GANU";
//String password="123";