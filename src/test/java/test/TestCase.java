package test;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.tedu.ems.dao.UserDAO;
import cn.tedu.ems.entity.User;
import cn.tedu.ems.service.LoginService;

public class TestCase {
	@Test
	//测试 连接池
	public void test1() throws SQLException{
		String config = "springmvc.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		DataSource ds = 
				ac.getBean("ds",
						DataSource.class);
		System.out.println(
				ds.getConnection());
	}
	
	
	@Test
	//测试　　持久层
	public void test2(){
		String config = "springmvc.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		UserDAO dao = 
				ac.getBean("userDAO",
						UserDAO.class);
		User user = 
				dao.findByUsername("Sally");
		System.out.println(user);
	}
	
	@Test
	//测试　业务层
	public void test3(){
		String config = "springmvc.xml";
		ApplicationContext ac = 
		new ClassPathXmlApplicationContext(
				config);
		LoginService ls = 
			ac.getBean("loginService",
					LoginService.class);
		User user = 
				ls.checkLogin("Sally", "1234");
		System.out.println(user);
	}
}












