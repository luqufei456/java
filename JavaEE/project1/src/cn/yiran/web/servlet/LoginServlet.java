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
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");

        // 1.获取请求页面中的数据
        String email = request.getParameter("email");
        String userPwd = request.getParameter("userPwd");
        String code = request.getParameter("code");
        String save = request.getParameter("save");

        System.out.println(email+" "+userPwd+" "+code+" "+save);

        Cookie saveEmail = new Cookie("email",email);
        if (save == null){
            saveEmail.setMaxAge(0);
            response.addCookie(saveEmail);
        }
        else{
            saveEmail.setPath("/");
            saveEmail.setMaxAge(60*60*24);
            response.addCookie(saveEmail);
        }

        // 2.将获取的数据进行封装
        User user = new User();
        user.setEmail(email);
        user.setUserPwd(userPwd);

        // 定义一个boolean，默认false，表示验证码错误
        boolean booleanCode = false;

        // 3.获取验证码，将其小写
        String inputCode = code.toLowerCase();
        // 获取session中的验证码，将其小写
        HttpSession session = request.getSession();
        String sessionCode = session.getAttribute("code").toString().toLowerCase();
        if (sessionCode.equals(inputCode)){
            booleanCode = true;
        }
        if (booleanCode == false){
            response.getWriter().write("验证码错误");
            return;
        }

        // 4.进行用户登录逻辑判断
        UserService userService = new UserServiceImpl();
        User loginUser = userService.login(user);
        if (loginUser == null){
            response.getWriter().write("账号或密码错误");
            return;
        }

        // 5.存储用户User
        session.setAttribute("user",loginUser);

        response.sendRedirect("IndexServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
