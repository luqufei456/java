package com.yiran3.entity1.beanUtils;

import java.util.Arrays;

/**
 * 用于测试的用户类
 * */

public class BeanUtilsUser {
    // 用户id
    private String uid;
    // 用户名
    private String userName;
    // 用户密码
    private String password;
    // 爱好
    private String[] hobbies;
    // 年龄
    private int age;

    public BeanUtilsUser(){}

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String[] getHobbies() {
        return hobbies;
    }

    public void setHobbies(String[] hobbies) {
        this.hobbies = hobbies;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString(){
        return "User [uid=" + uid + ", userName=" + userName +
                ", password=" + password + ", hobbies=" +
                Arrays.toString(hobbies) + ", age=" + age + "]";
    }
}
