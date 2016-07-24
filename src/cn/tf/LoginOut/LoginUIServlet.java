package cn.tf.LoginOut;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//显示登陆页面
public class LoginUIServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.write("<form action='"+request.getContextPath()+"/servlet/LoginServlet' method='post'><br/>");
		out.write("用户名：<input type='text' name='username'/><br/>");
		out.write("密码：<input type='password' name='password' /><br/>");
		out.write("验证码：<input type='text' size='3' name='yzm' /><img src='"+request.getContextPath()+"/servlet/yzmServlet'/><br/>");
		out.write("<input type='submit' value='登陆'/><br/>");
		out.write("</form>");
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
