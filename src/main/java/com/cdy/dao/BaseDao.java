package com.cdy.dao;

import com.cdy.domain.BaseDomain;
import com.cdy.exception.BaseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * DAO基类
 */
abstract public class BaseDao<T extends BaseDomain> {
    @PersistenceContext(unitName = "jpaPU")
    private EntityManager entityManager;

    @Autowired
    protected Validator validator;

    private Class<T> entityClass;

    /**
     * 插入单个实体
     *
     * @param t 待插入单个实体
     */
    public void insert(T t) throws Exception {
        if (t == null)
            return;
        Set<ConstraintViolation<T>> set = validator.validate(t);
        if (!set.isEmpty())
            throw new ValidationException("insert时数据校验失败" + extraValidatorMsg(set));
        entityManager.persist(t);
    }

    /**
     * 批量插入
     *
     * @param objs 待插入的实体
     */
    public void batchInsert(List<T> objs) throws Exception {
        if (objs == null || objs.isEmpty()) {
            return;
        }
        for (T obj : objs) {
            insert(obj);
        }
    }

    /**
     * 更新PO
     *
     * @param t po
     */
    public void update(T t) throws Exception {
        if (StringUtils.isEmpty(t.getId()))
            throw new BaseException("实体的id不能为空");
        Set<ConstraintViolation<T>> set = validator.validate(t);
        if (!set.isEmpty())
            throw new ValidationException("update时数据校验失败:" + extraValidatorMsg(set));
        entityManager.merge(t);
    }


    private String extraValidatorMsg(Set<ConstraintViolation<T>> set) {
        StringBuilder sb = new StringBuilder();

        for (ConstraintViolation<T> violation : set) {
            sb.append(violation.getMessage()).append("/r/n");
        }
        return sb.toString();
    }

    /**
     * 删除PO
     *
     * @param entity po
     */
    public void remove(T entity) {
        entityManager.remove(entity);
    }

    /**
     * 删除PObyid
     *
     * @param id po
     */
    public void removeById(String id) {
        entityManager.remove(findById(id));
    }

    /**
     * 根据ID获取PO实例
     *
     * @param id fid
     * @return 返回相应的持久化PO实例
     */
    public T findById(String id) {
        return entityManager.find(entityClass, id);
    }

    /**
     * 根据ID获取PO实例
     *
     * @param id fid
     * @return 返回相应的持久化PO实例
     */
    public T findById(int id) {
        return entityManager.find(entityClass, id);
    }

    /**
     * 执行不带参的HQL查询
     *
     * @param hql 不用写order子句
     * @return 查询结果
     */
    public List<T> find(String hql) {
        return find(hql, null);
    }

    /**
     * 执行只有一个参的HQL查询
     *
     * @param hql   不用写order子句
     * @param param hql的参数
     * @return 查询结果
     */
    public List<T> find(String hql, Object param) {
        List<Object> params = new ArrayList<>();
        params.add(param);
        return find(hql, null, params);
    }

    /**
     * 执行带参的HQL查询
     *
     * @param hql    不用写order子句
     * @param params hql的参数
     * @return 查询结果
     */
    public List<T> find(String hql, List<Object> params) {
        return find(hql, null, params);
    }

    /**
     * 执行带参的HQL查询
     *
     * @param hql    不用写order子句
     * @param orders like String[]{"name asc","number desc"}
     * @param params hql的参数
     * @return 查询结果
     */
    public List<T> find(String hql, List<String> orders, List<Object> params) {
        return find(hql, 0, 0, orders, params);
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
    public List<T> find(String hql, int startPage, int pageCount,
                        List<String> orders, List<Object> params) {
        Assert.isTrue(startPage >= 0);
        Assert.isTrue(pageCount >= 0);

        StringBuilder sb = new StringBuilder(hql);
        //orders
        orders(orders, sb);

        TypedQuery<T> tq = entityManager.createQuery(sb.toString(), entityClass);

        //where params
        if (!CollectionUtils.isEmpty(params)) {
            for (int index = 0; index < params.size(); index++) {
                tq.setParameter(index + 1, params.get(index));
            }
        }

        //page
        if (pageCount > 0) {
            if (startPage > 0) {
                tq.setFirstResult((startPage - 1) * pageCount);
            } else {
                tq.setFirstResult(0);
            }
            tq.setMaxResults(pageCount);
        }
        return tq.getResultList();
    }


    /**
     * 将clz下的记录全部查询出来
     *
     * @param orders String[]{"name asc","number desc"}
     * @return 查询结果
     */
    public List<T> findAll(List<String> orders) {
        StringBuilder hql = new StringBuilder("from " + entityClass.getSimpleName() + " ");

        StringBuilder sb = new StringBuilder(hql);
        orders(orders, sb);
        TypedQuery<T> tq = entityManager.createQuery(hql.toString(), entityClass);
        return tq.getResultList();
    }


    private void orders(List<String> orders, StringBuilder sb) {
        if (!CollectionUtils.isEmpty(orders)) {
            sb.append(" order by ");
            for (String order : orders) {
                sb.append(order).append(",");
            }
            sb.setLength(sb.length() - 1);
        }
    }

}