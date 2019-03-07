package test.User.dao;

import cn.tedu.ems.system.dao.UserDao;
import cn.tedu.ems.system.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestUserDao {
    @Test
    //测试　持久层
    public void findObjects() {
        String config[] = {"spring-mvc.xml",
                "spring-dbcp.xml",
                "spring-mybatis.xml"};
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);

        UserDao userDao = ac.getBean("userDao", UserDao.class);
        //User use2=userDao.findObjectById(2);
        List<User> list=userDao.findObjects();
        System.out.println(list);
    }
}
