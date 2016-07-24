package cn.tf.LoginOut;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class IndexServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		
		//登录成功后，放一个登陆标记
		HttpSession  session=request.getSession();
		
		User user=(User) session.getAttribute("user");
		if(user==null){
			//未登录
			out.write("<a href='"+request.getContextPath()+"/servlet/LoginUIServlet'>登录</a>");
		}else{
			out.write("欢迎您:"+user.getUsername()+"<a href='"+request.getContextPath()+"/servlet/LogoutServlet'>注销</a>");
		}
		out.write("<hr/>主页");
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
