package com.FactoryMethod.java;

/**
 * @author sunjiacheng
 * @create 2019-10-16-15:32
 */

/**
 * 工厂方法设计模式：定义一个用于创建方法的接口，让子类决定实例化哪一个类
 * 1、工厂方法模式将一个类的实例化延迟到其子类
 * 2、
 *
 */

public class TestFactoryMethod
{
    public static void main(String[] args)
    {
        IWorkFactory i1 = new StudentWorkFactory();
        i1.getWork().doWork();

        IWorkFactory i2 = new TeatherWorkFactory();
        i2.getWork().doWork();

    }
}

interface IWorkFactory{
    Work getWork();
}

//由实现类决定创建什么对象
class StudentWorkFactory implements IWorkFactory{
    @Override
    public Work getWork() {
        return new StudentWork();
    }
}

//由实现类决定创建什么对象
class TeatherWorkFactory implements IWorkFactory{
    @Override
    public Work getWork() {
        return new TeatherWork();
    }
}


interface Work{
    void doWork();
}

class StudentWork implements Work{
    @Override
    public void doWork() {
        System.out.println("学生写作业！");
    }
}

class TeatherWork implements Work{
    @Override
    public void doWork() {
        System.out.println("老师批改作业！");
    }
}

