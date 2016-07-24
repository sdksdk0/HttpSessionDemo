package cn.tf.LoginOut;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		HttpSession session=request.getSession();
		PrintWriter out = response.getWriter();
		
		
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		String yzm=request.getParameter("yzm");
		
		//验证码
		if(!yzm.equals((String)session.getAttribute("yzm"))){
			
			out.write("验证码错误,3秒后转向登陆界面");
			response.setHeader("Refresh","3;URL="+request.getContextPath()+"/servlet/LoginUIServlet");
			return;
				
		}
		
		//检验用户名和密码是否正确
		if(!username.equals(new StringBuffer(password).reverse().toString())){
			out.write("用户名和密码错误,3秒后转向登陆界面");
			response.setHeader("Refresh","3;URL="+request.getContextPath()+"/servlet/LoginUIServlet");
			return;
			
		}
		
		//向HttpSession中存放的登陆标记
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		session.setAttribute("user", user);
		
		out.write("登陆成功,3秒后转向主页");
		response.setHeader("Refresh","3;URL="+request.getContextPath()+"/servlet/IndexServlet");
		
		
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
