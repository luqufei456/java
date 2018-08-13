package cn.yiran.web.servlet;

import cn.yiran.web.domain.GameUser;
import cn.yiran.web.service.GameUserService;
import cn.yiran.web.service.impl.GameUserServiceImpl;
import cn.yiran.web.utils.MailUtils;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

@WebServlet(name = "RegisterServlet",value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");


        if (request.getParameter("activate") != null){
            // 采用页面方式
            response.setContentType("text/html;charset=UTF-8");

            // 获取要激活的用户名
            String username = request.getParameter("username");
            // 进行用户激活
            GameUserService userService = new GameUserServiceImpl();
            if (userService.userActivate(username)){
                response.getWriter().write("激活成功，请登录: 192.168.13.15:8080/web/jsp/login.jsp");
            }
            else{
                response.getWriter().write("激活失败");
            }
        }
        else {
            // 采用ajax
            response.setContentType("application/json;charset=UTF-8");

            // 1.获取请求页面的参数
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            String code = request.getParameter("code");

            // 2.封装一个gameUser实例
            GameUser registerUser = new GameUser();
            registerUser.setUsername(username);
            registerUser.setPassword(password);
            registerUser.setEmail(email);

            // 3.进行用户注册逻辑判断
            GameUserService userService = new GameUserServiceImpl();
            JSONObject jsonObj = new JSONObject();

            // 4.获取session
            HttpSession session = request.getSession();

            // 说明没有点击注册过
            if (session.getAttribute("code") == null) {

                if (userService.register(registerUser)) {
                    // 注册成功后，将code存入session中，防止多次点击注册
                    session.setAttribute("code",code);

                    // 如果注册成功,那也需要激活才行，233

                    jsonObj.put("register", true);
                    jsonObj.put("data", "注册成功，请点击邮箱中的地址进行激活账号");
                    // 返回数据给ajax
                    response.getWriter().print(jsonObj.toString());

                    // 发送激活邮件. 这里的话，方法里的东西跑完，输出结果才会返回给前台，所以发送邮件写在哪里都一样，前台反应速度都一样慢
                    // 然而，在这里采用定时器的话，则是使用多线程，其中一个线程用来发送邮件，不需要等邮件发送完成，前台才会收到数据，反应速度大大提升

                    // Timer是一种工具，线程用其安排以后在后台线程中执行的任务。可安排任务执行一次，或者定期重复执行。实际上是个线程，定时调度所拥有的TimerTasks。
                    Timer timer = new Timer();
                    // TimerTask是一个抽象类，它的子类由 Timer 安排为一次执行或重复执行的任务。实际上就是一个拥有run方法的类，需要定时执行的代码放到run方法体内。

                    // timer.schedule(task, firstTime, period);
                    // firstTime为Date类型,period为long
                    // 从firstTime时刻开始，每隔period毫秒执行一次。

                    // 这里使用的则为1s后发送一次邮件。不重复发送
                    timer.schedule(new TimerTask() {
                        @Override
                        public void run() {
                            MailUtils.sendMail("1976967579@qq.com", registerUser.getEmail(), "激活用户", "192.168.13.15:8080/web/RegisterServlet?activate=true&username=" + registerUser.getUsername());
                        }
                    },1000);

                } else {
                    // 注册失败，说明用户已存在
                    jsonObj.put("register", false);
                    jsonObj.put("data", "用户名已存在");
                    // 返回数据给ajax
                    response.getWriter().print(jsonObj.toString());
                }
            }
            else{
                // 注册失败，不要多次点击注册
                jsonObj.put("register", false);
                jsonObj.put("data", "请不要多次点击注册按钮，你烦不烦啊");
                // 返回数据给ajax
                response.getWriter().print(jsonObj.toString());
            }
        }
    }
}
