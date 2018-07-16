package cn.yiran.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name = "MyServlet",value = "/MyServlet",initParams = {
        @WebInitParam(name = "name",value = "yiran"),
        @WebInitParam(name = "age",value = "21")
})
public class MyServlet extends HttpServlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException{
        this.config = config;
        System.out.println("init()....");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("3.0 doPost");

        // 设置字符编码格式 utf-8与gbk为常用的中文字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        // getParameter(name) --> 根据name属性获取值
        String username = request.getParameter("username");
        System.out.println("username:"+username);

        // getParameterValues(name) --> 根据name属性获取多个值，得到的是一个String数组
        String[] hobby = request.getParameterValues("hobby");
        for (String str:hobby){
            System.out.println("hobby:"+str);
        }

        System.out.println("-----------------------------------");

        Map<String, String[]> map = request.getParameterMap();
        // keySet() 获取map中key为一个数组
        for (String key : map.keySet()){
            for (String value : map.get(key)){
                System.out.println("getParameterMap:"+value);
            }
        }

        response.getWriter().write("你说你马呢");

        String age = config.getInitParameter("age");
        String name = config.getInitParameter("name");
        System.out.println(name+":"+age);

        ServletContext servletContext = config.getServletContext();
        Object count = servletContext.getAttribute("count");
        response.getWriter().write("页面点击次数为："+count);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符编码格式 utf-8与gbk为常用的中文字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        ServletContext servletContext = config.getServletContext();
        Object count = servletContext.getAttribute("count");
        response.getWriter().write("页面点击次数为："+count);
    }

}
