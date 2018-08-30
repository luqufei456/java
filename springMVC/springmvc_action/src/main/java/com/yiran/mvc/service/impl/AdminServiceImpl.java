package com.yiran.mvc.service.impl;

import com.yiran.mvc.pojo.Admin;
import com.yiran.mvc.service.AdminService;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public Admin login(String userCode, String password) {
        if ("admin".equals(userCode) && "admin".equals(password)){
            Admin admin = new Admin();
            admin.setUserId(1);
            admin.setUserCode(userCode);
            admin.setName("依然");
            return admin;
        }
        return null;
    }
}
