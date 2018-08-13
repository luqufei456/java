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
import java.io.IOException;

@WebServlet(name = "UserUpdateServlet",value = "/UserUpdateServlet")
public class UserUpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        // 1.获取service
        GameUserService userService = new GameUserServiceImpl();

        // 2.判断是否为修改用户信息，这里使用email当参考，因为id接下来进入用户详情页也需要，而username设定无法更改，也不需要
        if (request.getParameter("email") != null) {
            // 采用ajax
            response.setContentType("application/json;charset=UTF-8");
            GameUser gameUser = new GameUser();
            // 2.1获取请求参数
            int id = Integer.parseInt(request.getParameter("id"));
            String password = request.getParameter("password");
            String email = request.getParameter("email");
            boolean activate = Boolean.parseBoolean(request.getParameter("activate"));
            int userLevel = Integer.parseInt(request.getParameter("userLevel"));

            // 2.2封装数据
            gameUser.setId(id);
            gameUser.setEmail(email);
            gameUser.setPassword(password);
            gameUser.setActivate(activate);
            gameUser.setUserLevel(userLevel);

            // 2.3修改数据
            String data = "修改失败";
            if (userService.updateUser(gameUser)){
                data = "修改成功";
            }
            JSONObject jsonObj = new JSONObject();
            jsonObj.put("data",data);
            response.getWriter().print(jsonObj.toString());
        }
        // 3.则为通过id获取该用户的信息
        else{
            // 采用页面格式返回
            response.setContentType("text/html;charset=UTF-8");

            int id = Integer.parseInt(request.getParameter("id"));

            GameUser gameUser = userService.selectById(id);
            request.setAttribute("gameUser",gameUser);
            request.getRequestDispatcher("/admin/gameUser.jsp").forward(request,response);
        }
    }
}
