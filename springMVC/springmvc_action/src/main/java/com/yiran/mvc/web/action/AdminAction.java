package com.yiran.mvc.web.action;

import com.yiran.mvc.pojo.Admin;
import com.yiran.mvc.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminAction {
    @Autowired
    private AdminService adminService;

    /**
     * 参数绑定
     *   1：接收url中参数数据
     *       url?参数=value
     *       表单
     *          a) servlet方式  HttpServletRequest request
     *              request.getParameter(name)
     *
     *          b) 绑定简单参数类型
     *              请求的参数名称和处理器形参名称一致时会将请求参数与形参进行绑定
     *              springmvc - 类型转换
     *
     *   2：传递数据到下一个url(view)
     *      a) 默认支持的web参数类型--与servlet中的一样
     *          HttpServletRequest
     *          HttpServletResponse
     *          HttpSession
     *
     *      b) request域数据 -- springMVC中
     *          Model
     *          ModelMap --> Map
     *
     *      c) 以pojo(实体对象)来进行接收,属性名与参数名要保持一致
     *          pojo对象中属性名和表单中input的name属性一致
     *
     *          springmvc - 默认类型转换
     *              基本类型 - 若数据填写为空，因为基本类型不可为null - 400错误
     *                  - 包装类即可
     *
     *          java.util.Date
     *              由于日期数据有很多种格式，springmvc无法自动转换字符串为日期，所以需要自己定义转换方法。
     *                  自定义DateConverter  utils下
     *
     * */
    @RequestMapping("/login")
    /* 即，这里的userCode，password与页面上传递的请求参数一致 */
    public String login(String userCode, String password, HttpSession session,
                        HttpServletRequest request, Model model, ModelMap modelMap){
        System.out.println(userCode + "\t" + password);
        Admin admin = adminService.login(userCode,password);
        if (admin == null){
            request.setAttribute("info","用户名或密码错误");
            model.addAttribute("info1","用户名或密码错误1"); // model用的比较多
            modelMap.addAttribute("info2","用户名或密码错误2"); // 知道就行
            /*
            * 跳转至url， String - 默认对应的为 视图解析器 + String + 后缀
            * 由于login不在view配置的视图解析器下，所以不能这么写
            * forward:url -- 请求转发,可以保留参数
            * redirect:url -- 重定向
            * */
            return "forward:login.jsp";
        }
        else{
            session.setAttribute("admin",admin);
            return "index";
        }
    }

    @RequestMapping("/admin/ckn")
    @ResponseBody
    public String checkName(String userCode){
        if ("admin".equals(userCode)) {
            return "false";
        }else{
            return "true";
        }
    }
}
