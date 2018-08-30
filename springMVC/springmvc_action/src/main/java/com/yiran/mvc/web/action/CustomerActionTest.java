package com.yiran.mvc.web.action;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * springmvc - handler处理器
 *
 * 定义class  -  XxxxAction
 *      定义具体操作控制方法
 * */
@Controller
//@RequestMapping("/customer") //url访问时，父结构
public class CustomerActionTest {

    /**
     * 注解式处理器映射器，对类中标记了@ResquestMapping的方法进行映射。*
     *      根据@ResquestMapping定义的url匹配@ResquestMapping标记的方法，匹配成功返回HandlerMethod对象给前端控制器。
     *      HandlerMethod对象中封装url对应的方法Method
     *
     *      @RequestMapping：定义请求url到处理器功能方法的映射
    * */
    @RequestMapping("/queryCustomers")
    public ModelAndView queryCustomers(){
        System.out.println("----------queryCustomers----------");
        // 使用ModelAndView传递数据及视图view -- 了解
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("data","Test"); //request.setAttribute()
        modelAndView.setViewName("mav");
        return modelAndView;
    }

    /**
     视图解析器使用SpringMVC框架默认的InternalResourceViewResolver，这个视图解析器支持JSP视图解析
     逻辑视图名需要在controller中返回ModelAndView指定，比如逻辑视图名为ItemList，则最终返回的jsp视图地址:
     "WEB-INF/view/itemList.jsp"
     最终jsp物理地址：前缀 + 逻辑视图名 + 后缀
     */
    @RequestMapping("/addCustomer")
    public String addCustomer(HttpServletRequest request) {
        request.setAttribute("info","request 233");
        System.out.println("--------addCustomer----------");
        return "customer/add";
    }

}
