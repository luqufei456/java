package com.yiran.mybatis.pojo;

import java.io.Serializable;

public class Address implements Serializable {
    private Integer addressId;
    private String addressDetail;
    private String name;
    private String mobile;
    private User user;

    @Override
    public String toString() {
        return "Address{" +
                "addressId=" + addressId +
                ", addressDetail='" + addressDetail + '\'' +
                ", name='" + name + '\'' +
                ", mobile='" + mobile + '\'' +
                ", user=" + user +
                '}';
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
