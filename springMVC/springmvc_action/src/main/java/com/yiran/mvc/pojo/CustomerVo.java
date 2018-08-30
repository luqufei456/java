package com.yiran.mvc.pojo;

import java.io.Serializable;

public class CustomerVo implements Serializable {
    /* 表单参数 对象名.属性 */
    private Customer customer;
    private Integer minYear;
    private Integer maxYear;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Integer getMinYear() {
        return minYear;
    }

    public void setMinYear(Integer minYear) {
        this.minYear = minYear;
    }

    public Integer getMaxYear() {
        return maxYear;
    }

    public void setMaxYear(Integer maxYear) {
        this.maxYear = maxYear;
    }

    @Override
    public String toString() {
        return "CustomerVo{" +
                "customer=" + customer +
                ", minYear=" + minYear +
                ", maxYear=" + maxYear +
                '}';
    }
}
