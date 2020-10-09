package com.example.demo.mapper;

import com.example.demo.dto.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    //查询所有信息
    List<User> getAllUser();

    //通过id查找
    User getUserById(Integer id);

    //删
    int delUserById(Integer id);

    //改
    int UpdateUser(User user);


    //增
    @Options(useGeneratedKeys = true,keyProperty = "id")//是指定主键生成的并且主键是id
    int InsertUser(User user);

    //登录
    User getLogin(int id,String password);

}
