package com.cdy.core.service;

import java.util.List;

/**
 * Created by wentao_chang on 2016/8/6.
 * super service interface
 */
public interface IBaseService<T> {
    /**
     * 插入单个实体
     *
     * @param t 待插入单个实体
     */
    void insert(T t) throws Exception;

    /**
     * 批量插入
     *
     * @param t 待插入的实体
     */
    void batchInsert(List<T> t) throws Exception;

    /**
     * 更新PO
     *
     * @param t po
     */
    void update(T t) throws Exception;

    /**
     * 删除PO
     *
     * @param entity po
     */
    void remove(T entity) throws Exception;

    /**
     * 删除POById
     *
     * @param id deleted Id
     */
    void removeById(String id) throws Exception;

    /**
     * 根据ID获取PO实例
     *
     * @param id  fid
     * @return 返回相应的持久化PO实例
     */
    T findById(String id) throws Exception;

    /**
     * 根据ID获取PO实例
     *
     * @param id fid
     * @return 返回相应的持久化PO实例
     */
    T findById(int id) throws Exception;

    /**
     * 执行不带参的HQL查询
     *
     * @param hql 不用写order子句
     * @return 查询结果
     */
    List<T> find(String hql) throws Exception;

    /**
     * 执行只有一个参的HQL查询
     *
     * @param hql   不用写order子句
     * @param param hql的参数
     * @return 查询结果
     */
    List<T> find(String hql, Object param) throws Exception;

    /**
     * 执行带参的HQL查询
     *
     * @param hql    不用写order子句
     * @param params hql的参数
     * @return 查询结果
     */
    List<T> find(String hql, List<Object> params) throws Exception;

    /**
     * 执行带参的HQL查询
     *
     * @param hql    不用写order子句
     * @param orders like String[]{"name asc","number desc"}
     * @param params hql的参数
     * @return 查询结果
     */
    List<T> find(String hql, List<String> orders, List<Object> params) throws Exception;

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
    List<T> find(String hql, int startPage, int pageCount, List<String> orders, List<Object> params) throws Exception;

    /**
     * 将clz下的记录全部查询出来
     *
     * @param orders like ArrayList {"name asc","number desc"}
     * @return 查询结果
     */
    List<T> findAll(List<String> orders) throws Exception;
}
