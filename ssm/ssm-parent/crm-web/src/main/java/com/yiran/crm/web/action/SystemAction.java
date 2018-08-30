package com.yiran.crm.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SystemAction {

    /*
    * 添加用户页面
    *   用户账号
    *   初始密码
    *   用户名
    *   角色：多选框显示所有角色
    * */
    @RequestMapping("/sys/addUser")
    public String addUser(){
        return "menu/index";
    }
}
