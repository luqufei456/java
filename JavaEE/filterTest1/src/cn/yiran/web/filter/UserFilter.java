package cn.yiran.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@WebFilter(filterName = "UserFilter",value = "/userJsp/*")
public class UserFilter implements javax.servlet.Filter {
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

        Set touristSession = (Set)context.getAttribute("tourist");

        if (touristSession.contains(session) == false){
            chain.doFilter(req, resp);
        }
        else{
            response.sendRedirect(path+"/index.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
