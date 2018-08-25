package com.springboot.test;

import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public class UserDao {

    public boolean login(String name){
        if(name == null){
           return  false;
        }
        return  true;
    }

}
