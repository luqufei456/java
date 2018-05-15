package com.yiran2.entity1.javaException.disposal.ExceptionInheritance1;

import java.io.IOException;
import java.text.ParseException;
import java.util.zip.DataFormatException;

/**
 *  异常在继承中的注意事项
 *
 *  如果父类抛出了多个异常,子类覆盖父类方法时,只能抛出相同的异常或者是他的子集,只能少不能多
 *
 *	父类方法没有抛出异常，子类覆盖父类该方法时也不可抛出异常。此时子类产生该异常，只能捕获处理，不能声明抛出
 *
 *	现实开发过程中,一般子类重写的方法抛出的异常与父类方法抛出的异常是一样的,不存在不一样的情况.
 *
 * */

public class SuperClass {
    // 如果父类抛出了多个异常,子类覆盖父类方法时,只能抛出相同的异常或者是他的子集
    public void method() throws IOException,ParseException,DataFormatException{
        // 产生异常的方法体
    }

    public void method1(){
        // 不产生异常的方法体
    }

}
