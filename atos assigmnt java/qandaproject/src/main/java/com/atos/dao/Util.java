package com.atos.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Util {
	public static Connection getConnection() throws SQLException
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(ClassNotFoundException e)
		{
			System.out.println("Wrong Class");
			e.printStackTrace();
		}
		return DriverManager.getConnection(
				"jdbc:oracle:oci:@localhost:1521:xe"
				 ,"atosDb"
				,"Ashu1234");
				
	}

}
