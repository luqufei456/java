package com.yiran3.entity1.basicXML1.xmlCaseTest1;

import org.junit.Test;

/**
 * XML的解析测试类
 * */

public class XMLCaseTest1 {
    @Test
    public void testGetBean(){
        Object user = BeanFactoryCase1.getBean("userId01");
        System.out.println("userId01："+user);

        System.out.println();

        Object book = BeanFactoryCase1.getBean("bookId01");
        System.out.println("bookId01："+book);
    }
}
