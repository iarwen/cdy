package test.cdy.service;

import cdy.AbstractTestCase;
import com.cdy.domain.User;
import com.cdy.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

public class TestUserService extends AbstractTestCase {

    @Autowired
    private UserService userService;


    @Test
    public void insertBatchList() throws Exception {
        List<User> userlist = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            User user = getOneUser();
            userlist.add(user);
        }

        userService.batchInsert(userlist);
        for (User u : userlist) {
            Assert.assertNotNull(u.getId());
        }
    }

    private User getOneUser() {
        User user = new User();
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
    public void insert() throws Exception {
        User user = getOneUser();
        userService.insert(user);
        Assert.assertNotNull(user.getId());
    }

    @Test
    public void getUserByUserName() throws Exception {
        User user = getOneUser();
        userService.insert(user);

        User u = userService.getUserByUserName("3name3");
        Assert.assertNotNull(u);
        Assert.assertNotNull(u.getUserName().equals(user.getUserName()));
    }

    @Test
    public void queryUserByUserName() throws Exception {
        User user = getOneUser();
        user.setUserName("3name3");
        userService.insert(user);

        List<User> ul = userService.queryUserByUserName("name");
        Assert.assertNotNull(ul);
        Assert.assertTrue(ul.size() == 1);
        System.out.println(ul.get(0).getId());
        Assert.assertTrue(ul.get(0).getUserName().equals(user.getUserName()));
    }

    @Test
    public void updateUser() throws Exception {
        User user = getOneUser();
        user.setUserName("3name3");
        userService.insert(user);

        userService.getUserByUserName("3name3");
        User updateu = new User();
        updateu.setUserName("4name4");
        userService.update(updateu);

        Assert.assertEquals(updateu.getUserName(), "4name4");

    }
}
