package cn.yiran.web.servlet;

import cn.yiran.web.domain.Slave;
import cn.yiran.web.service.SlaveService;
import cn.yiran.web.service.impl.SlaveServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ViewSlaveServlet",value = "/ViewSlaveServlet")
public class ViewSlaveServlet extends HttpServlet {
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
        // 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        // 获得传递的sid参数，根据sid参数找到商品
        String sid = request.getParameter("sid");
        // 调用service方法
        SlaveService slaveService = new SlaveServiceImpl();
        Slave slave = slaveService.getSlave(sid);

        // 获得context，来保存商品
        ServletContext context = this.getServletContext();
        // 将sid作为key
        context.setAttribute(slave.getSid(),slave);

        // 将商品名放入request
        request.setAttribute("slaveSid",slave.getSid());

        // 请求转移
        request.getRequestDispatcher("slaveDetails.jsp").forward(request,response);
    }
}
