package cn.yiran.web.servlet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet",value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
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
        response.setContentType("text/html; charset=utf-8");

        String path = request.getContextPath();

        HttpSession session = request.getSession();
        String arg = request.getParameter("arg");
        if (arg.equals("user")){
            session.setAttribute("user","aa");
            response.sendRedirect(path+"/userJsp/userHtml.jsp");
            return;
        }
        else if (arg.equals("admin")){
            session.setAttribute("admin","bb");
            response.sendRedirect(path+"/adminJsp/adminHtml.jsp");
            return;
        }
        else {
            if (session.getAttribute("user") != null){
                session.removeAttribute("user");
            }
            else if (session.getAttribute("admin") != null){
                session.removeAttribute("admin");
            }
            else{
                return;
            }
        }
        request.getRequestDispatcher("/index.jsp").forward(request,response);
    }
}
