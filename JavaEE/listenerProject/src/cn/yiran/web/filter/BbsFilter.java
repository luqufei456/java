package cn.yiran.web.filter;

import cn.yiran.web.utils.ParameterRequestWrapper;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(filterName = "BbsFilter",value = "/*")
public class BbsFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        HttpServletRequest HttpRequest = (HttpServletRequest) req;
        ParameterRequestWrapper requestWrapper = new ParameterRequestWrapper(HttpRequest);
        chain.doFilter(requestWrapper, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
