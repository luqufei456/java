package cn.yiran.web.servlet;

import cn.yiran.web.domain.GameUser;
import cn.yiran.web.service.GameUserService;
import cn.yiran.web.service.impl.GameUserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 采用ajax
        response.setContentType("application/json;charset=UTF-8");

        // 1.获取请求页面中的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 2.进行用户登录逻辑判断
        GameUserService userService = new GameUserServiceImpl();
        GameUser loginUser = userService.login(username,password);
        System.out.println(loginUser);
        if (loginUser == null){
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("data","登录失败，用户名或密码错误");
            response.getWriter().print(jsonObj.toString());
        }
        else{
            // 3.根据用户等级存储相应的数据
            HttpSession session = request.getSession();
            if (loginUser.isActivate() == false){
                JSONObject jsonObj = new JSONObject();
                jsonObj.put("data","用户未激活");
                jsonObj.put("login",false);
                response.getWriter().print(jsonObj.toString());
            }
            else {
                if (loginUser.getUserLevel() == 1) {
                    session.setAttribute("user", loginUser);
                } else if (loginUser.getUserLevel() == 2) {
                    session.setAttribute("admin", loginUser);
                }

                // 存一个gamePlayer
                session.setAttribute("gamePlayer",loginUser);

                JSONObject jsonObj = new JSONObject();
                jsonObj.put("data","/jsp/index.jsp");
                jsonObj.put("login",true);
                response.getWriter().print(jsonObj.toString());
            }
        }
    }
}
