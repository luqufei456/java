package com.yiran.bootWeb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class BootController {

    /* 根目录，跳转让你进行登录 这里的登录页面在webapp目录下 */
    @RequestMapping("/")
    public String init(){
        return "forward:/login.jsp";
    }

    @Value("${welcome.message}")
    private String message;

    @RequestMapping("/login/{name}/{pwd}")
    public String login(@PathVariable String name,@PathVariable String pwd, HttpSession session){
        System.out.println(name + "\t" + pwd);
        session.setAttribute("name",name);
        session.setAttribute("message",message);
        return "index";
    }
}
