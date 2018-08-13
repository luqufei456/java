package cn.yiran.web.listener;

import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener()
public class MySessionAttributeListener implements HttpSessionAttributeListener,ServletRequestAttributeListener {

    // Public constructor is required by servlet spec
    public MySessionAttributeListener() {
    }


    // 监听httpSession和request中属性变化，增删改
    public void attributeAdded(HttpSessionBindingEvent sbe) {
      System.out.println("添加属性");
    }

    public void attributeRemoved(HttpSessionBindingEvent sbe) {
      System.out.println("删除属性");
    }

    public void attributeReplaced(HttpSessionBindingEvent sbe) {
      System.out.println("属性变化");
    }
}
