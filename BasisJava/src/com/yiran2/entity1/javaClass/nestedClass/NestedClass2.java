package com.yiran2.entity1.javaClass.nestedClass;

/**
 * 局部内部类
 * */

public class NestedClass2 {
    private String name = "yiran";

    // 外部类的方法
    public void outerMethod(){
        // 局部内部类
        class InnerClass{
            public void innerMethod(){
                System.out.println("内部类的方法被调用了");
                System.out.println("外部类的成员变量name的值为："+name);
            }
        }

        // 定义好后可以直接在方法内使用
        InnerClass inner = new InnerClass();
        inner.innerMethod();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
