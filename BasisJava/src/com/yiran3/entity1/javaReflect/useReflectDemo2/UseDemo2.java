package com.yiran3.entity1.javaReflect.useReflectDemo2;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * 反射方法的其它使用之---通过反射越过泛型检查
 *
 * 泛型用在编译期，编译过后泛型擦除（消失掉）。所以是可以通过反射越过泛型检查的
 *
 * 例如：有一个String泛型的集合，怎样能向这个集合中添加一个Integer类型的值？
 * */

public class UseDemo2 {
    public static void main(String[] args) throws Exception{
        ArrayList<String> strList = new ArrayList<>();
        strList.add("aaa");
        strList.add("bbb");

        // strList.add(100);
        // 获取ArrayList的Class对象，反向调用add()方法，添加数据
        // 得到 strList 的字节码 对象
        Class listClass = strList.getClass();
        // 获得add()方法 数据类型为Object，这样都可以添加
        Method m = listClass.getMethod("add", Object.class);
        // 调用获得的add()方法 这里第一个元素要用声明类的实例对象
        m.invoke(strList, 100);

        // 遍历集合
        for (Object obj : strList){
            System.out.println(obj);
        }
    }
}
