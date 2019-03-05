package cn.tedu.ems.commom.dao;

public interface   baseDao<T >
{
       int updateObject(T t);

      int insertObject(T t);
}
