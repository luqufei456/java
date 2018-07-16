package cn.yiran.web.servlet;

import cn.yiran.web.domain.User;
import cn.yiran.web.service.UserService;
import cn.yiran.web.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

@WebServlet(name = "RegisterServlet",value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 1.以Map方式获取浏览器发送的请求
        // getParameterMap() --> 返回一个Map集合，key为String，value为String[]，适应多选框
        Map<String,String[]> map = request.getParameterMap();
        for (String s : map.keySet()) {
            System.out.println("key:" + s);
            System.out.println("values:" + Arrays.toString(map.get(s)));
        }
        User user = new User();
        // 2.使用BeanUtils封装数据
        try {
            // 即使map集合中有的和user的属性不对应，也不会报错，会将对应的属性封装
            // 数组中的多个值，取第一个封装，所以后面还需要再次setHobby
            BeanUtils.populate(user, map);
        } catch (Exception e){
            e.printStackTrace();
        }
        // 3.输出一下
        System.out.println(user);
        // 4.获取爱好
        String[] values = request.getParameterValues("hobby");
        String hobby = "";
        // 5.将爱好拼接为一个字符串
        for (String str : values){
            hobby = hobby + "," + str;
        }
        System.out.println(hobby);
        // 从下标1的地方开始截取，去掉第一个","
        hobby = hobby.substring(1);
        user.setHobby(hobby);
        System.out.println(hobby);

        // 6.沟通业务层，准备注册账号
        UserService service = new UserServiceImpl();
        // 定义一个boolean值，来确认是否注册成功
        boolean info = service.register(user);
        if (info){
            request.setAttribute("name",user.getName());
            request.getRequestDispatcher("wait.jsp").forward(request,response);
        }
        else {
            response.getWriter().write("注册失败~");
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
