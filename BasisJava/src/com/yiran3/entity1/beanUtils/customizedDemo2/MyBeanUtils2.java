package com.yiran3.entity1.beanUtils.customizedDemo2;

import org.apache.commons.beanutils.BeanUtils;

import java.lang.reflect.Constructor;
import java.util.Map;

/**
 * 带泛型的自定义工具类
 *
 * 定义静态的一个工具类，定义方法populate，参数为Class<T>和Map<String,String[]>，返回值类型为Object
 * */

public class MyBeanUtils2 {

    public static <T> Object populate(Class<T> beanClass, Map<String,String[]> properties){
        try {
            // 1.利用反射实例化
            Constructor con = beanClass.getConstructor();
            Object bean = con.newInstance();

            // 2.填充数据
            BeanUtils.populate(bean, properties);

            // 3.将填充好的对象实例返回
            return bean;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
