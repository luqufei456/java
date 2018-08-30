package com.yiran.crm.web.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.File;

@Controller
public class HrefAction {

    // restful风格
    @RequestMapping("/href/{parent}/{name}")
    public String href(@PathVariable String parent,@PathVariable String name){
        // File.separator == "/"
        return parent + File.separator + name;
    }
}
