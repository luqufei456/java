package cn.yiran.web.servlet;

import cn.yiran.web.domain.User;
import cn.yiran.web.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        // 1.获取请求页面中的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2.将获取的数据进行封装
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        // 3.进行用户登录业务逻辑的判断
        UserService userService = new UserService();
        User loginUser = userService.login(user);

        // 4.判断返回值，做出响应
        if (loginUser == null){
            response.getWriter().write("账号或密码错误");
        }
        else{
            response.getWriter().write("登录成功");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
