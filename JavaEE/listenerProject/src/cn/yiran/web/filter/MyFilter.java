package cn.yiran.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/* 过滤器名称为 MyFilter，在FilterDemoServlet被触发 */
@WebFilter(filterName = "MyFilter",value = "/FilterDemoServlet")
public class MyFilter implements Filter {
    // 销毁的方法
    public void destroy() {
        System.out.println("过滤器销毁");
    }

    // 执行过滤任务的方法
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤操作");
        // 转到下一个过滤器
        chain.doFilter(req, resp);
    }

    // 初始化的方法
    public void init(FilterConfig config) throws ServletException {
        System.out.println("过滤器初始化");
    }

}
