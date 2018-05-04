package com.yiran.entity;

import java.util.regex.Pattern;

public class PhoneClassDefine {
    /**
     * 手机类：
     *     成员变量：品牌、价格
     *     成员方法：打电话、发短信
     * */
    String brand; // 品牌
    int price; // 价格

    public void call(String number){
        System.out.println(brand+"正在拨打电话……这可是价值"+price+"元的手机，请务必珍惜");
        if (isPhone(number)){
            System.out.println("对不起，您拨打的电话暂时无人接听");
        }
        else{
            System.out.println("对不起，您拨打的电话是空号");
        }
    }

    public void sendMessage(String number){
        System.out.println(brand+"正在发送消息……这可是价值"+price+"元的手机，请务必珍惜");
        if (isPhone(number)){
            System.out.println("您的余额不足，请充值");
        }
        else{
            System.out.println("对不起，您发送的手机号为空号");
        }
    }

    public static boolean isPhone(String number) {
        String phone = "^[1][3,4,5,7,8][0-9]{9}$";
        return Pattern.matches(phone,number);
    }
}
