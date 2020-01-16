package com.string.java;

/**
 * @author sunjiacheng
 * @create 2019-10-12-12:18
 */

/**
 * 关于String类
 * 1、在内存中，除了栈区和堆区之外，还有一个方法区，方法区中有一个字符串常量池
 *      String str1 = "AA";
 *      这行代码中的字符串"AA",就存放在方法区中的字符串常量池之中
 * 2、当再次创建一个字符串时
 *      String str2 = "AA";
 *      编译器会去字符串常量池中寻找判断"AA",是否存在
 *      （1）如果存在，则不会重新创建，而是将已存在的"AA"的地址赋给str2
 *      （2）如果不存在，则会创建一个新的字符串常量，并将地址赋给str2
 * 3、如果以new的方式创建字符串对象
 *      String str3 = new String("AA");
 *      (1) 在堆区创建一个new String() 类型的内存空间，并将其地址赋给 str3
 *      (2) 堆区内的这片内存空间创建之后，会去字符串常量池中寻找判断"AA",是否存在
 *              （1）如果存在，则不会重新创建，而是将已存在的"AA"的地址放到 str3 指向的内存空间中
 *              （2）如果不存在，则会创建一个新的字符串常量，并将地址放到 str3 指向的内存空间中
 *
 * 4、同理：如果创建一个其他类型的对象，这个对象中有String类型的属性
 *      （1）则在创建对象、初始化时，会重复上述过程
 *      （2）只要是String类型的值，都会被统一放到字符串常量池中，不同对象/变量，共用同一个字符串常量
 *
 */

public class TestOrder
{
    public static void main(String[] args)
    {
        Order o1 = new Order(1001, "AA");
        Order o2 = new Order(1001, "AA");
        Order o3 = new Order(1002, "BB");

        System.out.println(o1 == o2);         //false
        System.out.println(o1.equals(o2));    //true
        System.out.println(o1.equals(o3));    //false
    }
}
