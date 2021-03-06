package com.cdy.dao;

import com.cdy.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User对象Dao
 */
@Repository
public class UserDao extends BaseDao<User> {



    public void remove(String id) {
        User u = this.findById(Integer.parseInt(id));
        if (u == null) return;
        this.remove(u);
    }

    /**
     * 根据用户名查询User对象
     *
     * @param userName 用户名
     * @return 对应userName的User对象，如果不存在，返回null。
     */
    public User getUserByUserName(String userName) {
        List<User> users = this.find( "from User u where u.userName = :userName" , "userName", userName);
        if (users.size() == 0) {
            return null;
        } else {
            return users.get(0);
        }

    }

    /**
     * 根据用户名为模糊查询条件，查询出所有前缀匹配的User对象
     *
     * @param userName 用户名查询条件
     * @return 用户名模糊匹配的所有User对象
     */
    public List<User> queryUserByUserName(String userName) {
        List<String> orders = new ArrayList<>();
        orders.add("id");

        Map<String, Object> params = new HashMap<>();
        params.put("userName", "%" + userName + "%");
        return this.find("from User u where u.userName like :userName", params, orders);
    }


}
