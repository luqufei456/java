package com.yiran3.entity1.beanUtils;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

/**
 * BeanUtils的测试类-1
 *
 *    BeanUtils工具常用工具类有两个：BeanUtils、ConvertUtils。
 *    BeanUtils用于封装数据，ConvertUtils用于处理类型转换
 *
 *    常用方法：
 *    	setProperty(Object obj,String name,Object value)：
 *    		设置属性值，如果指定属性不存在，不抛异常
 *
 *    	getProperty(Object obj,String name)：
 *    		获得属性值，如果指定属性不存在，抛方法找不到异常
 *
 * 实际开发中，需要封装到JavaBean中的数据存放在配置文件
 * 	内容：uid=u001 、userName=jack
 *
 * JavaBean中两个概念：字段Field、属性Property
 * 	字段：就是成员变量。
 * 		例如：private String userName;
 * 		字段名称：userName
 *
 * 	属性：通过getter或setter方法推敲获得
 * 		获得方式：省略set或get前缀，首字母小写
 * 		例如：getUserName  -->UserName  -->userName
 *
 * 	注意：一般情况下，字段名称和属性名称一致的。
 *
 * 	特殊情况
 * 		private String description;		//字段名：description
 * 		public String getDesc(){		//属性名：desc
 * 			return description;
 * 		}
 * */

public class BeanUtilsDemo1 {

    // 模拟向User对象封装数据
    @Test
    public void test01(){
        BeanUtilsUser user = new BeanUtilsUser();
        user.setUid("u001");
        user.setUserName("yiran");
        user.setPassword("baka");
        System.out.println(user);
    }

    // 使用BeanUtils工具类封装User对象数据
    @Test
    public void test02(){
        try {
            // 1.BeanUtils工具类，提供setProperty给指定属性设置内容
            // 和getProperty获得指定属性的值
            BeanUtilsUser user = new BeanUtilsUser();
            System.out.println("封装前："+user);

            // 封装数据来自配置文件 , 底层其实还是user.setUid("u002")
            BeanUtils.setProperty(user, "uid", "u002");
            BeanUtils.setProperty(user, "userName", "chunjue");

            System.out.println("封装后："+user);

            // 2.获取属性值
            String userName = BeanUtils.getProperty(user, "userName");
            String uid = BeanUtils.getProperty(user, "uid");

            // 该方法可以传属性的索引，例如String[] strs  获取第一个就这样写
            // String hobbies1 = BeanUtils.getIndexedProperty(user,"hobbies[0]");

            System.out.println("userName："+userName+", uid："+uid);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
