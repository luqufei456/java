package cn.yiran.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OnlineNumServlet",value = "/OnlineNumServlet")
public class OnlineNumServlet extends HttpServlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取session和context
        ServletContext context =config.getServletContext();
        HttpSession session = request.getSession();

        // 获取到两种List
        List tList = (List)context.getAttribute("touristNum");
        List oList = (List)context.getAttribute("userNum");

        String login = request.getParameter("login");
        System.out.println(login);
        if (request.getParameter("login").equals("up")){
            if (oList.indexOf(session) == -1){
                oList.add(session);
                tList.remove(session);
                context.setAttribute("userNum",oList);
                context.setAttribute("touristNum",tList);
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
            else{
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }
        else{
            if (tList.indexOf(session) == -1){
                tList.add(session);
                oList.remove(session);
                context.setAttribute("userNum",oList);
                context.setAttribute("touristNum",tList);
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
            else{
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }

    }
}
