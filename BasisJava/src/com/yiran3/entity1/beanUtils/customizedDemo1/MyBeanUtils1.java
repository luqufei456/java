package com.yiran3.entity1.beanUtils.customizedDemo1;

import org.apache.commons.beanutils.BeanUtils;

import java.util.Map;

/**
 * 自定义的JavaBean工具类
 * */

public class MyBeanUtils1 {
    public static void populate(Object bean, Map<String, String[]> properties){
        try {
            BeanUtils.populate(bean, properties);
        } catch (Exception e){
            // 将编译时异常，转换成运行时，方便调用者(使用者不需要再次处理异常)
            // 运行时异常，在项目运行之后出错则直接中止运行，异常由JVM虚拟机处理
            throw new RuntimeException(e);
        }
    }
}
