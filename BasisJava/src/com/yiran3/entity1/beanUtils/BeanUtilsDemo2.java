package com.yiran3.entity1.beanUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * BeanUtils的测试类-2
 *
 *    BeanUtils类的populate(Object bean, Map<String,String[]> properties)：
 *    	将Map数据封装到指定Javabean中，一般用于将表单的所有数据封装到javabean。
 * */

public class BeanUtilsDemo2 {

    @Test
    public void test01(){
        try {
            // 1.模拟数据，创建一个map，填充需要的数据
            // 如果有的属性要求为数组时，可以像这样定义
            // 即使String 这样类型的属性，被String[]进行填充
            // 也只会使用String[] 中的第一个元素
            Map<String, String[]> map = new HashMap<>();
            map.put("uid", new String[]{"u001"});
            map.put("userName", new String[]{"yiran", "chunjue"});
            map.put("password", new String[]{"123456"});
            map.put("hobbies", new String[]{"敲代码","早上敲代码","晚上敲代码"});
            // 如果类型不相同，也会被自动转为其他基本数据类型
            map.put("age",new String[]{"1","2"});

            // 2.将使用populate进行填充
            BeanUtilsUser user = new BeanUtilsUser();
            BeanUtils.populate(user, map);
            System.out.println("封装后："+user);
        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
