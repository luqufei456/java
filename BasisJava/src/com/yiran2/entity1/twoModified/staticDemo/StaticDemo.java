package com.yiran2.entity1.twoModified.staticDemo;

/**
 * static,静态特征测试类
 *
 *  static是静态修饰符，一般修饰成员。
 *  被static修饰的成员属于类，不属于单个这个类的某个对象。
 *
 *  static修饰的成员被多个对象共享。
 *  static修饰的成员属于类，但是会影响每一个对象。
 *  被static修饰的成员又叫类成员，不叫对象的成员。
 *
 *  所有中国人国籍均应该为中国，不应各自定义各自的国籍，所以可以将国籍定义为static，属于类，被多个对象共享。
 *  国籍,姓名,年龄,职业
 *  其中,国籍应该被共享
 *  姓名,年龄,职业各个对象有各个对象的值
 *
 *  一般static修饰的成员,直接赋值
 *
 *  当多个对象共享使用同一个类中静态成员时,只要该值改变,就会影响所有的对象
 * */

public class StaticDemo {
    public static void main(String[] args){
        // 创建多个中国人对象，验证static被多个对象共享
        Chinese yiran = new Chinese("依然",21,"学生");
        Chinese junnan = new Chinese("君男",22,"财务");
        Chinese gel = new Chinese("鸽l",24,"网络推广");
        Chinese zhiwen = new Chinese("炮姐",22,"编辑");

        System.out.println(yiran.getName()+"今年"+yiran.getAge()+"，工作为"+yiran.getWork()+"，是"+yiran.country+"人");
        System.out.println(junnan.getName()+"今年"+junnan.getAge()+"，工作为"+junnan.getWork()+"，是"+junnan.country+"人");
        System.out.println(gel.getName()+"今年"+gel.getAge()+"，工作为"+gel.getWork()+"，是"+gel.country+"人");
        System.out.println(zhiwen.getName()+"今年"+zhiwen.getAge()+"，工作为"+zhiwen.getWork()+"，是"+zhiwen.country+"人");
    }
}
