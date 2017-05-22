package com.wcf.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection con;
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static Connection getConnection(){
		String url = "jdbc:mysql://localhost:3306/happypai?"
                + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";
		if(con==null){
			try {
				con = DriverManager.getConnection(url);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return con;
	}
	

}
