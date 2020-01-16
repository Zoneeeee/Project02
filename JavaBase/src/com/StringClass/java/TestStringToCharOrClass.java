package com.StringClass.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * @author sunjiacheng
 * @create 2019-12-13-10:02
 */

public class TestStringToCharOrClass
{
    /**
     * String --> 基本数据类型、包装类
     * 调用包装类的静态方法：parseXxx(str);
     */
    @Test
    public void test1()
    {
        String str = "123";
        int num = Integer.parseInt(str);
        System.out.println(num);

        boolean bl = Boolean.parseBoolean(str);
        System.out.println(bl);
    }

    /**
     * 基本数据类型、包装类 --> String
     * (1)调用String重载的静态方法 valueOf(xxx)
     * (2)基本数据类型、包装类对象 + ""
     */
    @Test
    public void test2()
    {
        int num = 156465316;
        String str = String.valueOf(num);
        System.out.println(str);

        boolean bl = true;
        String str1 = String.valueOf(bl);
        System.out.println(str1);

        String str2 = num + "";
        System.out.println(str2);
    }

    /**
     * String --> char[]
     * 调用String类中的方法：toCharArray()
     *
     * char[] --> String
     * 使用String类中的构造器，将 char[] 放入String类的构造器中
     */
    @Test
    public void test3()
    {
        //String --> char[]
        String str = "456434";
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++)
        {
            System.out.println(chars[i]);
        }

        //char[] --> String
        char[] chars1 = {'h', 'e', 'l', 'l', 'o'};
        String str1 = new String(chars1);
        System.out.println(str1);
    }

    /**编码
     * String --> byte[]
     * 调用String类中的方法：getBytes()
     */

    /**解码：一定要与编码时使用的字符集一致，不然会出现乱码
     * byte[] --> String
     * 使用String类中的构造器，将 byte[] 放入String类的构造器中
     */

    /**
     * 编码：字符串 -> 字节 (看得懂 -> 看不懂的二进制数据)
     * 解码：字节 -> 字符串 (看不懂的二进制数据 -> 看得懂)
     */
    @Test
    public void test4()
    {
        //String --> byte[] (默认：UTF-8 字符集)
        String str = "abc123中国"; //UTF-8中一个汉字三个字节
        byte[] bytes = str.getBytes(); //使用默认的字符集：UTF-8 进行转换
        System.out.println(Arrays.toString(bytes));

        //String --> byte[] (GBK 字符集)
        byte[] bytes1 = new byte[0];
        try {
            bytes1 = str.getBytes("gbk"); //gbk中一个汉字两个字节
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(Arrays.toString(bytes1));


        //byte[] --> String
        String str2 = new String(bytes); //默认使用 UTF-8
        System.out.println(str2);

        String str3 = null;
        try {
            str3 = new String(bytes1, "gbk"); //设置使用 gbk
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(str3);

    }



}