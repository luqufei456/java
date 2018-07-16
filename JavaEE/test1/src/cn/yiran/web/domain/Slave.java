package cn.yiran.web.domain;

public class Slave {
    private String sid;
    private String name;
    private String introduc;
    private int price;

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduc() {
        return introduc;
    }

    public void setIntroduc(String introduc) {
        this.introduc = introduc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Slave{" +
                "sid='" + sid + '\'' +
                ", name='" + name + '\'' +
                ", introduc='" + introduc + '\'' +
                ", price=" + price +
                '}';
    }
}
