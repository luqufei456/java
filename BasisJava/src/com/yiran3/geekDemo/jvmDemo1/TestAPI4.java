package com.yiran3.geekDemo.jvmDemo1;

/**
 * 对应 深入拆解Java虚拟机 04 开篇例子
 * 为的是了解JVM是如何执行方法调用的
 */
public class TestAPI4 {

    public void invoke(Object obj, Object... args) {
        System.out.println("Object obj, Object... args");
    }

    public void invoke(String s, Object obj, Object... args) {
        System.out.println("String s, Object obj, Object... args");
    }

    public static void main(String[] args) {
        TestAPI4 test = new TestAPI4();
        // 可以看到，只有指定第二个参数是可变长参数，才能调用第一个invoke方法
        // 这是因为，前两个调用，null符合Object 也符合 String，而String范围更小，所以选择了String
        test.invoke(null, 1);
        test.invoke(null, 1, 2);
        test.invoke(null, new Object[]{1});
    }
}
