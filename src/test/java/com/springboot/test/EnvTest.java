package com.springboot.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.EnvironmentTestUtils;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.Environment;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * 默认是测试环境的优先检验application.properties
 *
 * 两种方式进行配置参数
 * 1.@SpringBootTest(properties = "app.version=1.0.0")
 * 2.private ConfigurableEnvironment environment;
 *   EnvironmentTestUtils.addEnvironment(environment,"app.admin=admin");
 *
 */



@RunWith(SpringRunner.class)
@SpringBootTest(properties = "app.version=1.0.0")//配置使用参数
public class EnvTest {

    @Autowired
    private ConfigurableEnvironment environment;

    @Before
    public void init(){
        EnvironmentTestUtils.addEnvironment(environment,"app.admin=admin");
        EnvironmentTestUtils.addEnvironment(environment,"app.enable=true");
    }


    @Test
    public void test() {
        Assert.assertEquals("springboottest", environment.getProperty("app.name"));
        Assert.assertEquals("1.0.0", environment.getProperty("app.version"));
        Assert.assertEquals("admin", environment.getProperty("app.admin"));
        Assert.assertEquals("true", environment.getProperty("app.enable"));

    }
}
