package com.wcf.model;

import java.util.List;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.Record;

public class Uuser extends Model<Uuser> {
	
	public static final Uuser dao=new Uuser();
	
	public int find_phone(String phone){
		List<Record> lists= Db.find("SELECT *FROM uuser WHERE phone='"+phone+"'");
		return lists.size();
	}
	
	public int find_nickname(String nickname){
		
		
		List<Record> lists= Db.find("SELECT *FROM uuser WHERE nickname='"+nickname+"'");
		return lists.size();
	}
	
	public int register(String phone,String nickname,String passwd){
		List<Record> lists= Db.find("SELECT *FROM uuser WHERE phone='"+phone+"'");
		if(lists==null){
		 return Db.update("INSERT INTO uuser(nickname,phone,passwd)  VALUES('"+nickname+"','"+phone+"','"+passwd+"')");
		}else
			return 0;
	}
	
	public int login(String phone,String passwd){
		List<Record> lists = Db.find("SELECT *FROM uuser where phone='"+phone+"' and passwd='"+passwd+"'");
	    return lists.size();
	}
	

}
