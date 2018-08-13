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

@WebServlet(name = "IndexServlet",value = "/IndexServlet")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 采用ajax
        response.setContentType("application/json;charset=UTF-8");

        // 1.获取请求页面的数据
        int newMaxScore = Integer.parseInt(request.getParameter("maxScore"));

        // 2.获取session中存储的用户
        HttpSession session = request.getSession();
        GameUser user = (GameUser) session.getAttribute("user");
        if (user == null){
            user = (GameUser) session.getAttribute("admin");
        }

        // 3.更新最高分数
        GameUserService userService = new GameUserServiceImpl();
        // 3.1在session中更新
        user.setMax_goal(newMaxScore);
        // 如果用户等级为1，则为普通用户
        if (user.getUserLevel() == 1){
            session.setAttribute("user",user);
        }
        else{
            session.setAttribute("admin",user);
        }

        // 4.保存至数据库
        boolean saveGoal = userService.updateGoal(user.getUsername(),user.getMax_goal());
        JSONObject jsonObj = new JSONObject();
        if (saveGoal){
            jsonObj.put("saveScore",true);
        }
        else{
            jsonObj.put("saveScore",false);
        }

        // 5.返回结果给前端
        response.getWriter().print(jsonObj.toString());
    }
}
