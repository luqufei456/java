package com.yiran2.entity1.fightTheLandlord;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 按照斗地主的规则，完成洗牌发牌的动作
 *
 *  ♣♦♠♥大☺小☺
 *  具体规则：
 *  		使用54张牌打乱顺序
 *  		三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。
 *
 *  逻辑分析:
 *
 *  	准备牌：
 *  		牌可以设计为一个ArrayList<String>,每个字符串为一张牌。
 *  		每张牌由花色数字两部分组成，我们可以使用花色集合与数字集合嵌套迭代完成每张牌的组装。
 *  		牌由Collections类的shuffle方法进行随机排序。
 *  	发牌：
 *  		将每个人以及底牌设计为ArrayList<String>,将最后3张牌直接存放于底牌，剩余牌通过对3取模依次发牌。
 *  	看牌：
 *  		直接打印每个集合
 * */

public class CardDemo {
    public static void main(String[] args){
        // 准备牌
        // 定义集合记录一副牌
        ArrayList<String> poker = new ArrayList<String>();

        // 定义花色集合
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("♥");
        colors.add("♠");
        colors.add("♦");
        colors.add("♣");

        // 定义数字集合
        ArrayList<String> numbers = new ArrayList<String>();
        for (int i = 2;i < 11;i++){
            numbers.add(String.valueOf(i)); // 将int转为String类型
        }
        numbers.add("J");
        numbers.add("Q");
        numbers.add("K");
        numbers.add("A");

        // 嵌套迭代完每副牌的组装
        for (String number : numbers){
            for (String color : colors){
                // 通过花色与数字拼接成一副牌
                String thisCard = color+number;
                poker.add(thisCard);
            }
        }

        // 添加大小王
        poker.add("大☺");
        poker.add("小☺");
        //System.out.println(poker);

        //洗牌  Collections类.shuffle方法可以将集合打乱顺序
        Collections.shuffle(poker);
        //System.out.println(poker);

        // 发牌
        //将每个人以及底牌设计为ArrayList<String>,将最后3张牌直接存放于底牌，剩余牌通过对3取模依次发牌。
        ArrayList<String> yiran = new ArrayList<String>();
        ArrayList<String> chunjue = new ArrayList<String>();
        ArrayList<String> miku = new ArrayList<String>();
        ArrayList<String> dipai = new ArrayList<String>();

        for (int i = 0;i < poker.size()-3;i++){
            // 获得当前的牌
            String thisCard = poker.get(i);

            // 以3取模，分别向三人发牌
            System.out.println(i%3);
            if (i%3 == 0){
                yiran.add(thisCard);
            }
            else if (i%3 == 1){
                chunjue.add(thisCard);
            }
            else{
                miku.add(thisCard);
            }
        }

        // 将最后三张底牌放到底牌集合中
        for (int i = poker.size()-3;i < poker.size();i++){
            dipai.add(poker.get(i));
        }

        // 看牌
        System.out.println("yiran:"+yiran);
        System.out.println("chunjue:"+chunjue);
        System.out.println("miku:"+miku);
        System.out.println("底牌："+dipai);

    }
}
