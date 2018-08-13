package cn.yiran.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@javax.servlet.annotation.WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private Set<HttpSession> userSession;
    private Set<HttpSession> touristSession;
    private Set<HttpSession> adminSession;
    ServletContext context;

    // Public constructor is required by servlet spec
    public Listener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is
         initialized(when the Web application is deployed). 
         You can initialize servlet context related data here.
        */
        // context初始化
        userSession = new HashSet<>();
        touristSession = new HashSet<>();
        adminSession = new HashSet<>();
        context = sce.getServletContext();

        context.setAttribute("admin",adminSession);
        context.setAttribute("user",userSession);
        context.setAttribute("tourist",touristSession);
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
        // 新访问的用户为游客，放入游客session
        HttpSession session = se.getSession();
        touristSession.add(session);
        context.setAttribute("tourist",touristSession);
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        HttpSession session = se.getSession();

        userSession.remove(session);
        touristSession.remove(session);
        adminSession.remove(session);

        context.setAttribute("user",userSession);
        context.setAttribute("tourist",touristSession);
        context.setAttribute("admin",adminSession);
    }

    // -------------------------------------------------------
    // HttpSessionAttributeListener implementation
    // -------------------------------------------------------

    public void attributeAdded(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute 
         is added to a session.
      */
        HttpSession session = sbe.getSession();

        // 如果有session添加用户标识
        if (sbe.getName().equals("user")){
            if (adminSession.contains(session)){
              adminSession.remove(session);
              context.setAttribute("admin",adminSession);
          }
            else{
                touristSession.remove(session);
                context.setAttribute("tourist",touristSession);
            }
            userSession.add(session);
            context.setAttribute("user",userSession);
        }
        // 否则是添加了管理员标识
        else{
            // 如果这个session本来存在于用户中
            if (userSession.contains(session)){
                userSession.remove(session);
                context.setAttribute("user",userSession);
            }
            // 否则存在于游客中
            else{
                touristSession.remove(session);
                context.setAttribute("tourist",touristSession);
            }
            adminSession.add(session);
            context.setAttribute("admin",adminSession);
        }

    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      /* This method is called when an attribute
         is removed from a session.
      */
        HttpSession session = sbe.getSession();

        // 如果这个退出的用户原来是普通用户
        if (userSession.contains(session)){ 
            userSession.remove(session);
            context.setAttribute("user",userSession);
        }
        // 否则是管理员
        else{
            adminSession.remove(session);
            context.setAttribute("admin",adminSession);
        }
        // 变为游客
        touristSession.add(session);
        context.setAttribute("tourist",touristSession);
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }

    public  void setContext(String s,Set set){
        context.setAttribute(s,set);
    }
}
