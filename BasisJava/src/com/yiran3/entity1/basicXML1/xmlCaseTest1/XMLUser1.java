package com.yiran3.entity1.basicXML1.xmlCaseTest1;

/**
 * XML测试用 用户类
 * */

public class XMLUser1 {
    // 用户id
    private String uid;
    // 用户名
    private String userName;
    // 用户密码
    private String password;

    public XMLUser1() {
    }

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

    // 重写toString方法
    @Override
    public String toString() {
        return "User [uid=" + uid + ", userName=" + userName + ", password=" + password + "]";
    }
}
