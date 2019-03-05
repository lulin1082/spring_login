package cn.tedu.ems.dao;

import cn.tedu.ems.commom.dao.baseDao;
import cn.tedu.ems.entity.User;

/**
 * 持久层接口
 *
 */
public interface UserDAO  {
	public User findByUsername(
			String username);
}






