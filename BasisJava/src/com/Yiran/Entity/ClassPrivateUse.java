package com.Yiran.Entity;

public class ClassPrivateUse {
    public static void main(String[] args){
        // 创建对象
        ClassPrivateDefine stu = new ClassPrivateDefine();
        stu.show();

        stu.name = "yiran";
        // stu.age = 21; 因为 age设置了 private 所以不能直接使用
        // 这里可以看到 当继承现有类型时，也就创造了新的类型。
        // 这个新的类型不仅包括现有类型的所有成员(尽管private成员被隐藏了起来，并且不可访问)，
        // 虽然无法在子类中对父类的private成员直接操作，但的确是继承了。

        /*
        * private最常见的应用：
        *   把成员变量用private修饰
        *   提供对应的getXxx()/setXxx()方法
        * */

        stu.setAge(21);
        stu.show();

    }

}
