package com.OOP.java.Inheritance;

/**
 * @author sunjiacheng
 * @create 2019-10-10-17:13
 */

/**
 * 7、super关键字
 *    （1）super可用于访问父类中定义的属性
 *    （2）super可用于调用父类中定义的成员方法
 *    （3）super可用于在子类构造器中调用父类的构造器
 *
 * 8、当子类和父类中出现同名的属性或者方法时，在子类中可以用 super.属性 或者 super.方法 的方式调用父类的属性或者方法
 *
 * 9、super修饰构造器，通过在子类中使用 super(参数列表) 的方式来显示调用父类中指定的构造器
 *    （1）在构造器内部，super(参数列表) 必须声明在首行
 *    （2）在构造器内部，super(参数列表) 和 this(参数列表) 只能出现一个
 *    （3）在构造器内部，没有显示的调用 super(参数列表) 或者 this(参数列表) 其中的任何一个，默认调用的是父类的无参构造器：super()
 *    （4）父类中存在的没有显示调用 super(参数列表) 或者 this(参数列表), 默认调用的是 Object类 的无参构造器
 *
 * 10、建议设计一个类时，尽量提供一个无参构造器：避免默认调用 super() 时出错
 */

public class TestSuper
{
    public static void main(String[] args)
    {
        Student s = new Student();
        s.show();
        s.info();

        Student s1 = new Student("北京大学");
        System.out.println(s1.getName() + " " + s1.getAge() + ": " + s1.getSchoolName());

        //查看Person类的父类名称
        System.out.println(Person.class.getSuperclass().getName());
    }
}
