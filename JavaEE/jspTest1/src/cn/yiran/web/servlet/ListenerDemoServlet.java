package cn.yiran.web.servlet;

import cn.yiran.web.domain.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "ListenerDemoServlet",value = "/ListenerDemoServlet")
public class ListenerDemoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        // 获取或创建session
        HttpSession session = request.getSession();
        // 删除session
        //session.invalidate();
        /*session.setAttribute("aa","aa");
        session.setAttribute("aa","bb");
        session.removeAttribute("aa");

        session.setAttribute("product",new Product());
        session.removeAttribute("product");*/

        // 模拟用户登录，用户登录成功，将用户信息保存到session中
        Product product = new Product();
        session.setAttribute("product",product);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }
}
