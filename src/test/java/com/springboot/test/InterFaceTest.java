package com.springboot.test;

import com.springboot.test.inteface.Login;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class InterFaceTest {
    @MockBean
    private Login login;
    @Test(expected = NullPointerException.class)
    public void test(){
        BDDMockito.given(login.createName("admin")).willReturn("admin");
        BDDMockito.given(login.createName("")).willReturn("");
        BDDMockito.given(login.createName(null)).willThrow(NullPointerException.class);
        Assert.assertEquals("admin",login.createName("admin"));
        Assert.assertEquals("",login.createName(""));
        Assert.assertEquals(null,login.createName(null));
    }

}
