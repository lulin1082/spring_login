package cn.tedu.ems.commom.dao;
import cn.tedu.ems.commom.annotatins.MybatisRepository;
import org.springframework.stereotype.Repository;

public interface baseDao<T> {

    int updateObject(T t);
    int insertObject(T t);
}
