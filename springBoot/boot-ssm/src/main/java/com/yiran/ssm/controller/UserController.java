package com.yiran.ssm.controller;

import com.github.pagehelper.PageInfo;
import com.yiran.ssm.pojo.SysUser;
import com.yiran.ssm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/")
    public String init(Model model) {
        model.addAttribute("message", "欢迎使用springboot-thymeleaf模板!");
        return "index";
    }

    @RequestMapping("/loginView")
    public String loginView() {
        return "/users/login";
    }

    @RequestMapping("/login")
    public String login(SysUser user, Model model, HttpSession session) {
        SysUser existUser = userService.login(user);
        if(existUser == null) {
            model.addAttribute("info", "用户名或密码错误!");
            return "/users/login";
        }
        session.setAttribute("user", existUser);
        return "index";
    }

    @RequestMapping("/userList")
    public String userList(Model model) {
        PageInfo<SysUser> pageInfo = userService.queryList();
        model.addAttribute("pageInfo", pageInfo);
        return "/users/list";
    }
}
