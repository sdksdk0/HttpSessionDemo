package cn.tf.LoginOut;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class yzmServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setIntHeader("Expires", -1);
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Pragma", "no-cache");
		int width = 110;
		int height = 25;
		//构建一副内存图片：BufferedImage
		BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		//画
		Graphics g = image.getGraphics();//图片上的画笔
		g.setColor(Color.BLUE);
		g.drawRect(0, 0, width, height);//画矩形边线
		
		//填充背景色
		g.setColor(Color.YELLOW);
		g.fillRect(1, 1, width-2, height-2);
		
		//干扰线
		g.setColor(Color.GRAY);
		Random r = new Random();
		for(int i=0;i<9;i++)
			g.drawLine(r.nextInt(width), r.nextInt(height), r.nextInt(width), r.nextInt(height));
		
		//验证码：数字
		g.setColor(Color.RED);
		g.setFont(new Font("宋体", Font.BOLD|Font.ITALIC, 16) );//加粗倾斜
		int x = 20;
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<4;i++){
			String code = r.nextInt(10)+"";
			sb.append(code);
			g.drawString(code, x, 20);
			x+=20;
		}
		//把验证码存到HttpSession中
		request.getSession().setAttribute("yzm", sb.toString());
		//输出到响应对象的字节流输出流
		ImageIO.write(image, "jpg", response.getOutputStream());
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
