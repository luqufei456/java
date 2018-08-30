package com.yiran.mvc.web.action;

import com.yiran.mvc.pojo.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

@Controller
public class LinkManAction {
    @RequestMapping("linkman/add")
    public String addLinkMan(Model model){
        // 1.action获取数据--传递数据
        List<Customer> list = new ArrayList<>();
        Customer customer1 = new Customer();
        customer1.setCustId(1L);
        customer1.setCustName("阿里巴巴");

        Customer customer2 = new Customer();
        customer2.setCustId(2L);
        customer2.setCustName("腾讯");

        Customer customer3 = new Customer();
        customer3.setCustId(3L);
        customer3.setCustName("小米");

        list.add(customer1);
        list.add(customer2);
        list.add(customer3);

        model.addAttribute("list",list);

        return "linkman/add";
    }

}
