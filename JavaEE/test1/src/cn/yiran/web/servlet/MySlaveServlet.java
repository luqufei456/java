package cn.yiran.web.servlet;

import cn.yiran.web.domain.Slave;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "MySlaveServlet",value = "/MySlaveServlet")
public class MySlaveServlet extends HttpServlet {
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

        // 获得session
        HttpSession session = request.getSession();
        // 得到我储备家园中的奴隶map集合
        Map<String,Map<Slave,Integer>> slaveMap = (Map)session.getAttribute("slaveMap");

        if(slaveMap == null){
            response.getWriter().write("您目前还没有奴隶在预购中");
            response.getWriter().write("<a href=\"store.html\">继续浏览商品</a>");
            return;
        }

        // 遍历
        Set<String> sids = slaveMap.keySet();
        for (String sid : sids){
            // 获得Map<Slave,Integer>
            Map<Slave,Integer> thisSlaveMap = slaveMap.get(sid);
            Set<Slave> thisSlaveSet = thisSlaveMap.keySet();
            for (Slave thisSlave : thisSlaveSet){
                response.getWriter().write("<p>奴隶ID："+ thisSlave.getSid() +"</p>");
                response.getWriter().write("<p>奴隶名称："+ thisSlave.getName() +"</p>");
                response.getWriter().write("<p>奴隶简介："+ thisSlave.getIntroduc() +"</p>");
                int number = thisSlaveMap.get(thisSlave);
                int countPrice = thisSlave.getPrice()*number;
                response.getWriter().write("<p>奴隶总价："+ countPrice +"</p>");
                response.getWriter().write("<p>奴隶数量："+ number +"</p>");
            }
            response.getWriter().write("<br />");
        }
        response.getWriter().write("<a href=\"store.html\">继续浏览商品</a>");
    }
}
