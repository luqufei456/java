package cn.yiran.web.servlet;

import cn.yiran.web.domain.User;
import cn.yiran.web.service.UserService;
import cn.yiran.web.service.impl.UserServiceImpl;
import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.OperatingSystem;
import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ShowServlet",value = "/ShowServlet")
public class ShowServlet extends HttpServlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        this.config = config;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码格式
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        UserService service = new UserServiceImpl();
        List<User> list = service.show();

        for (User user : list){
            response.getWriter().write("<p>"+user.toString()+"</p>");
        }

        // UserAgentUtils使用
        // 获取agent字符串
        String agent = request.getHeader("User-Agent");
        System.out.println("agent:"+agent);
        // 解析agent字符串获得用户代理对象
        UserAgent userAgent = UserAgent.parseUserAgentString(agent);
        // 获取浏览器对象
        Browser browser = userAgent.getBrowser();
        // 获取操作系统对象
        OperatingSystem operatingSystem = userAgent.getOperatingSystem();

        response.getWriter().write("<p>浏览器名：" + browser.getName() + "</p>");
        response.getWriter().write("<p>浏览器类型：" + browser.getBrowserType() + "</p>");
        response.getWriter().write("<p>浏览器家族：" + browser.getGroup() + "</p>");
        response.getWriter().write("<p>浏览器生产厂商：" + browser.getManufacturer() + "</p>");
        response.getWriter().write("<p>浏览器使用的渲染引擎：" + browser.getRenderingEngine() + "</p>");

        response.getWriter().write("<p>浏览器版本：" + userAgent.getBrowserVersion() + "</p>");

        response.getWriter().write("<p>操作系统名：" + operatingSystem.getName() + "</p>");
        response.getWriter().write("<p>访问设备类型：" + operatingSystem.getDeviceType() + "</p>");
        response.getWriter().write("<p>操作系统家族：" + operatingSystem.getGroup() + "</p>");
        response.getWriter().write("<p>操作系统生产厂商" + operatingSystem.getManufacturer() + "</p>");
    }
}
