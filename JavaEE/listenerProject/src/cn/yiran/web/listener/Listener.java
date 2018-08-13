package cn.yiran.web.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener,ServletRequestListener {

    // Public constructor is required by servlet spec
    public Listener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context监听器启动了");
        ServletContext context = sce.getServletContext();
        // 第一题和第二题
        /*context.setAttribute("callNum",new AtomicInteger(0));
        context.setAttribute("onlineNum",new AtomicInteger(0));*/


        context.setAttribute("touristNum", new ArrayList<HttpSession>());
        context.setAttribute("userNum", new ArrayList<HttpSession>());
    }

    public void contextDestroyed(ServletContextEvent sce) {
      /* This method is invoked when the Servlet Context 
         (the Web application) is undeployed or 
         Application Server shuts down.
      */
    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
        System.out.println("session创建");
        // 第二题
        /*ServletContext context = se.getSession().getServletContext();
        AtomicInteger count = (AtomicInteger)context.getAttribute("onlineNum");
        // 相当于count++;
        count.getAndIncrement();
        // AtomicInteger 线程安全的Integer
        context.setAttribute("onlineNum",count);*/

        ServletContext context = se.getSession().getServletContext();
        HttpSession session = se.getSession();
        List list = (List) context.getAttribute("touristNum");
        list.add(session);
        context.setAttribute("touristNum",list);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        System.out.println("session销毁");
        // 第二题
        /*ServletContext context = se.getSession().getServletContext();
        AtomicInteger count = (AtomicInteger)context.getAttribute("onlineNum");
        // 相当于count--;
        count.getAndDecrement();
        // AtomicInteger 线程安全的Integer
        context.setAttribute("onlineNum",count);*/

        ServletContext context = se.getSession().getServletContext();
        HttpSession session = se.getSession();
        List tList = (List) context.getAttribute("touristNum");
        List oList = (List) context.getAttribute("userNum");
        if (tList.indexOf(session) == -1){
            oList.remove(session);
        }
        else{
            tList.remove(session);
        }
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("request关闭");
    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("request开启");
        // 第一题
        /*ServletContext context = sre.getServletContext();
        AtomicInteger count = (AtomicInteger)context.getAttribute("callNum");
        count.getAndIncrement();
        // AtomicInteger 线程安全的Integer
        context.setAttribute("callNum",count);*/
    }
}
