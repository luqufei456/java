package com.yiran2.entity1.regexDemo;

/**
 * 正则表达式的基本使用
 *
 * * 正则表达式:regex
 * 		匹配字符串的规则
 *
 * 正则表达式本身也是一个字符串
 *
 * 在使用正则表达式匹配字符串时,一共会至少出现两个字符串:代表规则的字符串,被规则匹配的字符串
 *
 * 正则表达式规则复杂,在日常的开发过程中,一般使用其他资源已经提供好的正则
 * 正则表达式使用相对广泛,并不属于某个具体的语言,而是各种语言都有对应的API操作正则
 *
 * 这里使用字符串中相关正则的方法
 * 	public boolean matches(String regex)
 * 		被匹配的字符串调用方法,接收正则表达式字符串,如果匹配返回true,否则返回false
 * 	public String[] split(String regex)
 * 		被匹配的字符串调用方法,将字符串中的字符与规则匹配,如果符合就匹配为分隔符,
 * 	将一个完整的字符串通过这些分隔符切割为不同的子字符串
 *
 * 	    这里只是简单介绍一下 matches和split方法，具体自行查阅文档
 * */

public class RegexDemo1 {
    public static void main(String[] args){
        // 验证电话号码
        // 准备被匹配的字符串
        String phoneNumber = "17671266824";

        // 准备规则字符串
        // 表示 第一个数字是1 第二个数字是 34578中的一个 后面一共有9个数 从0-9取值
        String regex = "1[34578][0-9]{9}";

        // 正则匹配 返回结果
        boolean matches = phoneNumber.matches(regex);
        System.out.println(phoneNumber+"是否为电话号码："+matches);

        // 准备被匹配切割的字符串
        String s = "yiran  junnan gel   paojie+poi";
        // 准备规则字符串
        // String sRegex = "[,]"; // 匹配逗号
        // String sRegex = "[ ,]"; // 匹配空格和逗号
        String sRegex = " +"; // 匹配一个或多个空格 这里不能用中括号 不然就是匹配单个空格或+了

        // 匹配切割字符串
        String[] sArr = s.split(sRegex);
        // 查看结果
        for (int i = 0;i < sArr.length;i++){
            System.out.println(sArr[i]);
        }
    }
}
