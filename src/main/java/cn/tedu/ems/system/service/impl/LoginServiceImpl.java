package cn.tedu.ems.system.service.impl;

import javax.annotation.Resource;

import cn.tedu.ems.commom.exception.ApplicationException;
import cn.tedu.ems.system.dao.UserDao;
import cn.tedu.ems.system.service.LoginService;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.springframework.stereotype.Service;

import cn.tedu.ems.system.entity.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 业务层实现类
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {


    @Resource(name = "userDao")
    private UserDao dao;


    public User checkLogin(String username, String pwd, String code, String nember) throws DecoderException, NoSuchAlgorithmException {
        System.out.println("---====----: " + code.toUpperCase());
        if (code == "" || code == null) {
            throw new ApplicationException("请输入验证码");
        }
        if (!(code.toUpperCase()).equals(nember.toUpperCase().trim())) {
            throw new ApplicationException("验证码不正确");
        }
        User user = dao.findObjectByName(username);
        if (user == null) {
			 /*用户名不存在可以抛出一个应用异常
            注： 表示层在捕获到应用异常之后， 需要明确提示用户采取正确的操作。*/
            throw new ApplicationException("用户名不存在");
        }

            if(!isComfired(user.getPassword(), user.getSalt(), pwd))
                throw new ApplicationException("密码错误");

        //登录验证通过
        System.out.println("----" + user.toString());
        return user;
    }

    private boolean isComfired(String password, String salt, String pwd)  {
        MessageDigest md = null;
        String result=" ";
        try {
            md = MessageDigest.getInstance("md5");
            md.update(salt.getBytes());
            md.update(pwd.getBytes());
            String resutl = Hex.encodeHexString(md.digest());
            if(result.equals(pwd)){
                return true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return false;

    }





    @Override
    public int regist(User user) {
        return 0;
    }


}
