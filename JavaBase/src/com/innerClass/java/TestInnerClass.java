package com.innerClass.java;

/**
 * @author sunjiacheng
 * @create 2019-10-17-10:04
 */

/**
 * 类的第五个成员：内部类
 * 1、内部类的分类：
 *      成员内部类：声明在类内部且方法外的
 *      局部内部类：声明在类的方法里
 * 2、成员内部类
 *      （1）具有类的成员的特点
 *              （1）可以有修饰符（4个）
 *              （2）可用static关键字 和 final关键字修饰
 *      （2）具有类的特点
 *              （1）可用abstract关键字修饰
 *              （2）可以在其内部定义属性、方法、构造器
 * 3、关于内部类的重点
 *      （1）如何创建成员内部类的对象
 *      （2）如何处理成员内部类中属性，和外部类中属性同名如何处理
 *      （3）局部内部类的使用
 *
 */
public class TestInnerClass
{
    public static void main(String[] args)
    {
        //创建静态成员内部类的对象
        Person.Legs legs = new Person.Legs();

        //创建非静态成员内部类的对象
        Person p = new Person();
        Person.Brain b = p.new Brain();
        b.info();

        b.setName("脑袋");


    }
}

class Person
{
    private String name = "韩梅梅";
    private int age;

    class Brain
    {
        private String name = "大脑";

        public void setName(String name) {
            //this.name = name;
            System.out.println(name); //脑袋
            System.out.println(this.name); //大脑
            System.out.println(Person.this.name); //韩梅梅 （调用外部类变量的方式）
        }

        public void info() {
            System.out.println("this is Brain's info function!");
            show();
        }
    }

    static class Legs
    {
        private String name;

        public Legs() {
        }

        public Legs(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public void show() {
        System.out.println("this is Person's show function!");
    }

    public void method1()
    {
        //局部内部类：使用场景较少
        class InnerClass {

        }
    }
    //常用方式：一个方法使其返回值为某一个类或者接口的对象，而这个类的子类或接口的实现类在方法内部创建
    public Comparable getComparable()
    {
        //1、创建一个实现Comparable接口的类
        class MyComparable implements Comparable
        {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        }
        //2、返回一个实现类的对象
        return new MyComparable();
    }

    //匿名内部类
    public Comparable getComparable1()
    {
        return new Comparable() {
            @Override
            public int compareTo(Object o) {
                return 0;
            }
        };
    }
}

