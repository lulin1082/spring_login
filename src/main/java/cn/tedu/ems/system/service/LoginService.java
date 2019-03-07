package cn.tedu.ems.system.service;

import cn.tedu.ems.system.entity.User;
import org.apache.commons.codec.DecoderException;

import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * 业务层接口
 *
 */
public interface LoginService {
	public User checkLogin(String username,String pwd,String code,String number) throws DecoderException, NoSuchAlgorithmException;
	public int regist(User user);

}






