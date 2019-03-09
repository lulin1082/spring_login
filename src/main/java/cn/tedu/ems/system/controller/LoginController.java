package cn.tedu.ems.system.controller;

import java.awt.image.RenderedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.ems.commom.exception.ApplicationException;
import cn.tedu.ems.system.service.ls.ImageService;
import cn.tedu.ems.system.service.ls.NumberService;
import org.apache.commons.codec.DecoderException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.tedu.ems.system.entity.User;
import cn.tedu.ems.system.service.LoginService;
import org.springframework.web.bind.annotation.ResponseBody;

import static com.sun.deploy.perf.DeployPerfUtil.write;

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

	/**
	 *
	 * @return 返回登录页
	 */
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "jsp/login";
	}




	@RequestMapping("/login.do")
	public String login(HttpServletRequest request,HttpSession session){
		System.out.println("login()");
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		String code=request.getParameter("number");
		String number=(String)session.getAttribute("number");
		//将请求分发给业务层来处理
		User user = null;
		try {
			user = ls.checkLogin(username, pwd,code,number);
		} catch (DecoderException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		//username pwd code number
		session.setAttribute("user", user);
		Object o=session.getAttribute("user");
		System.out.println("ridirect:");
		return "redirect:toIndex.do";

	}
	


	@RequestMapping("/checkcode.do")
	//输出验证码图片
	public void checkcode(	HttpServletRequest request,HttpServletResponse response)throws IOException{
		String code= NumberService.getRandomCode(4);
		HttpSession session = request.getSession();
		session.setAttribute("number", code);
		/**
		 * step1 生成图片
		 */
		RenderedImage image= ImageService.drawImage(code);
		/**
		 * step2.压缩图片并输出
		 */
		//告诉浏览器,服务器返回的是一个图片
		response.setContentType("image/jpeg");
		OutputStream output = response.getOutputStream();
		//将原始图片按照指定的格式(jpeg)进行压缩,然后输出
		javax.imageio.ImageIO.write(image, "jpeg", output);
		output.close();
	}



	@ResponseBody
	@RequestMapping("/222")
	public List  getdNumber(int size){
		List list =null;
		//list.add("33");
		Map map=new HashMap();
		map.put(1,"ds");
		map.put(2,"dss");
		Throwable t;
		String src="dl";
		list.add(map);
		list.add(src);
		return  list;
	}

	
}





