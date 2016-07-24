package cn.tf.LoginOut;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		HttpSession session=request.getSession();
		
		//方法1、立即失效，取消绑定所有对象
		//session.invalidate();
		
		//方法2、删除标记
		session.removeAttribute("uesr");
		
		//方法3、超时
		//session.setMaxInactiveInterval(1);
		
		out.write("注销成功，2秒后转向主页");
		response.setHeader("Refresh", "2;URL="+request.getContextPath()+"/servlet/IndexServlet");
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doGet(request,response);
	}

}
