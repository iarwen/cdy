package com.cdy.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

import com.cdy.domain.BaseDomain;

/**
 * DAO基类
 */
public interface BaseDao<T extends BaseDomain>
{

    public void insert(T t) throws Exception;

    public void insert(List<T> objs) throws Exception;

    public T update(T t) throws Exception;
   
    public T findByID(long id);
    
    public List<T> findByPage(T t,@Param("start")int start,@Param("size")int size); 
    
    public void remove(long id);
}