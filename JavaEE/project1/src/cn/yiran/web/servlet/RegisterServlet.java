package cn.yiran.web.servlet;

import cn.yiran.web.domain.User;
import cn.yiran.web.service.UserService;
import cn.yiran.web.service.impl.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "RegisterServlet",value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        // 刷新注册响应信息
        HttpSession session = request.getSession();
        session.setAttribute("registerResponse","");

        // 1.获取请求页面中的数据
        // 昵称
        String userName = request.getParameter("userName");
        // 邮箱
        String email = request.getParameter("email");
        // 密码
        String userPwd = request.getParameter("userPwd");
        // 确认密码
        String confirmPwd = request.getParameter("confirmPwd");
        // 手机号码
        String mobile = request.getParameter("mobile");
        // qq号码
        String qq = request.getParameter("qq");
        // 验证码
        String code = request.getParameter("code").toLowerCase();

        // 2.进行初步验证 --> 密码是否相同，验证码是否相同
        if (userPwd.equals(confirmPwd) == false){
            session.setAttribute("registerResponse","请再次确认密码是否相同");
            request.getRequestDispatcher("jsp/register.jsp").forward(request,response);
            return;
        }

        if (code.equals(session.getAttribute("code").toString().toLowerCase()) == false){
            session.setAttribute("registerResponse","验证码错误");
            request.getRequestDispatcher("jsp/register.jsp").forward(request,response);
            return;
        }
        // 3.通过初步验证后，封装User
        User registerUser = new User();
        registerUser.setEmail(email);
        registerUser.setUserPwd(userPwd);
        registerUser.setUserName(userName);
        registerUser.setMobile(mobile);
        registerUser.setQq(qq);

        // 4.发送数据库请求
        UserService userService = new UserServiceImpl();
        int i = userService.register(registerUser);
        if (i == 0){
            session.setAttribute("registerResponse","用户名(邮箱)已存在");
            request.getRequestDispatcher("jsp/register.jsp").forward(request,response);
            return;
        }
        else{
            // 注册成功，保存登录信息
            // 5.存储用户User
            session.setAttribute("user",registerUser);
            response.sendRedirect("IndexServlet");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
