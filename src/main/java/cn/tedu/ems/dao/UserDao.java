package cn.tedu.ems.dao;

import cn.tedu.ems.commom.dao.baseDao;
import cn.tedu.ems.entity.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userDao")
public interface UserDao extends baseDao<User>{

    List<User> findObjects();
    User findObjectById(Integer id);
    User findObjectByName(String username);
}
