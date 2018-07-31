package cn.yiran.web.domain;

import java.util.Date;

public class Product {
    private int pid;
    private String pname;
    private double market_price;
    private double shop_price;
    private String pimage;
    private Date pdate;
    private int is_host;
    private int pflag;
    private String desc;
    private int cid;

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

    public double getMarket_price() {
        return market_price;
    }

    public void setMarket_price(double market_price) {
        this.market_price = market_price;
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

    public Date getPdate() {
        return pdate;
    }

    public void setPdate(Date pdate) {
        this.pdate = pdate;
    }

    public int getIs_host() {
        return is_host;
    }

    public void setIs_host(int is_host) {
        this.is_host = is_host;
    }

    public int getPflag() {
        return pflag;
    }

    public void setPflag(int pflag) {
        this.pflag = pflag;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    @Override
    public String toString() {
        return "Product [pid=" + pid + ", pname=" + pname + ", market_price=" + market_price + ", shop_price="
                + shop_price + ", pimage=" + pimage + ", pdate=" + pdate + ", is_host=" + is_host + ", pflag=" + pflag
                + ", desc=" + desc + ", cid=" + cid + "]";
    }
}
