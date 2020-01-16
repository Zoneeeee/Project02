package com.TemplateMethod.java;

/**
 * @author sunjiacheng
 * @create 2019-10-16-11:36
 */

/**
 * 模板方法设计模式
 * 抽象类体现的就是一种模板模式的设计，抽象类作为多个子类的通用模板，子类在抽象类的基础上进行扩展改造，但子类总体上会保留抽象类的行为方式
 * 1、解决问题
 *  （1）当功能内部一部分实现是确定的，一部分实现是不确定的，这时可以将不确定的部分暴露出来，留给子类去实现
 *  （2）编写一个抽象父类，父类提供了多个子类的通用方法、并把一个或多个方法留给子类实现
 *
 */

public class TestTemplateMethod
{
    public static void main(String[] args)
    {
        Template t = new SubTemplate();
        t.spendTime();
    }
}

//模板作用：计算程序执行时间
abstract class Template
{
    abstract public void code(); //不确定的部分

    public void spendTime()
    {
        long start = System.currentTimeMillis();

        this.code();

        long end = System.currentTimeMillis();
        System.out.println("code run time: " + (end - start));
    }
}

class SubTemplate extends Template
{
    @Override
    public void code()
    {
        boolean flag = false;
        for(int i = 2; i <= 100000; i++)
        {
            for(int j = 2; j <= Math.sqrt(i); j++)
            {
                if(i % j == 0)
                {
                    flag = true;
                    break;
                }
            }
            if(false == flag)
                System.out.println(i);
            flag = false;
        }
    }
}
