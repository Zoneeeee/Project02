package com.objectClass.java;

/**
 * @author sunjiacheng
 * @create 2019-10-12-15:03
 */

import java.util.Date;

/**
 * java.lang.Object类的toString()方法 的定义 如下：
 *      public String toString() {
 *         return getClass().getName() + "@" + Integer.toHexString(hashCode());
 *      }
 * 1、当我们打印一个对象的引用时，实际上默认调用的就是这个对象的toString()方法
 *          System.out.println(p1);
 * 2、当我们打印对象所在的类没有重写Object类中的toString()方法时，那么调用的就是Object中定义的toString()方法
 *          System.out.println(p1.toString());
 * 3、当我们重写了toString()方法之后，以下两种方式都是默认调用的重写之后的toString()方法
 *          System.out.println(p1);
 *          System.out.println(p1.toString());
 *
 * 4、String类、Date类 中重写了toString()方法
 */

public class TestToString
{
    public static void main(String[] args)
    {
        Person p1 = new Person("AA", 10);
        System.out.println(p1);
        System.out.println(p1.toString());

        String str1 = new String("AA");
        String str2 = "BB";
        System.out.println(str1);
        System.out.println(str2.toString());

        Date d = new Date();
        System.out.println(d);
        System.out.println(d.toString());
    }
}
