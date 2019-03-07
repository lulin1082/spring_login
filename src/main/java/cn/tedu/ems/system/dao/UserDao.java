package cn.tedu.ems.system.dao;

import cn.tedu.ems.commom.annotatins.MybatisRepository;
import cn.tedu.ems.commom.dao.baseDao;
import cn.tedu.ems.system.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("userDao")
@MybatisRepository
public interface UserDao extends baseDao<User>{

    List<User> findObjects();
    User findObjectById(Integer id);
    User findObjectByName(String username);
}
