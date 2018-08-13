package cn.yiran.web.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


@WebListener()
public class MyRequestListener implements ServletRequestListener {

    // Public constructor is required by servlet spec
    public MyRequestListener() {
    }


    @Override
    //监听request对象初始化的方法
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("MyServletRequestListener.....requestInitialized....");
    }

    @Override
    //监听request对象销毁的方法
    public void requestDestroyed(ServletRequestEvent sre) {
        System.out.println("MyServletRequestListener.....requestDestroyed....");

    }
}
