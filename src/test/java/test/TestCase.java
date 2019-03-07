package test;

import cn.tedu.ems.system.dao.UserDao;
import cn.tedu.ems.system.entity.User;
import cn.tedu.ems.system.service.LoginService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class TestCase {
    @Test
    //测试 连接池
    public void test1() throws SQLException {
        String config[] = {"spring-mvc.xml",
                "spring-dbcp.xml",
                "spring-mybatis.xml"};
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        SqlSessionFactory sessionFactory = ac.getBean("sqlSessionFactory", SqlSessionFactory.class);
        System.out.println(sessionFactory.getConfiguration());
    }

    @Test
    //测试　　持久层
    public void test2() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mvc.xml",
                "spring-dbcp.xml",
                "spring-mybatis.xml");
        UserDao dao = ctx.getBean("userDao", UserDao.class);
        User user = dao.findObjectByName("lulin");
        // System.out.println(user.toString());
    }


/*
    @Test void test333(){
        String config="spring-mybatis.xml";
        ApplicationContext ac= new ClassPathXmlApplicationContext("config") ;
        DataSource ds2=ac.getBean("ds2",DataSource.class);
        System.out.println(ds2.getConnection());
    }
*/

    @Test
    //测试　业务层
    public void test3() {
        String config[] = {"spring-mvc.xml",
                "spring-dbcp.xml",
                "spring-mybatis.xml"};
        ApplicationContext ac =
                new ClassPathXmlApplicationContext(config);
        LoginService ls = ac.getBean("loginService", LoginService.class);
        User user = ls.checkLogin("Sally", "1234", "a", "a");
        System.out.println(user);
    }
}












