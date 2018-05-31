package com.yiran3.entity1.basicXML1.xmlCaseTest1;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.util.*;

/**
 * Bean工厂类
 *      读取XML配置文件中配置的JavaBean信息，将读取都的信息
 *   使用BeanUtils封装进JavaBean对象，将对象存储在Map集合，
 *   并在BeanFactory中提供通过id查找JavaBean的方法。
 * */

public class BeanFactoryCase1 {
    // 1.1提供Map存放 bean.xml配置文件中所有内容，
    // 且易于快速查询，使用Map<String,BeanConfig>
    private static Map<String, BeanConfigCase1> cache = new HashMap<>();

    // 设置一个静态的解析XML属性
    static{
        try {
            // 1) 加载xml文件，获得document
            SAXReader saxReader = new SAXReader();
            // 设置路径
            String xmlPath = "src\\com\\yiran3\\entity1\\basicXML1\\xmlCaseTest1\\bean-case1.xml";
            Document document = saxReader.read(xmlPath);

            // 2) 获得根元素<beans>
            Element rootElement = document.getRootElement();

            // 3) 获得所有的<bean>元素
            List<Element> allBeanElement = rootElement.elements("bean");
            for (Element beanElement : allBeanElement){
                // 4) 获得bean的id和className属性
                String id = beanElement.attributeValue("id");
                String className = beanElement.attributeValue("className");

                // 没问题
                //System.out.println("beanId："+id);
                //System.out.println("beanClassName："+className);

                // 创建BeanConfigCase1 封装id和className
                BeanConfigCase1 beanConfig = new BeanConfigCase1();
                beanConfig.setId(id);
                beanConfig.setClassName(className);
                // System.out.println("BeanConfigCase1："+beanConfig);

                // 5) 获得<property>子标签
                List<Element> allPropertyElement = beanElement.elements("property");
                // System.out.println(allPropertyElement);

                // 这里是遍历 allPropertyElement
                for (Element propElement : allPropertyElement){
                    // 6) 获得property的name和value属性
                    String name = propElement.attributeValue("name");
                    String value = propElement.attributeValue("value");
                    // System.out.println("propertyName："+name);
                    // System.out.println("propertyValue："+value);

                    // 将 name和value 封装到BeanConfigCase1.props中
                    // 第一步得到props 然后用properties的方法加入map中
                    beanConfig.getProps().setProperty(name, value);
                }

                // 将封装好的BeanConfig，添加到Map中
                cache.put(id, beanConfig);

                // 输出成功提示
                System.out.println("数据初始化成功："+cache);
                System.out.println();
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }


    // 反射实例化对象  通过指定 bean id 获得具体实例对象
    public static Object getBean(String beanId){
        // 1.通过beanId从map中获取对应的BeanConfigCase1
        BeanConfigCase1 beanConfig = cache.get(beanId);
        // 没有对应id的BeanConfigCase1时，抛出一个异常
        if (beanConfig == null){
            throw new RuntimeException("获得对象["+beanId+"]不存在");
        }

        try {
            // 2.通过BeanConfigCase1中的className属性创建实例对象
            String className = beanConfig.getClassName();
            Class clazz = Class.forName(className);
            // 获得无参构造方法
            Constructor con = clazz.getConstructor();
            // 创建实例对象
            Object obj = con.newInstance();

            // 3.循环遍历BeanConfigCase1中的props，使用BeanUtils进行数据封装
            // 取出props
            Properties props = beanConfig.getProps();
            // 得到properties中的name集合 names
            Set<String> names = props.stringPropertyNames();
            // 遍历name，取出value
            for (String name : names){
                String value = props.getProperty(name);
                // 使用BeanUtils封装数据
                BeanUtils.setProperty(obj, name, value);
            }

            return obj;
        } catch (Exception e){
            // 只要这里抛出异常，就可以在try-catch内return
            throw new RuntimeException(e);
        }
    }
}
