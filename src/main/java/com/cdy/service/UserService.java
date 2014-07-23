package com.cdy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdy.dao.UserDao;
import com.cdy.domain.User;
import com.cdy.exception.UserExistException;
import com.cdy.utils.CipherUtil;

/**
 * 用户管理服务器，负责查询用户、注册用户、锁定用户等操作
 * 
 */
@Service
public class UserService
{

    @Autowired
    private UserDao userDao;

    public void remove(String id){
    	userDao.remove(id);
	}
    
    /**
     * 注册一个新用户,如果用户名已经存在此抛出UserExistException的异常
     * 
     * @param user
     * @throws Exception
     */
    public void register(User user) throws Exception
    {
        User u = this.getUserByUserName(user.getUserName());
        if (u != null)
        {
            throw new UserExistException("用户名已经存在");
        }
        else
        {
        	user.setPassword(CipherUtil.generatePassword(user.getPassword()));
            user.setCredit(100);
            user.setUserType(1);
            userDao.insert(user);
        }
    }

    /**
     * 更新用户
     * 
     * @param user
     * @throws Exception
     */
    public void update(User user) throws Exception
    {
        userDao.update(user);
    }

    /**
     * 根据用户名/密码查询 User对象
     * 
     * @param userName
     *            用户名
     * @return User
     */
    public User getUserByUserName(String userName)
    {
        return userDao.getUserByUserName(userName);
    }

    /**
     * 根据userId加载User对象
     * 
     * @param userId
     * @return
     */
    public User getUserById(String userId)
    {
        return userDao.findByID(User.class, userId);
    }

    /**
     * 将用户锁定，锁定的用户不能够登录
     * 
     * @param userName
     *            锁定目标用户的用户名
     * @throws Exception 
     */
    public void lockUser(String id) throws Exception
    {
    	 User user = userDao.findByID(User.class, Integer.parseInt(id));
        user.setLocked(User.USER_LOCK);
        userDao.update(user);
    }

    /**
     * 解除用户的锁定
     * 
     * @param userName
     *            解除锁定目标用户的用户名
     * @throws Exception 
     */
    public void unlockUser(String id) throws Exception
    {
        User user = userDao.findByID(User.class, Integer.parseInt(id));
        user.setLocked(User.USER_UNLOCK);
        userDao.update(user);
    }

    /**
     * 根据用户名为条件，执行模糊查询操作
     * 
     * @param userName
     *            查询用户名
     * @return 所有用户名模糊匹配的userName的用户
     */
    public List<User> queryUserByUserName(String userName)
    {
        return userDao.queryUserByUserName(userName);
    }

    /**
     * 获取所有用户
     * 
     * @return 所有用户
     */
    public List<User> getAllUsers()
    {
        return userDao.findAll(User.class,new String[]{"userId asc"});
    }

}
