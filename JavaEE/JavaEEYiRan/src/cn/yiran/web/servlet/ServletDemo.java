package cn.yiran.web.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletDemo extends HttpServlet {
    private ServletConfig config;

    @Override
    public void init(ServletConfig config) throws ServletException{
        this.config = config;
        System.out.println("init()....");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置字符编码格式 utf-8与gbk为常用的中文字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String name = config.getInitParameter("name");
        System.out.println(name);
        System.out.println("doGet....");
        // 不能直接使用this来获取context，会报错，要使用config获取
        ServletContext servletContext = config.getServletContext();


        // 统计页面点击次数
        Object count = servletContext.getAttribute("count");
        if (count == null){
            servletContext.setAttribute("count",1);
        }else {
            int newCount = Integer.parseInt(count.toString());
            servletContext.setAttribute("count",newCount+1);
            int thisCount = newCount+1;
            System.out.println("页面进入次数为："+thisCount);
        }

        // 读取资源文件的绝对路径 --> 参数相对于web目录
        String c3p0Path = servletContext.getRealPath("WEB-INF/classes/c3p0-config.xml");
        System.out.println(c3p0Path);
        // H:\GitTest\GitHubGit\JavaEEYiRan\web\WEB-INF\classes\c3p0-config.xml
        // 然后可以根据路径进行io操作

        // 解析文件的类型
        String c3p0Type = servletContext.getMimeType(c3p0Path);
        System.out.println(c3p0Type);
        // application/xml


        // 设置状态码
        // int sc 是状态码（200,302,404,500），不要设置不存在的响应状态码
        // response.setStatus(200);

        // 设置请求头
        // Refresh --> 设置隔多少s后跳转到某个页面
        // response.setHeader("Refresh","3;url=https://www.jd.com");

        // Location --> 重定向
        // response.setStatus(302); // 重定向状态码
        // response.setHeader("Location","https://www.jd.com");

        // 设置请求体
        // 相应输出一个自定义的网页
        /*response.getWriter().write("<html>");
        response.getWriter().write("<head><title>转向百度</title></head>");
        response.getWriter().write("<body>");
        response.getWriter().write("<a href='https://www.baidu.com'>百度一下</a>");
        response.getWriter().write("</body>");
        response.getWriter().write("</html>");*/

        // 重定向
        // response.sendRedirect("baidu.jsp");
        // 请求转发
        // request.getRequestDispatcher("baidu.jsp").forward(request,response);

        // 获取URI
        System.out.println(request.getRequestURI());
        // 获取URL
        System.out.println(request.getRequestURL());

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doPost....");
    }

}
