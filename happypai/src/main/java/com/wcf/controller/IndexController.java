package com.wcf.controller;

import java.util.List;

import com.jfinal.core.Controller;
import com.wcf.model.Uuser;

public class IndexController extends Controller {
	
	public void index(){

		this.render("/index.jsp");

    }
	
	public void sayHello(){

		String userName = getPara("userName");

		String sayHello = "Hello " + userName + "，welcome to JFinal world.";

		this.setAttr("sayHello", sayHello);

		render("hello.jsp");

	} 
	
	public void judge_phone(){
		String result="{\"status\":\"0\",\"data\":\"手机号已经被注册\"}";
		String phone=getPara("phone");
		int size =Uuser.dao.find_phone(phone);
		if(size==0){
			result="{\"status\":\"1\",\"data\":\"手机号未被注册\"}";
		}
			
		
		renderJson(result);
	}
	
	public void judge_nickname(){
		String result="{\"status\":\"0\",\"data\":\"昵称已经被使用\"}";
		String nickname=getPara("nickname");
		int size=Uuser.dao.find_nickname(nickname);
		if(size==0){
			 result="{\"status\":\"1\",\"data\":\"昵称可以使用\"}";
		}
		renderJson(result);
	}
	
	public void register(){
		String result="{\"status\":\"0\",\"data\":\"注册失败\"}";
		String phone=getPara("phone");
		String nickname=getPara("nickname");
		String passwd=getPara("pwd");
		int d=Uuser.dao.register(phone, nickname, passwd);
		if(d!=0){
			 result="{\"status\":\"1\",\"data\":\"注册成功\"}";
		}
		renderJson(result);
	}
	
	public void login(){
		String result="{\"status\":\"0\",\"data\":\"密码或者账户名不对\"}";
		String phone=getPara("phone");
		String passwd=getPara("pwd");
		int d=Uuser.dao.login(phone, passwd);
		if(d!=0){
			 result="{\"status\":\"1\",\"data\":\"登录成功\"}";
		}
		renderJson(result);
		
	}

}
