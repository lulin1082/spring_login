package cn.tedu.ems.system.service;

import javax.annotation.Resource;

import cn.tedu.ems.system.dao.UserDao;
import org.springframework.stereotype.Service;

import cn.tedu.ems.system.entity.User;

/**
 * 业务层实现类
 */
@Service("loginService")
public class LoginServiceImpl implements LoginService {


    @Resource(name = "userDao")
    private UserDao dao;

    public User checkLogin(String username, String pwd, String code, String nember) {


        System.out.println("---====----: " + code.toUpperCase());
        if (code == "" || code == null) {
            throw new ApplicationException("请输入验证码");
        }


        if (!(code.toUpperCase()).equals(nember.toUpperCase().trim())) {
            throw new ApplicationException("验证码不正确");
        }

        User user = dao.findObjectByName(username);

        if (user == null) {

			 /*用户名不存在
                    可以抛出一个应用异常
                     注：
			 表示层在捕获到应用异常之后，
			 需要明确提示用户采取正确的操作。*/

            throw new ApplicationException("用户名不存在");
        }
        if (!user.getPassword().equals(pwd)) {
            throw new ApplicationException(
                    "密码错误");
        }
        //登录验证通过
        System.out.println("----" + user.toString());
        return user;
    }


    public User checkLogin(String username, String pwd) {
        return null;
    }

}
