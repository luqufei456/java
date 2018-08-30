package com.yiran.mvc.service;

import com.yiran.mvc.pojo.Admin;

public interface AdminService {
    Admin login(String userCode,String password);
}
