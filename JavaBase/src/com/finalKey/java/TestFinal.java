package com.finalKey.java;

/**
 * @author sunjiacheng
 * @create 2019-10-15-16:28
 */

/**
 * final关键字：最终的，可用来修饰类、属性、方法
 * 1、final修饰类：这个类就不能被继承  如：String、StringBuffer、System
 * 2、final修饰方法：这个方法不能被重写  如：Object类中的getClass()方法
 * 3、final修饰属性：此属性就是一个常量，一旦初始化之后，不可再被赋值，常量通常用大写表示
 *
 * 4、final修饰的属性初始化的位置 -- 必须在对象创建之前完成对final属性的初始化
 *      （1）声明时、显式初始化
 *      （2）代码块中初始化
 *      （3）构造器中初始化 -- 注：构造器中初始化final属性时，所有构造器都要对final属性进行初始化
 *
 * 5、全局常量：static final 修饰的变量    如：Math.PI
 *
 * 6、当final修饰一个引用类型的变量时：final Final f3 = new Final();
 *      （1）该变量初始化之后，不能再指向其他的对象
 *      （2）但是该变量指向的对象的成员属性（非final修饰）可以被修改
 *
 */

public class TestFinal
{
    public static void main(String[] args)
    {
        Final f = new Final();
        System.out.println(f.A + f.B + f.C + f.D);
        System.out.println(f.E);
        System.out.println(Final.E);

        Final f1 = new Final("C", "D");
        System.out.println(f1.A + f1.B + f1.C + f1.D);
        System.out.println(f1.E);
        System.out.println(Final.E);

        final Final f3 = new Final();
        //f3 = new Final();错误
        f3.i = 123;
    }
}

class Final
{
    final String A = "AA";
    final String B;
    final String C;
    final String D;
    static final double E;

    int i;

    static{
        E = 12.3654789;
    }

    {
        B = "BB";
    }

    public Final() {
        C = "CC";
        D = "DD";
    }
    public Final(String c, String d) {
        //this();
        C = c;
        D = d;
    }
}
