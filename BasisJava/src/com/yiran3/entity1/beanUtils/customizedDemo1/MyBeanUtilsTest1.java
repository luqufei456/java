package com.yiran3.entity1.beanUtils.customizedDemo1;

import com.yiran3.entity1.beanUtils.BeanUtilsUser;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * 第一个工具包的测试类
 * */

public class MyBeanUtilsTest1 {
    @Test
    public void testDemo02() {
        //1.模拟数据，创建一个Map，填充需要的数据
        Map<String,String[]> map = new HashMap<>();
        map.put("uid", new String[]{"u001"});
        map.put("userName", new String[]{"yiran"});
        map.put("password", new String[]{"1234"});
        map.put("hobbies", new String[]{"写代码", "玩DNF"});

        // 2.使用MyBeanUtils1的populate方法填充
        BeanUtilsUser user = new BeanUtilsUser();
        MyBeanUtils1.populate(user, map);
        System.out.println(user);
    }
}
