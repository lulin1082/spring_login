package cn.tedu.ems.system.dao;

import cn.tedu.ems.commom.annotatins.MybatisRepository;
import cn.tedu.ems.commom.dao.baseDao;
import cn.tedu.ems.system.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("roleDao")
@MybatisRepository
public interface RoleDao extends baseDao<Role> {
    List<Role> findObects();
    Role findByName(String roleName);
    Role findById(Integer id);
}
