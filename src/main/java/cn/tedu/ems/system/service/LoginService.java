package cn.tedu.ems.system.service;

import cn.tedu.ems.system.entity.User;

/**
 * 业务层接口
 *
 */
public interface LoginService {
	public User checkLogin(String username,String pwd,String code,String number);

}






