package com.wrapperClass.java;

import java.util.Scanner;
import java.util.Vector;

/**
 * @author sunjiacheng
 * @create 2019-10-14-10:00
 */
public class TestScore
{
    public static void main(String[] args)
    {
        //1、创建Scanner对象，提示从键盘输入学生的成绩（负数代表结束）
        System.out.println("请输入学生成绩：（以负数代表输入结束）");
        Scanner s = new Scanner(System.in);
        Vector v = new Vector();
        int maxScore = 0; //最高分
        for(;;)
        {
            int score = s.nextInt();
            if(score < 0)
                break;
            //3、求出所有正的成绩中的最高分
            if(maxScore < score)
            {
                maxScore = score;
            }
            //2、获取学生成绩后，填入Vector中
            Integer score1 = new Integer(score);
            v.addElement(score1);
        }
        //4、通过v.elementAt(i),一次获取填入v中的元素，同时判断一下各个分数的等级并输出
        for(int i = 0; i < v.size(); i++)
        {
            Integer score = (Integer) v.elementAt(i);
            char level;
            if(maxScore - score <= 10)
                level = 'A';
            else if(maxScore - score <= 20)
                level = 'B';
            else if(maxScore - score <= 30)
                level = 'C';
            else
                level = 'D';
            System.out.println("学生成绩为：" + score + ",等级为：" + level);
        }
    }
}
