package com.yiran2.entity1.javaException.disposal.customException;

/**
 * 小于18岁异常
 *
 * 自定义异常时，父类为Exception 然后创建构造方法，构造方法中的参数即为捕获异常后返回的消息
 * */

public class U18Exception extends Exception {
    public U18Exception(String message){
        super(message);
    }
}
