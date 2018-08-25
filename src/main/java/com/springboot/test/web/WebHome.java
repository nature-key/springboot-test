package com.springboot.test.web;

import com.springboot.test.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebHome {
    @Autowired
    private UserDao userDao;

    @GetMapping("/home")
    public String home() {
        userDao.login("WANGXUA");
        System.out.println("home server is invoke");
        return "home server";
    }
    @GetMapping("/show")
    public String show(@RequestParam String name) {
        System.out.println("home name is invoke");
        return "home server"+name;
    }
}
