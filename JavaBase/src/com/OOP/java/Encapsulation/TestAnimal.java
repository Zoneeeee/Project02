package com.OOP.java.Encapsulation;

/**
 * @author sunjiacheng
 * @create 2019-10-09-10:03
 */

/**
 * 面向对象的特性一：封装与隐藏
 * 1、当创建了类的对象后，如果直接通过"对象.属性"的方式对相应的对象属性赋值的话，可能会出现不满足实际情况的意外
 *    我们考虑不让对象来直接作用属性，而是通过"对象.方法"的形式，来控制对象对属性的访问
 *    根据实际情况中对属性的具体要求，可以写在方法中
 *
 * 2、解决方法：封装性的思想
 *    （1）将类的属性私有化
 *    （2）提供公共的方法（getter && setter）来实现调用
 *
 * 3、权限修饰符
 *    （1）public：   可用范围：类内部、同一个包、子类、任何地方
 *    （2）private：  可用范围：类内部
 *    （3）protected：可用范围：类内部、同一个包、子类
 *    （4）缺省：     可用范围：类内部、同一个包
 *
 * 4、对于类来说：权限修饰符只能是 public 或 缺省
 *    （1）public： 可在任何地方被访问
 *    （2）缺省：   只能被同一个包内的类访问
 */

public class TestAnimal
{
    public static void main(String[] args)
    {
        Animal a1 = new Animal();
        //a1.name = "花花";
        //a1.legs = 4;

        a1.setName("天天");
        a1.setLegs(4);
    }
}

class Animal
{
    //将属性私有化之后，就不能通过对象.属性的方式对属性进行访问，相当于隐藏
    private String name;
    private int legs;

    public void eat()
    {
        System.out.println("进食");
    }
    public void sleep()
    {
        System.out.println("睡觉");
    }
    public void info()
    {
        System.out.println("name:" + name + "  " + "legs:" + legs);
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getLegs()
    {
        return legs;
    }

    public void setLegs(int legs)
    {
        if(legs > 0 && legs % 2 == 0)
        {
            this.legs = legs;
        }
        else
        {
            System.out.println("数据有误！");
        }
    }
}