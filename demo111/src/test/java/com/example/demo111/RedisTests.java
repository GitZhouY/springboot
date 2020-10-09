package com.example.demo111;

import com.example.demo111.dao.UserDao;
import com.example.demo111.dto.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.security.RunAs;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {

    //注入dao
    @Autowired
    private UserDao userDao;
    ;

    //注入redistemplate
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Test
    public void test() {
        //1.从redis中获取value
        String user = redisTemplate.boundValueOps("account").get();

        //2.判断user是否为空
        if (user == null) {
            //2.1为空则从数据库中获取
            List<User> userList = userDao.selectAll();
            //2.1.1 将其json序列化，存入缓存redis
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                user = objectMapper.writeValueAsString(userList);
                redisTemplate.boundValueOps("accounts").set(user);
                System.out.println("从数据库中获取数据.........");
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
        } else {
            //2.2、否则，从缓存中获取
            System.out.println("从缓存中获取数据............");
        }
        //3 打印结果
        System.out.println(user);
    }

}
