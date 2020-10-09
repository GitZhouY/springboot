package com.example.demo.controller;

import com.example.demo.dto.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName UserController
 * @Description TODO
 * @Author JayZhou
 * @Date 2020/9/28 20:17
 * @Version 1.0
 **/
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    //登录
    @RequestMapping("/login")
    public String show(){
        return "login";
    }
    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    public String login(int id,String password){
        User userBean = userService.logIn(id,password);
        if(userBean!=null){
            return "redirect:list";
        }else {
            return "error";
        }

    }

    /*查询用户列表*/
    @RequestMapping("/list")
    public String userList(Model model) {
        model.addAttribute("users", userService.userList());
        return "list";
    }

    /*删除用户*/
    @RequestMapping("/del")
    public String deleteUser(Integer id) {
        userService.delete(id);
        return "redirect:/list";
    }

    /*添加用户页面*/
    @RequestMapping("/add")
    public String addUser(ModelMap map) {
        map.addAttribute("user", new User());
        return "add";
    }

    /*更新用户页面*/
    @RequestMapping("/update")
    public String updateUser(User user) {
        userService.update(user);
        return "update";
    }

    /*添加完用户后重定向到list页面*/
    @RequestMapping("/saveI")
    public String saveI(@ModelAttribute User user) {

        userService.insert(user);
        return "redirect:/list";
    }

    /*更新完用户后重定向到list页面*/
    @RequestMapping("/saveU")
    public String saveU(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/list";
    }
}
