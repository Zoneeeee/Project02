package com.helloworld.java;

/**
 * @author sunjiacheng
 * @create 2019-09-29-11:58
 */
public class OOPTest
{
    public static void main(String[] args)
    {
        int i = 10;
        //类的实例化：如下的a1就是一个实实在在的对象
        Animal a1 = new Animal();
        //通过对象调用属性
        a1.name = "团团";
        a1.age = 3;
        System.out.println("name:" + a1.name + "   " + "age:" + a1.age);
        //通过对象调用方法
        a1.eat();
        a1.sleep();
    }
}

class Animal
{
    String name;
    int age;

    public void eat()
    {
        System.out.println("动物进食");
    }
    public void sleep()
    {
        System.out.println("动物休眠");
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
