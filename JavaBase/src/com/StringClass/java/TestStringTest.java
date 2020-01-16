package com.StringClass.java;

import org.junit.Test;

/**
 * @author sunjiacheng
 * @create 2019-12-05-16:14
 */

/**
 * String类
 * （1）String类声明为final修饰，不可被继承
 * （2）String类实现了 Serializable接口：表示字符串是可支持序列化的
 * （3）String类实现了 Comparable接口：表示字符串可以比较大小
 * （4）String类内部定义了 final char[] value 字符串数组 用于存储字符串数据
 * （5）String：代表不可变的字符序列
 *       不可变性体现：
 *          （1）当对字符串重新赋值时，需要对指定内存空间区域（方法区中的字符串常量池）重新赋值，不能通过修改原有值进行赋值
 *
 *          （2）当对现有字符串进行连接操作时，也需要重新对指定内存区域（方法区中的字符串常量池）进行赋值，不能通过修改原有值进行赋值
 *                  String str = "abc" + "hello";
 *
 *          （3）调用replace()方法对字符串内容进行修改时，也需要重新对指定内存区域进行赋值，不能通过修改原有值进行赋值
 *                  String str = "abc";
 *                  str.replace('a', 'm');  //str: mbc
 * （6）通过字面量的方式给一个字符串赋值，此时字符串值声明在字符串常量池中
 *          String str = "abc";
 * （7）字符串常量池中是不会存放 相同内容 的字符串的
 */

public class TestStringTest
{
    //不可变性体现
    @Test
    public void test1()
    {
        String s1 = "abc";
        System.out.println(s1);
        String s2 = "abc";
        System.out.println(s2);
        s1 = "hello";
        System.out.println(s1);

        String s3 = "abc";
        System.out.println(s3);
        s3 += "hello";
        System.out.println(s3);

        String s4 = "abc";
        s4.replace('a', 'm');
    }

    //字符串的创建
    @Test
    public void test2()
    {
        /**
         * String str = new String("abc");
         * 问：上述代码在内存中创建了几个对象？
         * 答：两个
         *    （1）一个在堆空间：堆空间中的new结构
         *    （2）一个在方法区（字符串常量池）：char[]对应的字符串常量池中的数据
         */
        String str = new String("abc");
        System.out.println(str);
    }

    /**
     * String字符串的创建特殊结论
     * （1）使用字面量创建字符串：字符串保存在方法区的字符串常量池中
     *          String str = "abc";
     *
     * （2）使用字面量拼接的方式创建字符串：字符串保存在方法区的字符串常量池中
     *          String str = "abc" + "hello";
     *
     * （3）只要字符串的 拼接创建 操作中，出现了变量：字符串保存在堆空间中
     *          String s1 = "abc"; //字符串常量池
     *          String str1 = s1; //字符串常量池
     *          String str2 = s1 + "hello"; //堆空间
     *
     * （4）intern()方法，返回值：字符串常量值中已存在的字符串的地址
     *          String s1 = "abc"; //字符串常量池
     *          String s2 = s1 + "hello"; //堆空间
     *          String str = s2.intern(); //字符串常量池
     */
    @Test
    public void test3()
    {
        String s1 = "abc";
        String s2 = "hello";

        String s3 = "abc" + "hello"; //字符串常量池
        String s4 = s1 + "hello"; //堆空间
        String s5 = "abc" + s2; //堆空间
        String s6 = s1 + s2; //堆空间
        String s7 = s6; //堆空间
        String s8 = s7.intern(); //字符串常量池
        String s9 = s3; //字符串常量池

        System.out.println(s3 == s4); //false
        System.out.println(s3 == s5); //false
        System.out.println(s3 == s6); //false
        System.out.println(s3 == s7); //false
        System.out.println(s3 == s8); //true
        System.out.println(s3 == s9); //true
        System.out.println(s7 == s8); //false
    }

    //例题：不可变性的体现
    public void change(String str, char ch[])
    {
        str = "test";
        ch[0] = 'b';
    }
    @Test
    public void test4()
    {
        String str = new String("good");
        char[] ch = {'t', 'e', 's', 't'};
        change(str, ch);
        System.out.println(str);
        System.out.println(ch);
    }
}