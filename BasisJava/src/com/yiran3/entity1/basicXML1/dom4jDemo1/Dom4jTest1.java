package com.yiran3.entity1.basicXML1.dom4jDemo1;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.List;

/**
 *   使用Dom4j工具包解析xml文件
 *
 *   解析步骤：
 *    	1.核心类；
 *    	2.获得Document（整个xml）；
 *    	3.获得根元素 beans；
 *    	4.所有子元素 bean；
 *    		4.1 bean属性
 *
 *  常用API如下：
 *     1.SaxReader对象
 *        a)read(…) 加载执行xml文档
 *     2.Document对象
 *        a)getRootElement() 获得根元素
 *     3.Element对象
 *        a)elements(…) 获得指定名称的所有子元素。可以不指定名称
 *        b)element(…) 获得指定名称第一个子元素。(可以不指定名称,目前看不行
 *        c)getName() 获得当前元素的元素名
 *        d)attributeValue(…) 获得指定属性名的属性值
 *        e)elementText(…) 获得指定名称子元素的文本值
 *        f)getText() 获得当前元素的文本内容
 * */

public class Dom4jTest1 {
    public static void main(String[] args){
        try {
            // 1.核心类
            SAXReader saxReader = new SAXReader();

            // 2.获取Document对象
            String xmlPath = "src\\com\\yiran3\\entity1\\basicXML1\\dom4jDemo1\\bean-dom4jTest1.xml";
            Document document = saxReader.read(xmlPath);

            // 3.获取根元素beans
            Element rootElement = document.getRootElement();
            System.out.println("beans："+rootElement);

            // 4.获取所有子元素bean 也可以不指定元素，获取所有的子元素
            List<Element> allBeanElement = rootElement.elements("bean");
            for (Element beanEle : allBeanElement){
                // 4.1 bean属性
                String id = beanEle.attributeValue("id");
                String className = beanEle.attributeValue("className");
                System.out.println("bean属性："+id+", "+className);

                // 5.子元素property
                List<Element> allPropElement = beanEle.elements("property");
                for (Element propEle : allPropElement){
                    String name = propEle.attributeValue("name");
                    String value = propEle.attributeValue("value");
                    System.out.println("property属性："+name+", "+value);
                }
                System.out.println("-------------------------");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
