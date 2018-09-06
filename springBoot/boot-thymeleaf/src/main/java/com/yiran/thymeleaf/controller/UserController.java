package com.yiran.thymeleaf.controller;


import com.yiran.thymeleaf.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/loginView")
    public String loginView(){
        return "/users/login";
    }

    @RequestMapping("/login")
    public String login(User user, Model model, HttpSession session){
        if ("yiran".equals(user.getUserCode()) && "123456".equals(user.getPassword())) {
            session.setAttribute("user",user);
            return "index";
        }
        model.addAttribute("info","用户名或密码错误");
        return "/users/login";
    }

    @RequestMapping("userList")
    public String userList(Model model){
        List<User> userList = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);
        user1.setName("依然");
        user1.setUserCode("yiran");

        User user2 = new User();
        user2.setUserId(2);
        user2.setName("蠢喵");
        user2.setUserCode("miaojiang");

        userList.add(user1);
        userList.add(user2);
        model.addAttribute("userList",userList);
        return "/users/list";
    }
}
