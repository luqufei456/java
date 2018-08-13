package cn.yiran.web.listener;


import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class MySessionListener implements HttpSessionListener {

    // Public constructor is required by servlet spec
    public MySessionListener() {
    }

    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        System.out.println("session监听器启动了");
        // 可以通过session获取context
        ServletContext context = se.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("onlineNum");
        count = count+1;
        context.setAttribute("onlineNum",count);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        System.out.println("session监听器关闭了");
    }


}
