package com.springboot.test;

import com.springboot.test.bean.User;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes=ApplicationConfig.class)
public class Test {
    @Autowired
    private ApplicationContext context;

    //测试的方法是public
    @org.junit.Test
    public void test(){

        Assert.assertNotNull(context.getBean(User.class));
        Assert.assertNotNull(context.getBean(ApplicationConfig.class));
    }
}
