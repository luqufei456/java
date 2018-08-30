package com.yiran.crm.web.action;

import com.yiran.crm.pojo.SysRole;
import com.yiran.crm.pojo.SysUser;
import com.yiran.crm.pojo.UserRoleVo;
import com.yiran.crm.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@Controller
public class UserAction {
    @Resource
    private UserService userService;

    /*
    * 多个参数优先使用pojo
    *   普通类型 - service @Param("name")
    * */
    @RequestMapping("/user/login")
    public String login(SysUser user, Model model,HttpSession session){
        user = userService.login(user);
        if (user == null){
            model.addAttribute("info","用户名或密码错误");
            return "forward:/login.jsp";
        }
        else {
            // 登录成功，保持登录状态
            session.setAttribute("user",user);
            System.out.println(user.getRoles().get(0).getRoleName());
            return "menu/index";
        }
    }

    /*
    * 查询是否有该用户
    * */
    @RequestMapping("/admin/ckn")
    @ResponseBody
    public String queryUserByCode(SysUser user){
        return userService.queryUserByCode(user);
    }

    /*
    * 退出登录
    * */
    @RequestMapping("/user/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login.jsp";
    }

    /*
    * 添加用户
    * */
    @RequestMapping("/user/add")
    public String addUser(UserRoleVo userRoleVo){
        //System.out.println(userRoleVo.getUser().getUserName());
        userService.addUser(userRoleVo);
        return "/success";
    }
}
