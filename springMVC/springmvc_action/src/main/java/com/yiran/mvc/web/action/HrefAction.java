package com.yiran.mvc.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HrefAction {

    /** 用于实现页面超链接的跳转,因为页面放在WEB-INF 下，必须通过forward才可以访问，即这里的return */
    @RequestMapping("/href/{name}")
    public String href(@PathVariable String name){
        return name; // == request.forward 请求转发
    }

    // 在目录下的文件超链接
    @RequestMapping("/hrefs/{parent}/{name}")
    public String href(@PathVariable String parent,@PathVariable String name){
        System.out.println(parent + " " + name);
        return parent + "/" + name; // == request.forward 请求转发
    }
}
