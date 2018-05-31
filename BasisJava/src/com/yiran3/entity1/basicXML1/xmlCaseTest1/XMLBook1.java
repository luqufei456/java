package com.yiran3.entity1.basicXML1.xmlCaseTest1;

/**
 * 书类
 * */

public class XMLBook1 {
    // 书的编号
    private String bid;
    // 书名
    private String title;
    // 价格
    private Integer price;

    public XMLBook1(){}

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    // 重写toString方法
    @Override
    public String toString() {
        return "Book [bid=" + bid + ", title=" + title + ", price=" + price + "]";
    }
}
