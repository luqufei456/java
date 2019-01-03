package com.yiran4.exam;

public class HasStatic2 {
    private static int x = 100;
    public static void main(String[] args) {
        HasStatic2 hs1 = new HasStatic2();
        hs1.x++;
        HasStatic2 hs2 = new HasStatic2();
        hs2.x++;
        hs1 = new HasStatic2();
        hs1.x++;
        HasStatic2.x--;
        System.out.println("x="+x);
    }
}
