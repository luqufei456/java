package cn.yiran.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@WebFilter(filterName = "AdminFilter",value = "/admin/*")
public class AdminFilter implements Filter {
    private FilterConfig config;

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 获取session
        HttpSession session = request.getSession();
        // 获取context
        ServletContext context = config.getServletContext();
        // 获取项目目录
        String path = request.getContextPath();

        // 获取登录管理员集合
        Set adminSession = (Set)context.getAttribute("admin");
        if (adminSession.contains(session)){
            chain.doFilter(req, resp);
        }
        else {
            response.sendRedirect(path+"/jsp/index.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
