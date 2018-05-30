package com.yiran3.entity1.beanUtils.customizedDemo2;

import com.yiran3.entity1.beanUtils.BeanUtilsUser;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 第二个工具包的测试类
 * */

public class MyBeanUtilsTest2 {
    @Test
    public void test01(){
        // 1.模拟数据，创建一个map，填充需要的数据
        Map<String, String[]> map = new HashMap<>();
        map.put("uid", new String[]{"u001"});
        map.put("userName", new String[]{"yiran","chunjue"});
        map.put("password", new String[]{"12345"});

        // 2.使用MyBeanUtils2的populate方法进行填充
        Object obj = MyBeanUtils2.populate(BeanUtilsUser.class,map);
        System.out.println(obj);
    }
}
