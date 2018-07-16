package cn.yiran.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CookieServlet",value = "/CookieServlet")
public class CookieServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*// 调用构造函数，创建Cookie对象
        Cookie cookie = new Cookie("user","yiran");
        Cookie cookie1 = new Cookie("user1","chunjue");
        Cookie cookie2 = new Cookie("user2","poi");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd&hh:mm:ss");

        String time = sdf.format(new Date());

        Cookie oldTime = new Cookie("oldTime",time);

        // 设置oldTime生存时间为一周
        oldTime.setMaxAge(60*60*24*7);

        // 设置oldTime的路径为/
        oldTime.setPath("/");

        // 将Cookie回送给浏览器
        response.addCookie(cookie);
        response.addCookie(cookie1);
        response.addCookie(cookie2);
        response.addCookie(oldTime);
        response.getWriter().write("cookie");

        // session
        // 使用request.getSession()获取session
        HttpSession session = request.getSession();
        session.setAttribute("username","yiran");
        // 手动创建sessionId的cookie
        Cookie JSESSIONID = new Cookie("JSESSIONID",session.getId());
        // 设置路径，如果不设置路径，则会被服务器创建的cookie覆盖
        JSESSIONID.setPath("/");
        // 设置时间
        JSESSIONID.setMaxAge(10086);
        // 添加到response中
        response.addCookie(JSESSIONID);

        // 将sessionId拼接到url中
        String encodeURL = response.encodeURL("/web/Test1");
        String encodeRedirectURL = response.encodeRedirectURL("/web/Test2");
        System.out.println(encodeURL); // /web/Test1;jsessionid=A679BE548283E31AB0D925733026DDB1
        System.out.println(encodeRedirectURL); // /web/Test1;jsessionid=A679BE548283E31AB0D925733026DDB1*/
    }
}
