package com.yiran.entity.javaInheritance.superclass;

/**
 * 子类没有继承父类的私有成员。然而，如果超类有公共或受保护的方法来访问其私有字段，那么子类也可以使用这些方法
 *
 * 可以做什么：
 *      继承的字段可以直接使用，就像任何其他字段一样。
 *      您可以在子类中声明一个字段，其名称与超类中的一个字段相同，因此隐藏它（不推荐）。
 *      您可以在不属于超类的子类中声明新的字段。
 *      继承的方法可以直接使用。
 *      你可以在子类中写一个新的实例方法，它的签名与超类中的那个一样，因此覆盖它。
 *      你可以在子类中编写一个新的静态方法，它的签名与超类中的那个一样，因此隐藏了它。
 *      您可以在子类中声明新的方法，而不是在超类中。
 *      你可以写一个子类的构造函数，它调用超类的构造函数，或者隐式地或者使用关键字super。
 * */

public class Student extends PersonClass {
    private String play; // 定义新的字段

    String thisname = super.name; // 通过super访问父类的属性，不能在静态context中使用
    // 也可以用super访问父类的方法

    public static void main(String[] args){
        // 构造方法，可以看到 父类的有参构造方法无法使用 只能使用无参构造
        // Student yiran = new Student("yiran",true,21,0);
        Student yiran = new Student("yiran",true,21,0.5);
        yiran.setName("yiran");

        // public 公开访问类型
        String name = yiran.name;

        // 默认访问权限
        boolean gender = yiran.gender;

        // protected 保护访问类型
        int age = yiran.age;

        // private 私有访问类型
        // double salary = yiran.salary;

        yiran.show();

        // 调用父类静态方法 后面覆盖了父类的静态方法，所以这里是子类的
        ena();

        // 无法调用父类 private方法
        // yiran.haha();

        yiran.playgame("DNF");

    }

    // 重写方法 重写  不是重载
    public void showtime(){
        System.out.println("现在是属于"+name+"的时间，才怪呢");
    }

    // 重写父类静态方法
    public static void ena(){
        System.out.println("这是专属于yiran的静态方法");
    }

    // 声明新的方法
    public void playgame(String game){
        this.play = game;
        System.out.println(name+"最喜欢玩的游戏是"+play);
        // 访问父类的方法
        super.showtime();
        // 访问自己重写的方法
        showtime();
    }

    // 当父类没有无参构造方法时，这里会报错
    public Student(){}

    // 显式调用父类构造方法，对父类进行初始化。
    // 注意: 子类调用父类的构造方法时，super语句必须是子类构造方法的第一句
    public Student(String name, boolean gender, int age, double salary){
        super(name,gender,age,salary);
        // 下面这些都不需要写，直接使用父类的构造方法赋值好了
        // this.name = name;
        // this.gender = gender;
        // this.age = age;
    }

}
