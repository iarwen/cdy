package test.cdy.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
    public void testMyDao() throws Exception
    {
        List<User> userlist=new ArrayList<User>();
        User user=new User();
        user.setCredit(100);
        user.setLastIp("192.101.19.122");
        user.setLastVisit(new Date());
        user.setLocked(1);
        user.setPassword("pass");
        user.setUserName("name");
        user.setUserType(1);
        
        userlist.add(user);
        userlist.add((User)user.clone());
        
        userDao.insert(userlist);

    }
}
