package com.example.demo111.controller;

import com.example.demo111.dao.UserDao;
import com.example.demo111.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author JayZhou
 * @Date 2020/9/28 15:42
 * @Version 1.0
 **/
@RestController
@RequestMapping("/testBoot")
public class UserController {
    @Autowired
    UserDao userDao;

    //通过用户id获取用户所有信息
    @RequestMapping(value = "getUser/{id}", method = RequestMethod.GET)
    public String GetUser(@PathVariable int id) {
        return userDao.getUserInfo(id).toString();
    }

    //通过用户id删除该用户
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String delete(int id) {
        int result = userDao.deleteById(id);
        if (result >= 1) {
            return "删除成功";
        } else {
            return "删除失败";
        }
    }

    //更新用户信息
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String update(User user) {
        int result = userDao.update(user);
        if (result >= 1) {
            return "修改成功";
        } else {
            return "修改失败";
        }
    }

    //插入新用户
    @RequestMapping(value = "/insert", method = RequestMethod.GET)
    public String insert(User user) {
        userDao.insert(user);
        return "插入成功";
    }

    //打印所有用户信息
    @RequestMapping(value = "/selectAll")
    @ResponseBody
    public List<User> selectAll() {
        return userDao.selectAll();
    }


}
