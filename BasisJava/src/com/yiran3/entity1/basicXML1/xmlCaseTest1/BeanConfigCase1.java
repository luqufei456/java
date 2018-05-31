package com.yiran3.entity1.basicXML1.xmlCaseTest1;

import java.util.Properties;

/**
 * JavaBean配置对象
 *
 *  BeanConfig对象对应的XML中的配置项，作用将解析的XML封装到这个对象中
 * */

public class BeanConfigCase1 {
    // bean的id
    private String id;

    // bean的类名
    private String className;

    // bean的属性
    private Properties props = new Properties();

    public BeanConfigCase1(){}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    // 重写toString方法
    @Override
    public String toString() {
        return "BeanConfig [id=" + id + ", className=" + className + ", props=" + props + "]";
    }
}
