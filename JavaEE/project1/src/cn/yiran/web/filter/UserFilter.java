package cn.yiran.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Set;

@WebFilter(filterName = "UserFilter",value = {"/jsp/cart.jsp","/CartServlet","/jsp/order_list.jsp"})
public class UserFilter implements Filter {
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

        // 获取登录用户集合
        Set userSession = (Set)context.getAttribute("user");
        if (userSession.contains(session)){
            chain.doFilter(req, resp);
        }
        else {
            response.sendRedirect(path+"/jsp/login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.config = config;
    }

}
