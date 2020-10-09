package com.example.demo111.dto;

import lombok.Data;

/**
 * @ClassName User
 * @Description TODO
 * @Author JayZhou
 * @Date 2020/9/28 15:35
 * @Version 1.0
 **/

public class User {
    private int id;
    private String userName;
    private String passWord;
    private String realName;

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", userName='" + userName + '\'' + ", passWord='" + passWord + '\'' + ", realName='" + realName + '\'' + "}";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
