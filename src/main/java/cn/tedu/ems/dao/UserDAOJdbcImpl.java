package cn.tedu.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import cn.tedu.ems.entity.User;
/**
 * 持久层实现类
 */

//@Repository("userDAO")
public class UserDAOJdbcImpl implements 
UserDAO{
	
	@Autowired
	@Qualifier("jt")
	private JdbcTemplate jt;
	
	public User findByUsername(String username) {
		User user=new User();
		String sql = "SELECT * FROM "
				+ "t_user_y WHERE username=?";
		Object[] args={user.getUsername()};
		jt.update(sql,args);
		return user;
	}

}

public class UserDAOJdbcImpl
public interface UserDAO

@Autowired
@Qualifier("jt")
	private JdbcTemplate jt;  



















