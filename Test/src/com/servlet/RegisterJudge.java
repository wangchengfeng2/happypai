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
 * Servlet implementation class RejisterJudge
 */
public class RegisterJudge extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterJudge() {
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
		
		String phone= jsonObject.getString("phone");
		
		String nickname= jsonObject.getString("nickname");
		
		String result=UuserDao.getuuserDao().registerJudge(nickname, phone);
		
		PrintWriter printStream=response.getWriter();
		
		System.out.println(result);
		printStream.print(result);
		printStream.flush();
		printStream.close();
		
	}

}
