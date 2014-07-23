package com.cdy.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;

import com.cdy.domain.BaseDomain;

/**
 * DAO基类
 */
abstract public class BaseDao<T extends BaseDomain>
{
    @PersistenceContext(unitName="jpaPU")
    protected EntityManager entityManager;

    @Autowired
    protected Validator validator;

    public void insert(T t) throws Exception
    {
        if (t == null)
            return;
        Set<ConstraintViolation<T>> set = validator.validate(t);
        if (!set.isEmpty())
            throw new ValidationException("insert时数据校验失败");
        entityManager.persist(t);
    }

    public void insert(List<T> objs) throws Exception
    {
        if (objs == null || objs.isEmpty())
        {
            return;
        }
        for (T obj : objs)
        {
            insert(obj);
        }
    }

    public T update(T t) throws Exception
    {
        if (t == null)
            return null;
        Set<ConstraintViolation<T>> set = validator.validate(t);
        if (!set.isEmpty())
            throw new ValidationException("update时数据校验失败");
        return entityManager.merge(t);
    }
    /**
     * 根据ID获取PO实例
     * 
     * @param id
     * @return 返回相应的持久化PO实例
     */
    public T findByID(Class<T> clz,String id) {
        return (T) entityManager.find(clz, id);
    }
    /**
     * 根据ID获取PO实例
     * 
     * @param id
     * @return 返回相应的持久化PO实例
     */
    public T findByID(Class<T> clz,int id) {
        return (T) entityManager.find(clz, id);
    }  
    /**
     * 执行带参的HQL查询
     * 
     * @param sql 不用写order子句
     * @param params
     * @param orders String[]{"name asc","number desc"}
     * @return 查询结果
     */
    public List<T> find(Class<T> clz,String hql,int start,int limit,String[] orders, Object... params ) {
        StringBuffer sb=new StringBuffer(hql);
        //orders
        if(orders!=null && orders.length>0){
            sb.append(" order by ");
            for(String order : orders){
                sb.append(order).append(" ");
            }
        }
        
        TypedQuery<T> tq= entityManager.createQuery(sb.toString(), clz);
        //where params
        if(params!=null){
            for(int index=0;index<params.length;index++){
                tq.setParameter(index+1, params[index]);
            }
        }
        
        //page
        if(limit>0){
            if(start>0)
                tq.setFirstResult(start);
            tq.setMaxResults(limit);
        }
        return tq.getResultList();
    }
   
    /**
     * 将clz下的记录全部查询出来
     * 
     * @param clz
     * @param orders String[]{"name asc","number desc"}
     * @return 查询结果
     */
    public List<T> findAll(Class<T> clz,String[] orders ) {
        StringBuffer hql=new StringBuffer("select p from "+clz.getSimpleName()+" ");
        
        //orders
        if(orders!=null && orders.length>0){
            hql.append("order by ");
            for(String order : orders){
                hql.append(order).append(" ");
            }
        }
        TypedQuery<T> tq= entityManager.createQuery(hql.toString(), clz);
        return tq.getResultList();
    }
    
    /**
     * 删除PO
     * 
     * @param entity
     */
    public void remove(T entity) {
        entityManager.remove(entity);
    }
}