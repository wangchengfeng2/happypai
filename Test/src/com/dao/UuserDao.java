package com.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UuserDao extends BaseDao{
	private PreparedStatement pstmt;
	public static UuserDao uuserDao;
	
	public UuserDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	public static UuserDao getuuserDao(){
		
		if (uuserDao== null) {
			uuserDao=new UuserDao();
		}
		
		return uuserDao;
	
	}
	//注册时插入
	public int insert(String nickname,String phone,String passwd){
		int d=0;
		
		String sql = "INSERT INTO uuser(nickname,phone,passwd) VALUES(?,?,?)";
		
		pstmt = getPrepareStatement(sql);
		
	
		try {
			pstmt.setString(1, nickname);
			pstmt.setString(2, phone);
			pstmt.setString(3, passwd);
			d = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		return d;
	}
	
	
	public String  registerJudge(String nickname,String phone){
		String sql = "SELECT *FROM uuser WHERE phone=?";
		
		ResultSet set = null;
		pstmt=getPrepareStatement(sql);
		
		try {
			pstmt.setString(1, phone);
			set=pstmt.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(set==null){
			sql = "SELECT *FROM uuser WHERE nickname=?";
			pstmt=getPrepareStatement(sql);
			
			try {
				pstmt.setString(1, nickname);
				set=pstmt.executeQuery();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(set==null){
				return "通过";
			}else{
				return "昵称已被使用";
			}
		}else{
			return "手机号已注册";
			
		}
		
	}
	
	

}
