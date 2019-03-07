package cn.tedu.ems.system.dao.jdbc;

import cn.tedu.ems.commom.annotatins.MybatisRepository;
import cn.tedu.ems.system.entity.User;
import org.springframework.stereotype.Repository;

/**
 * 持久层接口
 *
 */

public interface UseDaoJdbc {
	public User findObjectByName(String username);

}






