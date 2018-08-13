package cn.yiran.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(filterName = "TestFilter1",value = "/FilterDemoServlet",
    initParams = {
            @WebInitParam(name = "name", value = "chunjue"),
            @WebInitParam(name = "master", value = "yiran")

    }
)
public class TestFilter1 implements Filter {
    private FilterConfig config;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
        System.out.println("过滤器名称："+config.getFilterName());
        // 根据初始化参数名获取参数值
        System.out.println("主人："+config.getInitParameter("master"));
        // 获取初始化参数名的集合
        Enumeration<String> params = config.getInitParameterNames();
        while (params.hasMoreElements()){
            String param = params.nextElement();
            System.out.println("参数名："+param+"，参数值："+config.getInitParameter(param));
        }
        System.out.println("获取context"+config.getServletContext());
    }

}
