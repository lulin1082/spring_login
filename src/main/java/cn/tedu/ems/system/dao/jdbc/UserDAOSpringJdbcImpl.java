package cn.tedu.ems.system.dao.jdbc;

import cn.tedu.ems.system.entity.User;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

//@Repository("userDAO")
public class UserDAOSpringJdbcImpl implements UseDaoJdbc {

    //@Autowired
    //@Qualifier("jt")
    private JdbcTemplate jt;

	/*public UserDAOSpringJdbcImpl(JdbcTemplate jt) {
        DataSource ds=new MysqlDataSource();
		Properties posp =new Properties();
		try {
			posp.load(UserDAOSpringJdbcImpl.class.getClassLoader().getResourceAsStream("config.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		BasicDataSource dss=new BasicDataSource();
		dss.setUrl();
		dss.setDriverClassName();


		ds.getConnection();


		jt.setDataSource(ds);
		this.jt = jt;
	}*/

    public User findObjectByName(String username) {
        String sql = "select * from t_user_y" + " where name=?";
        Object[] args = {username};
        User user = null;
        try {
            user = jt.queryForObject(sql, args, new UserRowMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
        return user;
    }

    class UserRowMapper implements RowMapper<User> {
        public User mapRow(ResultSet rs, int arg1) throws SQLException {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setName(rs.getString("name"));
            user.setUserName(rs.getString("username"));
            user.setGendar(rs.getInt("gender"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setCode(rs.getString("code"));
            user.setState(rs.getInt("state"));
            return user;

        }

    }
}
