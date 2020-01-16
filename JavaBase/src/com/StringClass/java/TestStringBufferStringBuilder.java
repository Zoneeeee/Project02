package com.StringClass.java;

/**
 * @author sunjiacheng
 * @create 2019-12-16-15:54
 */

/**
 * StringBuffer/StringBuilder 与 String 异同
 * （1）StringBuffer/StringBuilder：可变的字符序列
 * （2）StringBuffer：线程安全，效率偏低
 *      StringBuilder：线程不安全，效率偏高
 * （3）StringBuffer/StringBuilder：底层用 char[] 存储(在其继承的父类：AbstractStringBuilder中)，不用final修饰，是可变的
 *
 * //1、容量、长度问题（StringBuffer/StringBuilder）
 * StringBuffer sb = new StringBuffer(); //调用无参构造函数创建StringBuffer对象，容量（容量不等于字符串长度）为 16
 * StringBuffer sb = new StringBuffer("abc"); //调用有参构造函数创建StringBuffer对象，容量（容量不等于字符串长度）为 str.length() + 16
 *
 * //2、扩容问题（StringBuffer/StringBuilder）
 * （1）如果要添加的数据底层数组装不下了，就需要扩容底层的数据
 * （2）默认情况下，创建一个新的数据，容量为原来容量的（2倍 + 2），同时将原有数组中的数据复制到新的数组中
 * （3）特殊情况：
 *          （1）如果 原来容量的（2倍 + 2）还是不能装下数据，则创建一个新的数组，容量为这个数据的长度
 *          （2）如果 原来容量的（2倍 + 2）成为了负数（将二进制的符号位从 0 变为了 1），则创建一个新数据，容量为 MAX_VALUE = 0x7FFFFFFF (long int型的最大值)
 *  注：如果对效率有较高要求，则尽量避免扩容操作，可用构造器 StringBuilder(int capacity); 规定底层数组的容量
 *
 */

public class TestStringBufferStringBuilder {
    public static void main(String[] args)
    {
        /*
        StringBuffer sb1 = new StringBuffer();
        System.out.println(sb1.length()); //0
        System.out.println(sb1.capacity()); //16

        StringBuffer sb2 = new StringBuffer("abc");
        sb2.setCharAt(0, 'm'); //没有返回值：可变性的体现
        System.out.println(sb2);
        System.out.println(sb2.length()); //3
        System.out.println(sb2.capacity()); //19
        sb2.append("def");
        */


        TestStringBufferStringBuilder tsbsb = new TestStringBufferStringBuilder();
        tsbsb.testSpeed();

    }


    public void testSpeed()
    {
        long startTime = 0L;
        long endTime = 0L;

        String text = "";
        StringBuffer buffer = new StringBuffer("");
        StringBuilder builder = new StringBuilder("");

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            buffer.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuffer执行时间为：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            builder.append(String.valueOf(i));
        }
        endTime = System.currentTimeMillis();
        System.out.println("StringBuilder执行时间为：" + (endTime - startTime));

        startTime = System.currentTimeMillis();
        for (int i = 0; i < 20000; i++) {
            text = text + i;
        }
        endTime = System.currentTimeMillis();
        System.out.println("String执行时间为：" + (endTime - startTime));
    }


}
