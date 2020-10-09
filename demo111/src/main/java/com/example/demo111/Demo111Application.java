package com.example.demo111;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.demo111.dao")
public class Demo111Application {

    public static void main(String[] args) {
        SpringApplication.run(Demo111Application.class, args);
    }

}
