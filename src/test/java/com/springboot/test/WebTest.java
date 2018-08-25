package com.springboot.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//加载整个sptingboot容器
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebTest {
    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void test() {
        String body = testRestTemplate.getForObject("/home", String.class);
        Assert.assertEquals("home server",body);
    }
    @Test
    public void testShow() {
        String body = testRestTemplate.getForObject("/show?name=wnagxuan", String.class);
        Assert.assertEquals("home serverwnagxuan",body);
    }


}
