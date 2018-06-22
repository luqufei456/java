package com.yiran3.javaSEexam;

/**
 * javaSE 练习考试
 * */

import org.junit.Test;

import java.util.Arrays;

public class ExamTest01 {
    @Test
    public void test01(){
        /**
        class A{
            public int getNumber(int a){
                return a+1;
            }
        }
        class B extends A {
            public int getNumber(int a, char c) {
                return a + 2;
            }

            public static void main(String[] args) {
                A a = new B();
                System.out.println(a.getNumber(0));
            }
        }
         答案为 1 ，参数不同，不能算重写，只能算重载，而且向上转型后，编译看左边，运行看右边。
         无法构成重写，2个参数的左边没有，只能使用继承的父类的方法，结果为1
        */
    }

    @Test
    public void test02(){
        /**
         public void test(){
             try{
                 fun();
                 System.out.print(“情况1”);
             }catch(ArrayIndexOutOfBoundsException e){
                 System.out.print(“情况2”);
             }catch(Exception e){
                 System.out.print(“情况3”);
             }finally{
                 System.out.print(“finally”);
             }
         }
         答案为情况2 finally  数组越界 报错情况2 然后finally必定执行
         * */
    }

    @Test
    public void test03(){
        /**
         public static void stringReplace(String text){
             text=text.replace('j','L');
         }

         public static void bufferReplace(StringBuffer text){
             text=text.append("c");
         }

         public static void main(String args[]){
             String textString=new String("java");
             StringBuffer textBuffer=new StringBuffer("java");
             stringReplace(textString);
             bufferReplace(textBuffer);
             System.out.println(textString+textBuffer);
         }

         答案为 javajavac  方法中的局部变量对外部无影响
         * */
    }

    @Test
    public void test04(){
        /**
         Object [] myObjects = {
             new Integer(12),
             new String("foo"),
             new Integer(5),
             new Boolean(true)
         };
         Arrays.sort(myObjects);
         for( int i=0; i<myObjects.length; i++) {
             System.out.print(myObjects[i].toString());
             System.out.print(" ");
         }

         不同类型无法排序  排序的地方报错，其他没问题
         * */
    }

    @Test
    public void test05(){
        /**
           public static void parse(String str) { 
               try { 
                   float f= Float.parseFloat(str); 
               } catch (NumberFormatException nfe) { 
                   f= 0;        
               } finally { 
                   System.out.println(f); 
               } 
           } 

           public static void main(String[] args) { 
               parse("invalid"); 
           } 

         f不是全局变量，在try中的局部变量，在catch中无法使用，会报错
         * */
    }

    @Test
    public void test06(){
        int[] x = {122, 33, 55, 678, -987};
        int a = x[0];
        for (int i = 1;i < x.length;i++){
            if (x[i] > a){
                a = x[i];
            }
        }
        System.out.println(a);
        // 典型的遍历求最大值
    }

    @Test
    public void test07(){
        /**
        class Person{
            public Person(){
                System.out.println("this is a Person");
            }
        }
        class Teacher extends Person{
            private String name="tom";
            public Teacher(){
                System.out.println("this is a teacher");
                super();
            }
            public static void main(String[] args){
                Teacher teacher = new Teacher();
                System.out.println(this.name);
            }
        }
         编译中出现2个错误，super()必须在第一行，主方法中找不到this
         */
    }

    @Test
    public void test08(){
        /**
        class Base {
            abstract public void myfunc();
            public void another() {
                System.out.println("Another method");
            }
        }

        public class Abs extends Base {
            public static void main(String[] args) {
                Abs a = new Abs();
                a.amethod();
            }

            public void myfunc() {
                System.out.println("My func");
            }

            public void amethod(){
                myfunc();
            }

         那么问题来了，一般类里怎么能放抽象方法呢
            */
    }

    @Test
    public void test09(){
        /**
        public class Test{
            static int i;

            public int test(){
                i++;
                return i;
            }

            public static void main(String args[]){
                Test test=new Test();
                test.test();
                System.out.println(test.test());
            }
        }
         int类型初始值为0，这里++两次 就为2
        */
    }

    @Test
    public void test10(){
        /**
        class MyClass{
            public void myMethod (final int p){
                final int il;
                final int i2=p;
                il = 20;
                i2=20;
            }
        }
         给了初始值的 常量无法再次赋值，所以 i2=20报错
        */
    }

    @Test
    public void test11(){
        /**
        class X {
            Y b = new Y();
            X() {
                System.out.print("X");
            }
        }

        class Y {
            Y(){
                System.out.print("Y");
            }
        }

        class Z extends X {
            Y y = new Y();
            Z() {
                // super(); 这里默认调用父类的构造方法
                System.out.print("Z");
            }

            public static void main(String[] args) {
                new Z();
            }
        }

         这里要知道子类会调用父类的构造方法 YXYZ
        */
    }

    @Test
    public void test12(){
        /**
        a = Integer.parseInt("12");
        b = Integer.valueOf("12").intValue();
        intValue()  parseInt()都是返回int类型
         */
    }

    @Test
    public void test13(){
        /**
         class Q {
         public static void main(String argv[]){
         int[] arr = new int[3];
         System.out.println(arr[0]);
         }
         }
         定义了有三个元素，但是没有对其中元素进行赋值，所以初始值为0
         */
    }

    @Test
    public void test14(){
        /**
        class AE {
            public int number = 10;
            public void showNum(){
                System.out.println(this.number);
            }

            public static void main(String[] args){
                AE al = new DE();
                al.showNum();
                System.out.println(al.number);

            }
        }

        class DE extends AE{
            public int number = 5;
            public void showNum(){
                System.out.println(this.number);
            }
        }
         向上转型后，成员变量看左边，运行也看左边 所以al.number=10
         成员方法看左边，运行看右边，所以 al.showNum=5
         答案为 5  10
         */
    }

    @Test
    public void test15(){
        /**
        interface A{void x();}
        class B implements A{public void x(){} public void y(){}}
        class C extends B{public void x(){}}
            java.util.List<A> list = new java.util.ArrayList<A>();
            list.add(new B());
            list.add(new C());
            for(A a : list){
                a.x();
                a.y();
            }
         向上转型，运行看左，A接口中没有定义y方法，a.y()会报错
         */
    }

    @Test
    public void test16(){
        String s1 = new String("hello");
        String s2 = new String("hello");
        System.out.println(s1==s2); // false
        System.out.println(s1.hashCode()==s2.hashCode()); // true
        /** String重写了hashcode()方法，hashcode由内容决定 */
    }

    @Test
    public void test17(){

    }
}