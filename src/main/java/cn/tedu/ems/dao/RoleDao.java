package cn.tedu.ems.dao;

import cn.tedu.ems.commom.dao.baseDao;
import cn.tedu.ems.entity.Role;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

@Repository("roleDao")
public interface RoleDao extends baseDao<Role> {
    List<Role> findObect();
    Role findByName(String roleName);
    Role findById(Integer id);
}
