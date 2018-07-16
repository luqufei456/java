package cn.yiran.web.servlet;

import cn.yiran.web.domain.User;
import cn.yiran.web.service.UserService;
import cn.yiran.web.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        // 1.获取请求页面中的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String sava = request.getParameter("save");
        System.out.println(sava);

        Cookie savaUser = new Cookie("user",username);
        if (sava == null){
            savaUser.setMaxAge(0);
            response.addCookie(savaUser);
        }
        else{
            savaUser.setMaxAge(60*60*24);
            response.addCookie(savaUser);
        }

        // 2.将获取的数据进行封装
        User user = new User();
        user.setName(username);
        user.setPassword(password);

        // 定义一个boolean，默认false，表示验证码错误
        boolean booleanCode = false;

        // 定义一个boolean，默认false，表示账号或密码错误
        boolean booleanLogin = false;

        // 获取验证码，将其小写
        String inputCode = request.getParameter("code").toLowerCase();
        // 获取session中的验证码，将其小写
        HttpSession session = request.getSession();
        String sessionCode = session.getAttribute("code").toString().toLowerCase();
        if (sessionCode.equals(inputCode)){
            booleanCode = true;
        }

        // 4.进行逻辑判断
        if (booleanCode == false){
            response.getWriter().write("验证码错误");
            return;
        }

        // 3.进行用户登录业务逻辑的判断
        UserService userService = new UserServiceImpl();
        booleanLogin = userService.login(user);

        if (booleanLogin == false){
            response.getWriter().write("账号或密码错误");
            return;
        }
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
