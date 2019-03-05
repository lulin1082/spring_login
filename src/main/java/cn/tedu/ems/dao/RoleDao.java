package cn.tedu.ems.dao;

import cn.tedu.ems.entity.Role;
import cn.tedu.ems.commom.dao.baseDao;

public abstract class RoleDao extends baseDao<Role>{


    @Override
    public int insertObject(Role role) {
        return 0;
    }
}
