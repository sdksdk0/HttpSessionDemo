package cn.tf.PayDemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PayServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		/*String money=request.getParameter("money");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("支付成功"+money);
		response.sendRedirect(request.getContextPath()+"/sucess.html");
		*/
		
		String ftoken=request.getParameter("token");
		String stoken=(String) request.getSession().getAttribute("token");
		
		if(ftoken.equals(stoken)){
			String money=request.getParameter("money");
			System.out.println("支付成功:"+money);
			
			request.getSession().removeAttribute("token");
		}else{
			out.write("请不要重复提交");
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
