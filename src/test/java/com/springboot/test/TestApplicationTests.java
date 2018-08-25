package com.springboot.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApplicationTests {
    @Autowired
    private UserDao userDao;

    @Test
    public void contextLoads() {

        Assert.assertEquals(true, userDao.login("wangxuan"));
        Assert.assertEquals(false, userDao.login(null));

    }

}
