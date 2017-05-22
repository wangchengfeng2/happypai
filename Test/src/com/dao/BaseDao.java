package com.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.wcf.connection.ConnectionUtil;

public class BaseDao {
	private Connection con;
	private PreparedStatement pstmt;
	public BaseDao() {
		// TODO Auto-generated constructor stub
		con=ConnectionUtil.getConnection();
		
	}
	public PreparedStatement getPrepareStatement(String sql){
	
		try {
			pstmt=con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return pstmt;
	}
	

}
