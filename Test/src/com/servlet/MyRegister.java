package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.dao.UuserDao;


/**
 * Servlet implementation class MyRegister
 */
public class MyRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyRegister() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html charset='UTF-8'");
		
		String jsonstr=request.getParameter("jsontext");
		JSONObject jsonObject=new JSONObject(jsonstr);
		
		String phone=jsonObject.getString("phone");
		String nickname=jsonObject.getString("nickname");
	
		String passwd=jsonObject.getString("passwd");
		
		UuserDao uuserDao=UuserDao.getuuserDao();
		
		int result=uuserDao.insert(nickname, phone, passwd);
		
		PrintWriter printStream=response.getWriter();
		if(result==1){
			printStream.print("注册成功");
		}else{
			printStream.print("注册失败");
		}
		
		System.out.println(phone+nickname+passwd);
		
		printStream.flush();
		printStream.close();
	}

}
