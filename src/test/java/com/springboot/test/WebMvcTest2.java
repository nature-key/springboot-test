package com.springboot.test;


import com.springboot.test.web.WebHome;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
//仅仅加载controller
//@org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest(controllers= WebHome.class)
@SpringBootTest
@AutoConfigureMockMvc
public class WebMvcTest2 {
    @Autowired
    private MockMvc mvc;
    @Test
    public void test() throws  Exception{
        mvc.perform(MockMvcRequestBuilders.get("/show").param("name","wangxaun")).andExpect(MockMvcResultMatchers.status().isOk());
        mvc.perform(MockMvcRequestBuilders.get("/home")).andExpect(MockMvcResultMatchers.status().isOk()).andExpect(MockMvcResultMatchers.content().string("home server"));

    }

}
