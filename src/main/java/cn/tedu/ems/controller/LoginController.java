package cn.tedu.ems.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Random;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.ems.entity.User;
import cn.tedu.ems.service.ApplicationException;
import cn.tedu.ems.service.LoginService;

@Controller
public class LoginController {
	
	@Resource(name="loginService")
	private LoginService ls;
	
	@ExceptionHandler
	public String handle(Exception e,
			HttpServletRequest request){
		System.out.println("handle()");
		if(e instanceof ApplicationException){
			request.setAttribute("login_failed",
					e.getMessage());
			return "login";
		}
		return "error";
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,HttpSession session){
		System.out.println("login()");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		System.out.println(username+ " "	+ pwd);
		
		//将请求分发给业务层来处理
		User user = ls.checkLogin(username, pwd);	
			
		session.setAttribute("uset",user);
		
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex( ){
		return "index";
	}
	
	@RequestMapping("/checkcode.do")
	//输出验证码图片
	public void checkcode(	HttpServletRequest request,HttpServletResponse response)throws IOException{
		System.out.println("checkcode....");
		/**
		 * step1.生成图片
		 */
		//创建一个画布
		BufferedImage image=new BufferedImage(85,30,BufferedImage.TYPE_INT_BGR);
		//获得画笔
		Graphics g=image.getGraphics();
		//给笔设置颜色
		g.setColor(new Color(255,255,255));
		//设置画布背景颜色
		g.fillRect(0, 0, 85, 30);
		//重新给笔设置颜色
		Random r = new Random();
		g.setColor(new Color(
				r.nextInt(255),
				r.nextInt(255),
				r.nextInt(255)));
		//设置字体
		g.setFont(new Font(null,Font.BOLD,24));
		//生成一个随机数
		String number=getNumber(5);
		
		//将验证码绑定到session上
		HttpSession session =request.getSession();
		HttpSession session = request.getsession();
		
		session.setAttribute("number",number);
		
		session.setAttribute("number",number);
		
		for(int i =0;i<20;i++){
			g.setColor(new Color(r.nextInt(255),r.nextInt(255),r.nextInt(255)));
			g.drawLine(r.nextInt(85), r.nextInt(30),r.nextInt(85), r.nextInt(30));
		}
		//在图片上绘制随机数
		g.drawString(number, 2, 25);
		
		
		
		/**
		 * step2.压缩图片并输出
		 */
		//告诉浏览器,服务器返回的是一个图片
		response.setContentType("image/jpeg");
		
		
		//要获得字节输出流
		OutputStream output=response.getOutputStream();
		//将原始图片按照指定的格式(jpeg)进行压缩,然后输出
		javax.imageio.ImageIO.write(image, "jpeg", output);
		output.close();
	}
	
	public String getNumber(int size){
		String chars="ABCDEFGHIJKLMNOPQRSTUVWXYZ"
				+ "0123456789";
		String number="";
		Random r=new Random();
		for(int i=0;i<size;i++){
			number += chars.charAt(
					r.nextInt(chars.length()));
			
		}
		return number;
	}
	
}




