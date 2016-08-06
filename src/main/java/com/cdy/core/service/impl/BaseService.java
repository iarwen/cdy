package com.cdy.core.service.impl;

import com.cdy.core.service.IBaseService;
import com.cdy.dao.BaseDao;
import com.cdy.domain.BaseDomain;

import java.util.List;

/**
 * Created by wnetao_chang on 2016/8/6.<br>
 * service的基类
 */
public abstract class BaseService<T extends BaseDomain> implements IBaseService<T> {

    public abstract BaseDao<T> getDao();

    /**
     * 插入单个实体
     *
     * @param t 待插入单个实体
     */
    @Override
    public void insert(T t) throws Exception {
        getDao().insert(t);
    }

    /**
     * 批量插入
     *
     * @param objs 待插入的实体
     */
    @Override
    public void batchInsert(List<T> objs) throws Exception {
        getDao().batchInsert(objs);
    }

    /**
     * 更新PO
     *
     * @param t po
     */
    @Override
    public void update(T t) throws Exception {
        getDao().update(t);
    }


    /**
     * 删除PO
     *
     * @param entity po
     */
    @Override
    public void remove(T entity) {
        getDao().remove(entity);
    }

    /**
     * 删除PO
     *
     * @param id poid
     */
    @Override
    public void removeById(String id) {
        getDao().removeById(id);
    }

    /**
     * 根据ID获取PO实例
     *
     * @param id fid
     * @return 返回相应的持久化PO实例
     */
    @Override
    public T findById(String id) {
        return getDao().findById(id);
    }

    /**
     * 根据ID获取PO实例
     *
     * @param id fid
     * @return 返回相应的持久化PO实例
     */
    @Override
    public T findById( int id) {
        return getDao().findById(id);
    }

    /**
     * 执行不带参的HQL查询
     *
     * @param hql 不用写order子句
     * @return 查询结果
     */
    @Override
    public List<T> find(String hql) {
        return getDao().find(hql, null);
    }

    /**
     * 执行只有一个参的HQL查询
     *
     * @param hql   不用写order子句
     * @param param hql的参数
     * @return 查询结果
     */
    @Override
    public List<T> find(String hql, Object param) {
        return getDao().find(hql, param);
    }

    /**
     * 执行带参的HQL查询
     *
     * @param hql    不用写order子句
     * @param params hql的参数
     * @return 查询结果
     */
    @Override
    public List<T> find(String hql, List<Object> params) {
        return getDao().find(hql, params);
    }

    /**
     * 执行带参的HQL查询
     *
     * @param hql    不用写order子句
     * @param orders like String[]{"name asc","number desc"}
     * @param params hql的参数
     * @return 查询结果
     */
    @Override
    public List<T> find(String hql, List<String> orders, List<Object> params) {
        return getDao().find(hql, orders, params);
    }

    /**
     * 执行分页带参的HQL查询
     *
     * @param hql       hql
     * @param startPage 起始页从1开始
     * @param pageCount 一页的容量
     * @param orders    like ArrayList {"name asc","number desc"}
     * @param params    hql的参数
     * @return 查询结果
     */
    @Override
    public List<T> find(String hql, int startPage, int pageCount,
                        List<String> orders, List<Object> params) {
        return getDao().find(hql, startPage, pageCount, orders, params);
    }

    /**
     * 将clz下的记录全部查询出来
     *
     * @param orders like ArrayList {"name asc","number desc"}
     * @return 查询结果
     */
    public List<T> findAll(List<String> orders) {
        return getDao().findAll(orders);
    }

}
