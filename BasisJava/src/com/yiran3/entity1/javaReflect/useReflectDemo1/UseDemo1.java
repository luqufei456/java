package com.yiran3.entity1.javaReflect.useReflectDemo1;

import java.io.FileReader;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 我们利用反射和配置文件，可以使：应用程序更新时，对源码无需进行任何修改
 * 我们只需要将新类发送给客户端，并修改配置文件即可
 *
 * 需求：
 *      当我们升级这个系统时，不要Student类，而需要新写一个Student2的类时，
 *      这时只需要更改pro.txt的文件内容就可以了。代码就一点不用改动
 * */

public class UseDemo1 {
    public static void main(String[] args){
        try {
            //通过反射获取Class对象
            Class stuClass = Class.forName(getValue("className"));//"cn.fanshe.Student"
            //2获取show()方法
            Method m = stuClass.getMethod(getValue("methodName"));//show
            //3.调用show()方法
            m.invoke(stuClass.getConstructor().newInstance());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 用于获取配置文件信息的方法
    public static String getValue(String key) throws Exception{
        Properties pro = new Properties();//获取配置文件的对象
        FileReader in = new FileReader("pro.txt");//获取输入流
        pro.load(in);//将流加载到配置文件对象中
        in.close();
        return pro.getProperty(key);//返回根据key获取的value值
    }

    /**
     * pro.txt
     *     className = cn.fanshe.Student
     *     methodName = show
     * */
}
