package cn.yiran.web.listener;

import cn.yiran.web.domain.Cart;
import cn.yiran.web.domain.OrderInfo;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.*;
import java.util.*;

@WebListener()
public class Listener implements ServletContextListener,
        HttpSessionListener, HttpSessionAttributeListener {

    private Set<HttpSession> userSession;
    private Set<HttpSession> adminSession;
    private Map<Integer,Cart> myCart;
    // 订单集合，存储订单，而订单中存储各种商品和购买的个数
    private Set<OrderInfo> orderList;
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
        adminSession = new HashSet<>();
        context = sce.getServletContext();

        context.setAttribute("admin",adminSession);
        context.setAttribute("user",userSession);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }

    // -------------------------------------------------------
    // HttpSessionListener implementation
    // -------------------------------------------------------
    public void sessionCreated(HttpSessionEvent se) {
    }

    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
        HttpSession session = se.getSession();

        userSession.remove(session);
        adminSession.remove(session);

        context.setAttribute("user",userSession);
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
            userSession.add(session);
            context.setAttribute("user",userSession);
            // 用户登录，给该用户session中添加一个购物车
            myCart = new HashMap<>();
            // 添加一个订单集合
            orderList = new HashSet<>();
            session.setAttribute("myCart",myCart);
            session.setAttribute("orderList",orderList);
        }
        // 否则是添加了管理员标识，不能直接else，因为上面在session中添加了myCart
        else if (sbe.getName().equals("admin")){
            // 如果这个session本来存在于用户中
            if (userSession.contains(session)){
                userSession.remove(session);
                context.setAttribute("user",userSession);
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
        // 否则是管理员，和上面同理，不能直接else了
        else if(adminSession.contains(session)){
            adminSession.remove(session);
            context.setAttribute("admin",adminSession);
        }

    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      /* This method is invoked when an attibute
         is replaced in a session.
      */
    }

}
