package com.cdy.dao;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cdy.domain.User;
/**
 * User对象Dao
 */
@Repository
public class UserDao extends BaseDao<User> {
	private final String GET_USER_BY_USERNAME = "from User u where u.userName = ?";
	
	private final String QUERY_USER_BY_USERNAME = "from User u where u.userName like ?";
	
	public void remove(String id){
		User  u = this.findByID(User.class, Integer.parseInt(id));
		if(u==null) return;
		this.remove(u);
	}
    /**
     * 根据用户名查询User对象
     * @param userName 用户名
     * @return 对应userName的User对象，如果不存在，返回null。
     */
	public User getUserByUserName(String userName){
	    List<User> users = this.find(User.class, GET_USER_BY_USERNAME, 0, 0, null, userName);
	    if (users.size() == 0) {
			return null;
		}else{
			return users.get(0);
		}
    }
	
	/**
	 * 根据用户名为模糊查询条件，查询出所有前缀匹配的User对象
	 * @param userName 用户名查询条件
	 * @return 用户名模糊匹配的所有User对象
	 */
	public List<User> queryUserByUserName(String userName){
	    return this.find(User.class, QUERY_USER_BY_USERNAME, 0, 0, new String[]{"userId"}, "%"+userName+"%");
	}

}
