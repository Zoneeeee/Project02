package com.Singleton.java;

/**
 * @author sunjiacheng
 * @create 2019-10-15-10:16
 */

/**
 * 单例设计模式：使得一个类只能创建一个实例对象
 */

public class TestSingleton
{
    public static void main(String[] args)
    {
        Singleton1 s1 = Singleton1.getInstance();
        Singleton1 s2 = Singleton1.getInstance();
        System.out.println(s1 == s2);

        Singleton2 s3 = Singleton2.getInstance();
        Singleton2 s4 = Singleton2.getInstance();
        System.out.println(s3 == s4);

    }
}

//饿汉单例设计模式
class Singleton1
{
    //私有化构造器，使得在类的外部不能够调用此构造器
    private Singleton1() { }
    //在类的内部创建一个类的实例，并私有化该对象，通过公共的方法来获取
    private static Singleton1 instance = new Singleton1();
    //获取类对象的方法，此方法只能通过类来调用，因此设置为static
    public static Singleton1 getInstance() {
        return instance;
    }
}

//懒汉单例设计模式：可能存在线程安全问题
class Singleton2
{
    //私有化构造器，使得在类的外部不能够调用此构造器
    private Singleton2() { }
    //在类的内部创建一个类的实例，并私有化该对象，通过公共的方法来获取
    private static Singleton2 instance = null;
    //获取类对象的方法，此方法只能通过类来调用，因此设置为static
    public static Singleton2 getInstance() {
        if(instance == null)
            instance = new Singleton2();
        return instance;
    }
}
