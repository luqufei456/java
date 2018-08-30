package com.yiran.mvc.pojo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Customer implements Serializable {
    private Long custId;
    private String custName;
    private String custLevel;
    private String custSource;
    // 由于日期数据有很多格式，所以没办法自动转换，要自己定义，否则400报错
    private Date custDate;
    private String custPhone;
    // 如果是 int 填写时输入为空时，则会报错400，基本类型不能为null.换成Integer可以为null
    private Integer custYear;
    private String custAddress;
    private String custZip;
    private String custFax;
    private String custWebsite;
    //	private String[] custMain;			//多选操作
    private List<String> custMain;

    @Override
    public String toString() {
        return "Customer{" +
                "custId=" + custId +
                ", custName='" + custName + '\'' +
                ", custLevel='" + custLevel + '\'' +
                ", custSource='" + custSource + '\'' +
                ", custDate=" + custDate +
                ", custPhone='" + custPhone + '\'' +
                ", custYear=" + custYear +
                ", custAddress='" + custAddress + '\'' +
                ", custZip='" + custZip + '\'' +
                ", custFax='" + custFax + '\'' +
                ", custWebsite='" + custWebsite + '\'' +
                ", custMain=" + custMain +
                '}';
    }

    public List<String> getCustMain() {
        return custMain;
    }

    public void setCustMain(List<String> custMain) {
        this.custMain = custMain;
    }

    public Long getCustId() {
        return custId;
    }

    public void setCustId(Long custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustLevel() {
        return custLevel;
    }

    public void setCustLevel(String custLevel) {
        this.custLevel = custLevel;
    }

    public String getCustSource() {
        return custSource;
    }

    public void setCustSource(String custSource) {
        this.custSource = custSource;
    }

    public Date getCustDate() {
        return custDate;
    }

    public void setCustDate(Date custDate) {
        this.custDate = custDate;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public Integer getCustYear() {
        return custYear;
    }

    public void setCustYear(Integer custYear) {
        this.custYear = custYear;
    }

    public String getCustAddress() {
        return custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustZip() {
        return custZip;
    }

    public void setCustZip(String custZip) {
        this.custZip = custZip;
    }

    public String getCustFax() {
        return custFax;
    }

    public void setCustFax(String custFax) {
        this.custFax = custFax;
    }

    public String getCustWebsite() {
        return custWebsite;
    }

    public void setCustWebsite(String custWebsite) {
        this.custWebsite = custWebsite;
    }

}
