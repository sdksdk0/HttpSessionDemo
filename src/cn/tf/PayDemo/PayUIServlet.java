package cn.tf.PayDemo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PayUIServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		//生成唯一的TOken
		
		//数据指纹：
//		String token = SecurityUtil.md5(System.nanoTime()+"");//  1秒=1000毫秒=1000000微秒=1000000000纳秒
		String token = UUID.randomUUID().toString();//唯一的 GUID
		
		request.getSession().setAttribute("token", token);
		
		out.write("<form action='"+request.getContextPath()+"/servlet/PayServlet' method='post'><br/>");
		out.write("金额：<input type='text' name='money'/><br/>");
		out.write("<input type='hidden' name='token' value='"+token+"'/><br/>");
		out.write("<input type='submit' value='付款'/><br/>");
		out.write("</form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}


}
