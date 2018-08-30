package com.yiran.reverse.pojo;

import java.util.Date;
import java.util.List;

public class Tuser {
    private Integer userid;

    private String username;

    private Date birthday;

    private String sex;

    private String address;

    private Integer age;

    private List<Torder> torders;

    private List<Taddress> taddresses;

    public List<Torder> getTorders() {
        return torders;
    }

    public void setTorders(List<Torder> torders) {
        this.torders = torders;
    }

    public List<Taddress> getTaddresses() {
        return taddresses;
    }

    public void setTaddresses(List<Taddress> taddresses) {
        this.taddresses = taddresses;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}