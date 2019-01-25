package cn.tedu.ems.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.tedu.ems.dao.UserDAO;
import cn.tedu.ems.entity.User;
/**
 * 业务层实现类
 *
 */
@Service("loginService")
public class LoginServiceImpl implements 
LoginService{

	@Resource(name="userDAO")
	private UserDAO dao;
	
	public User checkLogin(String username,
			String pwd) {
		User user = 
				dao.findByUsername(username);
		if(user == null){
			/*
			 * 用户名不存在
			 * 可以抛出一个应用异常
			 * 注：
			 * 	表示层在捕获到应用异常之后，
			 * 	需要明确提示用户采取正确的操作。
			 */
			throw new ApplicationException(
					"用户名不存在");
		}
		if(!user.getPwd().equals(pwd)){
			throw new ApplicationException(
					"密码错误");
		}
		//登录验证通过
		return user;
	}
	

}
