package com.OOP.java.Encapsulation;

/**
 * @author sunjiacheng
 * @create 2019-10-09-10:53
 */

/**
 * 类的第三个成员：构造器（构造方法）constructor
 * 注意：构造方法和其他的方法是两回事：和普通方法一点关系没有
 *
 * 1、设计类时，如果不显式的声明类的构造器的话，程序会默认提供一个无参的构造器
 * 2、一旦显式的定义了类的构造器，那么默认的构造器将不再被提供
 * 3、类的多个构造器之间构成重载
 *
 * 构造器的作用：
 *  （1）创建对象
 *  （2）给创建的对象的属性赋值
 *
 *  类对象属性赋值的先后顺序：
 *   （1）属性的默认初始化
 *   （2）属性的显示初始化
 *   （3）通过构造器给属性初始化
 *   （4）通过对象.方法的方式给属性赋值
 */
public class TestPerson
{
    public static void main(String[] args)
    {
        Person p = new Person("sunjiacheng");

        String str = new String("sunjiacheng");
        System.out.println(str);
    }
}
class Person
{
    private String name;
    private int age;

    //构造器
    public Person(String name)
    {
        this.name = name;
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
}