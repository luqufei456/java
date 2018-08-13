package cn.yiran.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;

@WebListener()
public class MyContextListener implements ServletContextListener{

    // Public constructor is required by servlet spec
    public MyContextListener() {
    }

    // -------------------------------------------------------
    // ServletContextListener implementation
    // -------------------------------------------------------
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("context监听器启动了");
        /*Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                System.out.println(sdf.format(new Date()));
            }
        },0,1000);*/

        ServletContext context = sce.getServletContext();
        context.setAttribute("onlineNum",0);

        // AtomicInteger可以保证线程安全
        // AtomicInteger
    }

    public void contextDestroyed(ServletContextEvent sce) {
      System.out.println("context监听器关闭了");
    }


}
