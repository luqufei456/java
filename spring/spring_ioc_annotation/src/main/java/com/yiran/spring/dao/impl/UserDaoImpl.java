package com.yiran.spring.dao.impl;

import com.yiran.spring.dao.UserDao;
import org.springframework.stereotype.Repository;

// 持久层
@Repository("userDao")
public class UserDaoImpl implements UserDao {
    public void sava(){
        System.out.println("UserDao层被调用了");
    }
}
