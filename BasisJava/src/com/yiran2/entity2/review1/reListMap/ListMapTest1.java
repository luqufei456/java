package com.yiran2.entity2.review1.reListMap;

import com.yiran.entity2.objectArray.Student;

import java.util.*;

/**
 * 集合练习题
 *
 *   分析以下需求，并用代码实现：
 *    	(1)定义一个学生类Student，属性：姓名(String name)、班级班号(String class_number)、分数(double score)
 *    	(2)初始化数据将若干Student对象存入List集合
 *    	(3)以班级为单位,使用Map存储所有该班学生
 *    		map.put("班级1",班级1的学生);
 *    		map.put("班级2",班级2的学生);
 *    		......
 *    	(4)统计每个班级的总分和平均分
 *
 *    可选解法提示:
 *    		a.采用面向对象的思想(组合)
 *    		b.不推荐使用Map<String,List<Student>>
 *    		c.推荐使用Map<String，ClassRoom>
 *
 *=========================================================
 *	分析：
 *		1、定义Student类
 *		2、创建多个Student对象，放到集合中，数据一共有3个班级，班级1、班级2、班级3，作为初始数据
 *		3、定义班级类：
 *			班号
 *			该班所有的学生
 *
 *			将该班级所有学生以Map<String,ClassRoom>的方式，存储到Map集合中
 *			定义变量，记录Map集合，用于存储所有班级(这里简化需求，只有三个班级，班级1、班级2、班级3)
 *			定义三个ArrayList，记录三个班级对象的所有学生信息
 *			迭代所有学生初始化数据集合，依次获取到每一个同学
 *			判断每个学生是班级1、班级2还是班级3，将该学生放到对应的ArrayList集合中
 *			创建三个ClassRoom对象
 *			再将三个班级加入到对应的Map集合中
 *		4、
 *			遍历Map集合，分别拿到每个班级的班级对象
 *			获取班级对象中所有学生的列表
 *			定义变量，记录总分
 *			定义变量，记录平均分
 *			循环遍历列表，累加总分
 *			计算平均分
 *			打印数据
 * */

public class ListMapTest1 {
    public static void main(String[] args){
        // 初始化数据，创建几个学生
        ListStudent yiran = new ListStudent("依然", "01班",80.0);
        ListStudent taitai = new ListStudent("翔鹤太太", "01班",90.0);
        ListStudent chengge = new ListStudent("诚哥", "01班",70.0);
        ListStudent chunjue = new ListStudent("蠢觉", "02班",95.0);
        ListStudent baba = new ListStudent("粑粑", "02班",80.0);
        ListStudent gel = new ListStudent("鸽l", "03班",75.0);
        ListStudent zhenhong = new ListStudent("真红", "03班",85.0);
        ListStudent miku = new ListStudent("Miku", "03班",80.0);

        // 将学生对象存入集合
        ArrayList<ListStudent> students = new ArrayList<>();
        Collections.addAll(students, yiran, taitai, chengge, chunjue, baba, gel, zhenhong, miku);

        // 定义三个ArrayList，用于存储三个班各自的学生，然后能添加到班级对象中
        ArrayList<ListStudent> class01Students = new ArrayList<>();
        ArrayList<ListStudent> class02Students = new ArrayList<>();
        ArrayList<ListStudent> class03Students = new ArrayList<>();

        for (ListStudent thisStudent : students){
            if (thisStudent.getClassNumber().equals("01班")){
                class01Students.add(thisStudent);
            }
            else if (thisStudent.getClassNumber().equals("02班")){
                class02Students.add(thisStudent);
            }
            else {
                class03Students.add(thisStudent);
            }
        }

        // 创建三个班级对象
        ListClassRoom class01 = new ListClassRoom("01班", class01Students);
        ListClassRoom class02 = new ListClassRoom("02班", class02Students);
        ListClassRoom class03 = new ListClassRoom("03班", class03Students);

        // 将三个班级加到Map集合中
        // 将每个班级以Map<String, ClassRoom>存储到Map集合中
        // 班级中包含每个班级各自的学生
        HashMap<String, ListClassRoom> classRooms = new HashMap<>();
        classRooms.put("01班", class01);
        classRooms.put("02班", class02);
        classRooms.put("03班", class03);
        System.out.println(classRooms);

        // 遍历Map集合，分别拿到对应的ky键值对对象
        Set<Map.Entry<String, ListClassRoom>> entrySet = classRooms.entrySet();
        // 这里向上转型不需要强转
        for (Map.Entry thisEntry : entrySet){
            // 这里向下转型，就需要强转 Object-->ListClassRoom
            ListClassRoom thisClassRoom = (ListClassRoom) thisEntry.getValue();

            // 调用获取班级成绩方法
            getClassScore(thisClassRoom);
        }
    }

    public static void getClassScore(ListClassRoom classRoom){
        // 得到每个班级的学生集合
        ArrayList<ListStudent> students = classRoom.getStudents();

        // 遍历求平均分、总分
        // 先定义一个初始平均分、总分为0
        double avgScore;
        double sumScore = 0;

        for (ListStudent thisStudent : students){
            double score = thisStudent.getScore();
            sumScore += score;
        }

        // 学生总数为 students.size();
        avgScore = sumScore/students.size();

        // 输出结果
        System.out.println("班级"+classRoom.getClassNumber()+
                "的平均分为："+avgScore+",总分为："+sumScore);
    }
}
