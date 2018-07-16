package cn.yiran.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "GetCookieServlet",value = "/GetCookieServlet")
public class GetCookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*// 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 获取Cookie对象数组
        Cookie[] cookies = request.getCookies();
        if (cookies != null){
            // 增强for循环取出每个cookie
            for (Cookie cookie : cookies){
                System.out.println(cookie.getName() + " : " + cookie.getValue());
                if (cookie.getName().equals("oldTime")){
                    response.getWriter().write(cookie.getName() + " : " + cookie.getValue());
                }
            }
        }

        // 获取session
        HttpSession session = request.getSession();
        Object username = session.getAttribute("username");
        response.getWriter().write("<p>session保存的用户名为："+username+"</p>");
        // 删掉session后看是否还能获取
        session.removeAttribute("username");
        Object NowUsername = session.getAttribute("username");
        response.getWriter().write("<p>删掉session保存的用户名后："+NowUsername+"</p>");*/
    }
}
