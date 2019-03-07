package test.common;

import cn.tedu.ems.system.dao.UserDao;
import cn.tedu.ems.system.entity.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import javax.sql.DataSource;
import java.sql.SQLException;

public class TestCommon {


    @Test
    //测试 连接池
    public void test1() throws SQLException {
        String config = "spring-dbcp.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        DataSource ds = ac.getBean("ds", DataSource.class);
        System.out.println(ds.getConnection());
    }


    @Test
    //测试　　持久层
    public void test2() {
        String config = "spring-mvc.xml";
        ApplicationContext ac = new ClassPathXmlApplicationContext(config);
        UserDao dao = ac.getBean("useDao", UserDao.class);
        User user = dao.findObjectByName("lulin");
         System.out.println(user.toString());
    }

    @Test
    public void test333() throws SQLException {
        String config="spring-mybatis.xml";
        ApplicationContext ac= new ClassPathXmlApplicationContext("config") ;
        DataSource ds2=ac.getBean("ds",DataSource.class);
        System.out.println(ds2.getConnection());
    }



}
