package cn.yiran.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "FormServlet",value = "/FormServlet")
public class FormServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 获得session
        HttpSession session = request.getSession();
        // 获取表单数据
        String formUser = request.getParameter("formUser");
        String formPwd = request.getParameter("formPwd");

        // 获取存储了用户信息的Map，该Map中存了用户名与 一个存储了用户名：密码的map
        Map<String,Map<String, String>> formMap = (Map)session.getAttribute("formMap");
        // 如果formMap没有被存入session中
        if (formMap == null){
            formMap = new HashMap<>();
        }

        // 获取formMap的key集合
        Set<String> userKey = formMap.keySet();
        for (String thisUserKey : userKey){
            // 如果该用户名已经存在session中
            if (thisUserKey.equals(formUser)){
                response.getWriter().write("不要重复提交数据，<a href=\"formSubmit.jsp\">重新录入数据</a>");
                return;
            }
        }

        // 定义一个Map，用于存放用户名和密码
        Map<String, String> formUserMap = new HashMap<>();

        // 存放用户名和密码
        formUserMap.put(formUser,formPwd);

        formMap.put(formUser,formUserMap);
        // 更新session
        session.setAttribute("formMap", formMap);

        // 手动创建sessionId的cookie
        Cookie JSESSIONID = new Cookie("JSESSIONID",session.getId());
        // 设置路径，如果不设置路径，则会被服务器创建的cookie覆盖
        JSESSIONID.setPath("/");
        // 设置时间
        JSESSIONID.setMaxAge(10086);
        // 添加到response中
        response.addCookie(JSESSIONID);

        response.getWriter().write("录入成功，<a href=\"formSubmit.jsp\">重新录入数据</a>");
    }
}
