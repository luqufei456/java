package com.yiran.entity.classParameter;

public class Teacher {

    public void test(Student stu){ // 类当做参数 其实就是要该类的对象
        stu.study();
    }

}
