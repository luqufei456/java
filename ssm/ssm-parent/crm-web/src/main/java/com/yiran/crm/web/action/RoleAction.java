package com.yiran.crm.web.action;

import com.yiran.crm.pojo.SysRole;
import com.yiran.crm.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
public class RoleAction {

    @Resource
    private RoleService roleService;

    @RequestMapping("/role/roles")
    @ResponseBody
    public List<SysRole> queryRoles(){
        return roleService.queryRoles();
    }
}
