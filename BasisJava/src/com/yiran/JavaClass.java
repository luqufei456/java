package com.yiran;

public class JavaClass {
    /**
     * 内部类和外部类 初试
     * */

    public static void main(String[] args){
        /**
         * 可以发现， String类型的成员变量 默认值为null 代表空
         * int类型成员变量 默认值为0
         * boolean类型成员变量 默认值为false
         * */
        // 如何使用外部类
        System.out.println("--------外部类--------");
        System.out.println("--------学生类--------");
        Student stu = new Student();
        stu.name = "yiran";
        stu.age = 21;
        stu.gender = false;
        stu.study();
        stu.rest();
        stu.introduce();

        // 如何使用内部类
        System.out.println("--------内部类--------");
        System.out.println("--------手机类--------");
        JavaClass test = new JavaClass(); // 外部类实例化对象
        JavaClass.Phone thePhone = test.new Phone(); // 实例化内部类对象
        thePhone.brand = "小米5";
        thePhone.price = 2000;
        thePhone.printBrand(); // 调用内部类方法
        thePhone.printPrice();

        // 内部类用static修饰后 可以直接在外部调用
        //Phone thisPhone = new Phone();
    }

    public class Phone{
        String brand;
        int price;

        public void printBrand(){
            System.out.println("手机品牌为"+brand);
        }

        public void printPrice(){
            System.out.println("手机价格为"+price);
        }
    }

}

// 外部类
// 每个.java中只可能存在一个公开类
class Student{ // 默认访问类型
    /**
     * 成员变量：
     成员变量分为类属性和实例属性两种，定义一个属性时不使用static修饰就是实例属性，使用static修饰就是类属性。
     类属性的作用域与对应类的生存范围相同。实例属性的作用域与对应实例的生存范围相同。
     只要类存在，程序就能访问该类的类属性（类.类属性）
     只要实例存在，程序就能访问该实例的实例属性（实例.实例属性）
     类属性也可以让该类的实例访问（实例.类属性），注意通过实例修改的类属性，与通过类来修改的类属性完全相同，
     即类属性的值修改后立即生效。
     * 局部变量：
     形参：作用域在整个方法内
     方法局部变量：作用域从定义该变量的地方到方法结束时
     代码块局部变量：作用域从定义该变量的地方到代码块结束时
     *
     * java允许局部变量和成员变量同名，如果方法里的局部变量和成员变量同名，局部变量会覆盖成员变量，
     * 如果需要在这个方法里引用被覆盖的成员变量，
     * 则可使用this（对于实例属性）或类名（对于类属性）作为调用者来限定访问成员变量。
     * */
    // 成员变量可以不进行初始化 虚拟机会确保它有一个默认值
    // 局部变量如果不进行初始化，不可使用，因为它没有默认值
    String name;
    int age;
    boolean gender;

    // 这里可以看到 虽然是一个.java文件 但是ide将其分为两块，每块当做一个部分 所以main方法不冲突 只能同时运行一个main
    public static void main(String[] args){
        System.out.println("这是一个学生类");
    }

    public void study(){
        System.out.println(name+"发动技能：学习，智力加成 -200");
    }

    public void rest(){
        System.out.println(name+"发动技能：睡觉，舒适度加成 +100");
    }

    public void introduce(){
        System.out.println(name+"发动技能：自我介绍，My name is "+name+",age is "+age+",gender is "+gender);
    }

}