package test.cdy.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cdy.AbstractTestCase;

import com.cdy.dao.UserDao;
import com.cdy.domain.User;

public class TestUserDao extends AbstractTestCase
{
    @Autowired 
    private UserDao userDao;
    
    @Test
    public void insertList() throws Exception
    {
        List<User> userlist=new ArrayList<User>();
        User user = getOneUser();
        
        userlist.add(user);
        userlist.add((User)user.clone());
        
        userDao.insert(userlist);
        for(User u:userlist){
            Assert.assertNotNull(u.getUserId());
        }
    }
    private User getOneUser()
    {
        User user=new User();
        user.setCredit(100);
        user.setLastIp("192.101.19.122");
        user.setLastVisit(new Date());
        user.setLocked(1);
        user.setPassword("pass");
        user.setUserName("3name3");
        user.setUserType(1);
        return user;
    }
    @Test
    public void insert() throws Exception
    {
        User user = getOneUser();
        userDao.insert(user);
        Assert.assertNotNull(user.getUserId());
    }
    @Test
    public void getUserByUserName() throws Exception{
        User user = getOneUser();
        userDao.insert(user);
        
        User u=userDao.getUserByUserName("3name3");
        Assert.assertNotNull(u);
        Assert.assertNotNull(u.getUserName().equals(user.getUserName()));
    }
    
    @Test
    public void queryUserByUserName() throws Exception{
        User user=getOneUser();
        user.setUserName("3name3");
        userDao.insert(user);
        
        List<User> ul=userDao.queryUserByUserName("name");
        Assert.assertNotNull(ul);
        Assert.assertTrue(ul.size()==1);
        Assert.assertTrue(ul.get(0).getUserName().equals(user.getUserName()));
    }
    @Test
    public void updateUser() throws Exception{
        User user=getOneUser();
        user.setUserName("3name3");
        userDao.insert(user);
        
        User u=userDao.getUserByUserName("3name3");
        User updateu=new User();
        updateu.setUserName("4name4");
        updateu.setUserId(u.getUserId());
        updateu=userDao.update(updateu);
      
        Assert.assertEquals(updateu.getUserName(),"4name4");
        
    }
}
