package com.yiran.entity;

/**
 *    构造方法：
 *    		给对象的数据进行初始化
 *
 *    格式：
 *    		方法名与类名相同
 *    		没有返回值类型，连void都没有
 *    		没有具体的返回值
 *
 *    构造方法注意事项:
 *    		A:如果你不提供构造方法，系统会给出一个默认无参构造方法
 *    		B:如果你提供了构造方法，系统将不再提供默认无参构造方法
 *    			这个时候，如果想使用无参构造方法，就必须自己提供
 *    			推荐：自己给出无参构造方法
 *    		C:构造方法也是可以重载的
 *
 *    成员变量赋值：
 *    		A：setXxx()方法
 *    		B：带参数构造方法
 * */

public class ConstructorDefine {
    private String name;
    private int age;

    public ConstructorDefine(){
        System.out.println("这是构造方法");
    }

    public ConstructorDefine(String name){
        this.name = name;
    }

    public ConstructorDefine(int age){
        this.age = age;
    }

    public ConstructorDefine(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge(){
        return age;
    }

    public void show(){
        System.out.println(name+"------"+age);
    }

}
