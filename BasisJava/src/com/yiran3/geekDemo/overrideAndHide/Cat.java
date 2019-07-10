package com.yiran3.geekDemo.overrideAndHide;

public class Cat extends Animal {

    @Override
    public void run() {
        System.out.println("cat run");
    }

    public static void hideEat() {
        System.out.println("Cat eat");
    }

    /**
     * 隐藏：就是说父类的静态方法和子类的静态方法是同时存在的，具体调用的是哪个方法，
     * 是要看调用的方法的引用是什么类型的引用，如果是父类型的引用，调用的就是父类的静态方法，
     * 如果是子类型的引用，调用的就是子类的静态方法。
     *
     * 重写：重写时，具体调用哪个方法，要看调用的方法的引用指向的实际类型，而不是仅看引用
     * 父类的方法可以通过 super.父类方法 来调用
     */
    public static void main(String[] args) {
        Cat cat = new Cat();
        Animal animal = cat;

        cat.run(); // cat run
        animal.run(); // cat run

        cat.hideEat(); // Cat eat
        animal.hideEat(); // Animal eat
        Animal.hideEat(); // Animal eat
    }
}
