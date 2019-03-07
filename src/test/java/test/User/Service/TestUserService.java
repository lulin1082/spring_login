package test.User.Service;

import cn.tedu.ems.system.dao.UserDao;
import cn.tedu.ems.system.entity.User;
import cn.tedu.ems.system.service.LoginService;
import org.apache.commons.codec.DecoderException;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import sun.rmi.runtime.Log;

import java.awt.*;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class TestUserService {

    @Test
    //测试　业务层
    public void findObjects() {
        String config[] = {"spring-mvc.xml",
                "spring-dbcp.xml",
                "spring-mybatis.xml"};
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        LoginService loginService = ac.getBean("loginService", LoginService.class);
        try {
            loginService.checkLogin("lulin","123456","4E33","4E33");
        } catch (DecoderException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
