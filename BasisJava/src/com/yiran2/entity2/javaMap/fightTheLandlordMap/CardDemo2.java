package com.yiran2.entity2.javaMap.fightTheLandlordMap;

import java.util.*;

/**
 * 按照斗地主的规则，完成洗牌发牌的动作
 *
 *  ♣♦♠♥ 大☺小☺
 * 具体规则：
 * 		使用54张牌打乱顺序
 * 		三个玩家参与游戏，三人交替摸牌，每人17张牌，最后三张留作底牌。
 *
 * 逻辑分析:
 *
 * 	每张牌由花色数字两部分组成，我们可以使用花色集合与数字集合嵌套迭代完成每张牌的组装。
 * 	使用一个Map集合,<<将小的数字与小的牌对应起来>>,做成Map集合的键与值
 * 	即:
 * 		键:数字
 * 		值:花色+数字的字符串(牌)
 *
 * 准备牌：
 * 	牌可以设计为一个ArrayList<Integer>,每个数字为一张牌。
 * 	牌由Collections类的shuffle方法进行随机排序。
 * 发牌：
 * 	将每个人以及底牌设计为ArrayList<Integer>,将最后3张牌直接存放于底牌，剩余牌通过对3取模依次发牌。
 * 看牌：
 * 	将所有集合排序Collections类的sort方法进行排序
 * 	将每个集合的数字依次找到对应的纸牌字符串打印出来
 * */

public class CardDemo2 {
    public static void main(String[] args){
        CardDemo2 admin = new CardDemo2();
        // 获得一套纸牌
        Map map = admin.getMap();
        // 输出纸牌
        System.out.println("--------------纸牌---------------");
        System.out.println(map);

        // 获得对应的键，并且打乱排序
        LinkedList poker = admin.theShuffle(map.size());
        // 输出其对应的键
        System.out.println("-------------纸牌的键--------------");
        System.out.println(poker);

        // 发牌
        LinkedList[] players = admin.deal(poker, map);
        LinkedList yiran = players[0];
        LinkedList chunjue = players[1];
        LinkedList miku = players[2];
        LinkedList dipai = players[3];

        // 看依然的牌
        System.out.println("------------依然的牌------------");
        admin.lookCard(yiran, map);
        // 看底牌
        System.out.println("--------------底牌-------------");
        admin.lookCard(dipai, map);
    }

    // 定义一套纸牌
    public Map getMap(){
        // 确定纸牌与数字的对应关系
        Map<Integer, String> map = new HashMap<Integer, String>();

        // 花色集合
        Collection<String> colors = new ArrayList<String>();
        Collections.addAll(colors, "♣", "♦", "♠", "♥");

        // 数字集合，加入数字时，直接使用for循环从小到大加入即可
        Collection<String> numbers = new ArrayList<String>();
        for (int i = 3;i <= 10;i++){
            // 将int转为String
            numbers.add(String.valueOf(i));
        }
        Collections.addAll(numbers, "J", "Q", "K", "A", "2");

        // 设置数字，用于记录数字与字符串纸牌的对应关系...
        int cardNumber = 0;
        // 遍历集合，匹配花色
        for (String thisNumber : numbers){
            for (String thisColor : colors){
                String thisCard = thisColor+thisNumber;
                map.put(cardNumber, thisCard);
                // 每添加一个纸牌，数字就+1 因为map键是唯一的
                cardNumber++;
            }
        }

        // 加入大小王, 因为是先put再++，所以大小王只需要一个++，另一个不用++
        map.put(cardNumber++, "小☺");
        map.put(cardNumber, "大☺");
        return map;
    }

    // 打乱排序，将对应键存为List集合,为什么用linked，因为增删比较方便
    public LinkedList theShuffle(int num){
        // 将map的键存放入List中，用于在map中取值
        LinkedList<Integer> poker = new LinkedList<Integer>();
        for (int i = 0;i < num;i++){
            poker.add(i);
        }
        // 打乱顺序
        Collections.shuffle(poker);
        return poker;
    }

    // 发牌
    public LinkedList[] deal(LinkedList poker, Map map){
        // 定义三名玩家,与底牌
        LinkedList<Integer> player1 = new LinkedList<Integer>();
        LinkedList<Integer> player2 = new LinkedList<Integer>();
        LinkedList<Integer> player3 = new LinkedList<Integer>();
        LinkedList<Integer> dipai = new LinkedList<Integer>();

        // 这里的i只用来计算到哪里了，可以当做索引，但是不用
        // 这里相当于将洗好的牌，分别发到三名玩家手上，洗好的牌集合发完后就为空了
        int cardSum = poker.size();
        System.out.println("poker.size:"+poker.size());

        // 这里不能直接用poker.size() 因为循环中，一直在弹出元素，这个值会变化
        // 所以需要先定义一个sum接收初值
        for (int i = 0;i < cardSum-3;i++){
            // 对3去余，分发给三名玩家 因为参数没定义类型，默认为Object，这里强转
            Integer integerCard = (Integer) poker.pop();
            if (i%3 == 0){
                player1.push(integerCard);
            }
            else if (i%3 == 1){
                player2.push(integerCard);
            }
            else{
                player3.push(integerCard);
            }
        }
        // 将三张底牌放进底牌List
        for (Object thisCard : poker){
            dipai.push((Integer)thisCard);
        }

        // 将玩家的牌排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);

        // 定义LinkedList数组，返回
        LinkedList[] linkedLists = {player1, player2, player3, dipai};
        return linkedLists;
    }

    public void lookCard(LinkedList player, Map map){
        for (int i = 0;i < player.size();i++){
            Integer integer = (Integer) player.get(i);
            String thisCard = (String) map.get(integer);
            if (i == player.size()-1){
                System.out.println(thisCard);
            }
            else{
                System.out.print(thisCard+"  ");
            }
        }
    }
}
