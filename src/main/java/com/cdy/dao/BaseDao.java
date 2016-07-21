package com.cdy.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.cdy.domain.BaseDomain;

/**
 * DAO基类
 */
public interface BaseDao<T extends BaseDomain>
{

    public void insert(T t) throws Exception;

    public void insert(List<T> lists) throws Exception;

    public int update(T t) throws Exception;
   
    public T findByID(long id);
    
    public List<T> findByPage(T t,@Param("start")int start,@Param("size")int size); 
    
    public int remove(long id);
}