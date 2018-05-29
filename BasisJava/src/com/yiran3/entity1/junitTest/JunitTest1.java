package com.yiran3.entity1.junitTest;

/**
 * 要求
 * 1、导入JUnit jar包
 * 2、import org.junit.Test;
 * 3、方法上面加注解@Test
 * 4、方法不能有形参
 *
 *    编写测试类，简单理解Junit可以用于取代java的main方法
 *    在测试类方法上添加注解 @Test
 *    @Test修饰的方法要求：public void 方法名() {…} ，方法名自定义建议test开头，没有参数。
 *    使用：选中方法右键，执行当前方法；选中类名右键，执行类中所有方法（方法必须标记@Test）
 *
 *    常用注解
 *      @Test，用于修饰需要执行的方法
 *      @Before，测试方法前执行的方法
 *      @After，测试方法后执行的方法
 *
 *    常见使用错误，如果没有添加“@Test”，使用“Junit Test”进行运行，将抛异常
 */

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class JunitTest1 {

    // 用于修饰需要执行的方法 在哪个Test方法上右击就运行哪个，
    // 在上面右击运行，则全部运行，可以发现每运行一次Test方法
    // Before 和 After都会运行一次
    @Test
    public void test01(){
        System.out.println("运行test01");
    }

    @Test
    public void test02(){
        System.out.println("运行test02");
    }

    // 测试方法前执行的方法
    @Before
    public void before(){
        System.out.println("Junit运行之前做的准备工作。比如打开资源等");
    }

    // 测试方法后执行的方法
    @After
    public void after(){
        System.out.println("Junit运行之后做的善后工作。比如关闭资源等");
    }

    @Test
    public void test03(){
        System.out.println("运行test03");
    }
}
