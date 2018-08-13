package cn.yiran.web.domain;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class Product implements HttpSessionBindingListener {
    private int pid;
    private String pname;
    private double shop_price;
    private String pimage;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getShop_price() {
        return shop_price;
    }

    public void setShop_price(double shop_price) {
        this.shop_price = shop_price;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
        System.out.println("product bound");
        ServletContext context = event.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("onlineNum");
        count = count+1;
        context.setAttribute("onlineNum",count);
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
        System.out.println("product unbound");
        ServletContext context = event.getSession().getServletContext();
        Integer count = (Integer) context.getAttribute("onlineNum");
        count = count-1;
        context.setAttribute("onlineNum",count);
    }
}
