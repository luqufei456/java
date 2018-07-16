package cn.yiran.web.servlet;

import cn.yiran.web.domain.Slave;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "AddSlaveServlet",value = "/AddSlaveServlet")
public class AddSlaveServlet extends HttpServlet {
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

        // 获取sid的值和购买的数量
        String sid = request.getParameter("sid");
        int number = Integer.parseInt(request.getParameter("number"));
        // 获取context对象
        ServletContext context = config.getServletContext();
        // 通过sid将slave取出来
        Slave slave = (Slave) context.getAttribute(sid);

        // 将slave和购买的数量组成一个map
        Map<Slave,Integer> thisSlaveMap = new HashMap<>();
        thisSlaveMap.put(slave,number);

        // 使用request.getSession()获取session
        HttpSession session = request.getSession();

        // 判断session中是否有slaveMap，如果有，则取出，对内添加，否则创建一个，对内添加，再存入session
        Map<String,Map<Slave,Integer>> slaveMap = (Map) session.getAttribute("slaveMap");
        if (slaveMap == null){
            slaveMap = new HashMap<>();
            slaveMap.put(sid,thisSlaveMap);
        }
        else{
            // 取出Map的key，进行遍历
            Set<String> key = slaveMap.keySet();
            // 定义一个数，来确定是否存在于map，默认不存在
            int i = 0;
            for (String thisSid : key){
                if (thisSid.equals(sid)){
                    // 取出其值，为一个Map<Slave,Integer>的双列集合
                    Map<Slave,Integer> formerSlave = slaveMap.get(thisSid);
                    // 取出key
                    Set<Slave> formesKey = formerSlave.keySet();
                    for (Slave formesKeySlave : formesKey){
                        int formerNumber = formerSlave.get(formesKeySlave);
                        int nowNumber = number + formerNumber;
                        formerSlave.put(formesKeySlave,nowNumber);
                    }
                    i = 1;
                }
            }
            if (i == 0){
                // 如果这个新map不存在于 slaveMap，则加进去
                slaveMap.put(sid,thisSlaveMap);
            }
        }

        // 更新session
        session.setAttribute("slaveMap",slaveMap);
        // 手动创建sessionId的cookie
        Cookie JSESSIONID = new Cookie("JSESSIONID",session.getId());
        // 设置路径，如果不设置路径，则会被服务器创建的cookie覆盖
        JSESSIONID.setPath("/");
        // 设置时间
        JSESSIONID.setMaxAge(10086);
        // 添加到response中
        response.addCookie(JSESSIONID);

        // 请求转移
        request.getRequestDispatcher("slaveWait.jsp").forward(request,response);
    }
}
