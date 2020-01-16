package com.abstractClass.java;

/**
 * @author sunjiacheng
 * @create 2019-10-15-17:29
 */

/**
 * abstract关键字：用于修饰类和方法
 * 1、抽象类不能别实例化：不能创建对象
 * 2、注意：抽象类拥有构造器：避免具体子类的构造器在默认super();时出错
 * 3、抽象类中的所有抽象方法在子类中必须被重写
 * 4、抽象类中可以有抽象方法也可以没有抽象方法
 *
 * 注意：不能用abstract修饰属性，私有方法，构造器，静态方法，final的方法
 */

public class TestAbstractClass
{
    public static void main(String[] args)
    {
        Person w = new Worker("work1", 50);
        System.out.println(w.getName() + "  " + w.getAge());
        w.eat();
        w.walk();

        Person s = new Student("student1", 25);
        System.out.println(s.getName() + "  " + s.getAge());
        s.eat();
        s.walk();
    }
}

abstract class Person
{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void eat();

    public abstract void walk();
}

class Worker extends Person
{
    public Worker() {
    }

    public Worker(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("Worker eat too much meat!!");
    }

    @Override
    public void walk() {
        System.out.println("Worker walk so fast!!");
    }
}

class Student extends Person
{
    public Student() {
    }

    public Student(String name, int age) {
        super(name, age);
    }

    @Override
    public void eat() {
        System.out.println("Student eat too much knowleage!!");
    }

    @Override
    public void walk() {
        System.out.println("Student walk so so fast!!!");
    }
}