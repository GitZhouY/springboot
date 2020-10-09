package com.example.demo.service;

import com.example.demo.dto.User;
import com.example.demo.mapper.UserMapper;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author JayZhou
 * @Date 2020/9/28 20:16
 * @Version 1.0
 **/
@Service
public class UserService {
    @Autowired
    UserMapper userMapper;

    public List<User> userList(){
        return userMapper.getAllUser();
    }

    public int insert(User user){
        return userMapper.InsertUser(user);
    }

    public int delete(Integer id){
        return userMapper.delUserById(id);
    }

    public int update(User user){
        return userMapper.UpdateUser(user);
    }

    public User getById(Integer id){
        return userMapper.getUserById(id);
    }

    public User logIn(int id, String password){
        return userMapper.getLogin(id,password);

    }
}
