package com.springboot.test;


import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
//测试环境Configuration不被认知
@TestConfiguration
public class ApplicationConfig {

    @Bean
    public Runnable createRunable(){

        return ()->{};
    }
}
