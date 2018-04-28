package com.Yiran.Entity;

public class StudentClassDefine {
    /**
     *  学生类：
     *      成员变量：姓名，年龄
     *    	成员方法：学习，吃饭
     *
     *  1:成员变量    和以前定义变量是一样的。
     *    	只不过位置发生了改变：在类中，方法外。
     *    	初始化值：不需要给初始化值。
     *  2:成员方法    和以前定义方法是一样的。
     *    	只不过把static去掉，面向对象进阶在详细讲解static的作用。
     *    如果有static 不需要实例化对象就可以使用 直接通过 类名.方法名进行调用
     * */
    String name;
    int age;
    boolean gender;

    public void study(){
        System.out.println(name+"正在开启学习模式");
        if (age > 25){
            System.out.println("开启状态99%");
            System.out.println("由于年龄太大，达到"+age+"岁，开启失败");
        }
        else{
            System.out.println("开启状态99%");
            System.out.println("今年才"+age+"岁，活力充沛，开启成功");
        }
    }

    public void shower(){ // 非静态的成员变量，不能被静态方法使用
        System.out.println(name+"正在思考今天要不要洗澡");
        if (gender){
            System.out.println("我的性别为"+gender+"，是女孩子，一定要洗澡");
        }
        else{
            System.out.println("我的性别为"+gender+"，大男人那么矫情干嘛，别洗了");
        }
    }

    public static void eat(){
        System.out.println("看什么看，是人都会吃饭的，和是谁没什么关系");
    }

}
