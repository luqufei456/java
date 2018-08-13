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
import java.util.List;

@WebServlet(name = "ManagerServlet",value = "/ManagerServlet")
public class ManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        // 采用ajax
        response.setContentType("application/json;charset=UTF-8");

        // 1.获得session，gameUserService
        HttpSession session = request.getSession();
        GameUserService userService = new GameUserServiceImpl();

        // 2.如果获得的请求为，获得所有用户，即后台管理主页进入即发送的ajax
        if (request.getParameter("all_user") != null){
            List<GameUser> userList = userService.selectAll();

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("userList",userList);

            response.getWriter().print(jsonObj.toString());
        }
        // 3.则为用户查询搜索
        else{
            int isActivate = Integer.parseInt(request.getParameter("isActivate"));
            String sort = request.getParameter("sort");
            String username = request.getParameter("username");

            List<GameUser> userList = userService.selectRuler(isActivate,sort,username);

            JSONObject jsonObj = new JSONObject();
            jsonObj.put("userList",userList);

            response.getWriter().print(jsonObj.toString());
        }
    }
}
