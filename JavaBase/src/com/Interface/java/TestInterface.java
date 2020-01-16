package com.Interface.java;

/**
 * @author sunjiacheng
 * @create 2019-10-16-14:05
 */

/**
 * 接口：接口中只有抽象方法和常量值（没有构造器）
 * 1、一个类可以实现多个接口，接口也可以继承其他接口（可实现多继承）
 * 2、接口定义的就是一种功能，此功能可以被类所实现
 * 3、接口的实现类中实现的方法权限修饰符，不能比接口中定义的要低
 * 4、class CC extends DD implements AA
 */
public class TestInterface {
    public static void main(String[] args) {
        Person p1 = new HomeWoman();
        p1.eat();
        p1.walk();
        ((HomeWoman) p1).cook();

        Person p2 = new Worker();
        p2.eat();
        p2.walk();
        ((Worker) p2).work();
    }
}

interface Person
{
    //常量：用public static final修饰
    public static final String name = "人类";
    //也可不用写修饰符，默认接口中隐藏了常量修饰符
    int age = 100;

    //抽象方法：用abstract public修饰
    abstract public void eat();
    //也可以不用写修饰符，默认接口中隐藏了修饰符abstract public
    void walk();
}

interface Woman extends Person
{
    void cook();
}

interface Man extends Person
{
    void work();
}

class HomeWoman implements Woman
{
    @Override
    public void eat() {
        System.out.println("HOMEWOMAN EAT FOOD");
    }

    @Override
    public void walk() {
        System.out.println("HOMEWOMAN WALK");
    }

    @Override
    public void cook() {
        System.out.println("HOMEWOMAN COOK");
    }
}


class Worker implements Man
{
    @Override
    public void work() {
        System.out.println("WORKER WORK");
    }

    @Override
    public void eat() {
        System.out.println("WORKER EAT");
    }

    @Override
    public void walk() {
        System.out.println("WORKER WALK");
    }
}