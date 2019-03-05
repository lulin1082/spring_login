package cn.tedu.ems.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;

import cn.tedu.ems.entity.User;

@Repository("userDAO")
public class UserDAOSpringJdbcImpl implements UserDAO   {
	
	@Autowired
	@Qualifier("jt")
	private JdbcTemplate jt;

	public User findByUsername(String username) {
		String sql="select * from t_user_y"
				+ " where name=?";
		Object[] args={username};
		User user=null;
		try{
			user=jt.queryForObject(sql,args,new UserRowMapper());
		}catch(EmptyResultDataAccessException e){
			return null;
		}
		return user;
	}

	class UserRowMapper implements RowMapper<User>{
		public User mapRow(ResultSet rs,  int arg1) throws SQLException {
			User user=new User();
			user.setId(rs.getInt("id"));
			user.setName(rs.getString("name"));
			user.setUserName(rs.getString("username"));
			user.setGendar(rs.getString("gender"));
			user.setPassword(rs.getString("password"));
			user.setEmail(rs.getString("email"));
			user.setCode(rs.getString("code"));
			user.setState(rs.getInt("state"));
			return user;
		}
		
	}

}
