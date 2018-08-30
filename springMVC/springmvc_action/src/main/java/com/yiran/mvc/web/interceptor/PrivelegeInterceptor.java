package com.yiran.mvc.web.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class PrivelegeInterceptor implements HandlerInterceptor {
    // Controller执行前调用此方法
    // 返回true表示继续执行，返回false中止执行
    // 这里可以加入登录校验、权限拦截等
    @Override // 前置拦截器
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        //登录权限验证
        HttpSession session = request.getSession();
        if(session.getAttribute("admin") != null) {
            return true;
        } else {
            request.setAttribute("info", "请先登录再进行操作...");
            request.getRequestDispatcher("/login.jsp")
                    .forward(request, response);
            return false;
        }
    }

    // controller执行后但未返回视图前调用此方法
    // 这里可在返回用户前对模型数据进行加工处理，比如这里加入公用信息以便页面显示
    @Override // 运行期间拦截器
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    // controller执行后且视图返回后调用此方法
    // 这里可得到执行controller时的异常信息
    // 这里可记录操作日志
    @Override // 后置拦截器
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
