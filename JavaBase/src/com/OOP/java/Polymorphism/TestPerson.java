package com.OOP.java.Polymorphism;

/**
 * @author sunjiacheng
 * @create 2019-10-11-11:29
 */

/**
 * 面向对象的特性三：多态性
 * 1、多态性是什么：多态性可以理解为一个事物的多种表现形态
 *    （1）方法的重载与重写，也属于多态性的一种表现
 *    （2）子类对象的多态性: 父类的引用指向子类的对象 -> 父类的引用可以使用子类的方法（只包括子类中重写的方法）
 *
 * 2、多态性的使用前提：
 *    （1）要有类的继承
 *    （2）子类对象对父类的方法进行了重写
 *
 * 3、多态性的注意点
 *    （1）父类引用指向子类对象时（多态），父类引用只能调用父类中声明，子类中重写的方法，子类特有的方法不能使用
 *    （2）向上转型：父类引用指向子类对象
 *             Person pw = new Woman(); //向上转型
 *    （3）向下转型：父类引用指向子类对象时，如果想调用子类特有的方法，则可以强制类型转换为对应的子类类型
 *             Person pw = new Woman();
 *             Woman w = (Woman)pw; //向下转型
 *    （4）向下转型，只能强转父类引用指向的那个子类类型
 *             Person pm = new Man();
 *             Woman w = (Woman)pm; //错误
 *     (5)instanceof 关键字： 对象a instanceof 类A
 *          判断 对象a 是否是 类A 的一个实例，是则返回true
 *
 * 4、子类对象的多态性，并不针对属性！
 *    （1）子类对象对父类方法进行重写时，会对从父类那里继承而来的同名方法进行覆盖
 *    （2）但是子类和父类中存在同名属性时，子类的属性和父类的属性都会存放到子类对象的内存空间中，不存在覆盖的问题，所以多态性不针对属性而言
 *
 */

public class TestPerson
{
    public static void main(String[] args)
    {
        Person p = new Person();
        p.eat();
        p.walk();

        //编译状态下：认为 pm 是 Person类型的
        //运行状态下：关注对象真正的实体，为子类实体
        Person pm = new Man();
        pm.eat();
        pm.walk();

        Person pw = new Woman();
        pw.eat();
        pw.walk();

        //判断父类引用是否指向指定子类类型
        if(pw instanceof Woman)
        {
            Woman w = (Woman)pw; //向下转型
            w.shopping();
        }
        else if(pw instanceof Man)
        {
            Man m = (Man)pw;
            m.entertainment();
        }

        Man m = new Man();
        Woman w = new Woman();

        TestPerson t = new TestPerson();
        t.show(m);
        t.show(w);
    }

    public void show(Person p)
    {
        p.eat();
        p.walk();
    }
}
