package com.yiran.crm.web.action;

import com.yiran.crm.pojo.BaseDict;
import com.yiran.crm.service.BaseDictService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class BaseDictAction {

    @Resource
    private BaseDictService baseDictService;

    @RequestMapping("/baseDict/queryTypeItems")
    @ResponseBody
    public List<BaseDict> queryBaseDictByType(String dictTypeCode){
        return baseDictService.queryBaseDictByType(dictTypeCode);
    }
}
