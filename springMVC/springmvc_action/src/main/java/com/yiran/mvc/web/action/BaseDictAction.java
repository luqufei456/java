package com.yiran.mvc.web.action;

import com.yiran.mvc.pojo.BaseDict;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BaseDictAction {
    // 2.通过ajax获取数据，以json方式传回页面
    @RequestMapping("/baseDict/getBases")
    @ResponseBody // 会自动将数据转为json 也可以加到返回结果 List之前，如果不加该注释，则返回的List会被当成一个字符串进行页面跳转，然后发现并无该页面，报错。
    public List<BaseDict> getBase(Integer id){
        BaseDict baseDict1 = new BaseDict();
        baseDict1.setBaseId(1);
        baseDict1.setBaseName("普通");

        BaseDict baseDict2 = new BaseDict();
        baseDict2.setBaseId(2);
        baseDict2.setBaseName("高级");

        BaseDict baseDict3 = new BaseDict();
        baseDict3.setBaseId(3);
        baseDict3.setBaseName("尊享");

        List<BaseDict> list = new ArrayList<>();
        list.add(baseDict1);
        list.add(baseDict2);
        list.add(baseDict3);
        return list;
        // 前端ajax 可以直接 $(data).each(function(){}) 来进行遍历
        // 前端接收到的数据 data = [0:{baseId:2,baseName:"普通"},1:{},2:{}]
        // 下标为key 每个客户为value
    }
}
