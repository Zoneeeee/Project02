package com.wrapperClass.java;

/**
 * @author sunjiacheng
 * @create 2019-10-12-15:54
 */

/**
 * 包装类：wrapper
 * 1、针对八种基本数据类型定义的，相应的引用类型 -- 包装类
 * 2、作用：使常用的八种基本数据类型具备了类的特点，可以调用类中的方法
 *
 * Boolean Byte Short Integer Long Character Float Double
 *
 * 3、关键点：八大基本数据类型 - 八大包装类 - String类 三者之间的相互转化
 */

public class TestWrapper
{
    public static void main(String[] args)
    {
        TestWrapper tw = new TestWrapper();
        //tw.baseToClass();
        //tw.classToBase();

        //新特性：自动装箱
        int i = 5;
        System.out.println(i);
        Integer i1 = i;
        System.out.println(i1);
        Integer i2 = 10;
        System.out.println(i2);

        //新特性：自动拆箱
        Integer j = 20;
        System.out.println(j);
        int j1 = j;
        System.out.println(j1);

        tw.baseAndClassToString();
        //tw.stringToBaseAndClass();
    }

    public void baseToClass()
    {
        /**
         * 基本数据类型 -> 包装类
         */
        int i = 10;
        System.out.println(i);
        Integer i1 = new Integer(i);
        System.out.println(i1.toString());

        Integer i2 = new Integer('a');  //单个字符可以打印出结果
        System.out.println(i2.toString());

        //Integer i3 = new Integer("12abc");  //字符串，会报 java.lang.NumberFormatException类型
        //System.out.println(i3.toString());

        Float f = new Float("12.01F");
        System.out.println(f);

        Boolean b1 = new Boolean(true);
        Boolean b2 = new Boolean("true");
        System.out.println(b1);
        System.out.println(b2);

        Boolean b3 = new Boolean("asdfasdfshaf");  //所有非true字符串，结果都是false
        System.out.println(b3);
    }

    public void classToBase()
    {
        /**
         * 包装类 -> 基本数据类型
         */
        int i = 10;
        Integer i1 = new Integer(i);

        int i2 = i1.intValue();
        System.out.println(i2);

        Float f = new Float("12.01F");
        float f2 = f.floatValue();
        System.out.println(f2);

        Boolean b1 = new Boolean(true);
        boolean b2 = b1.booleanValue();
        System.out.println(b1);

        Boolean b3 = new Boolean("adfafdasdfasdf");
        boolean b4 = b3.booleanValue();
        System.out.println(b4);
    }

    public void baseAndClassToString()
    {
        /**
         * 基本数据类型和包装类 -> String
         */
        //方法一
        int i1 = 10;
        System.out.println(i1);
        String str1 = i1 + "";  //"10"
        System.out.println(str1);

        //方法二:// String类的静态的重载的方法：valueOf()
        String str2 = String.valueOf(i1);
        System.out.println(str2);
    }

    public void stringToBaseAndClass()
    {
        /**
         * String -> 基本数据类型和包装类
         */
        String str1 = "10";
        System.out.println(str1);
        int i1 = Integer.parseInt(str1);
        System.out.println(i1);

        /*
        String str2 = "adfasfasdfad";//字符串，会报 java.lang.NumberFormatException类型
        System.out.println(str2);
        int i2 = Integer.parseInt(str2);
        System.out.println(i2);
        */

        String str2 = "true";
        System.out.println(str2);
        boolean b1 = Boolean.parseBoolean(str2);
        System.out.println(b1);

        String str3 = "adfasfasdfad";
        System.out.println(str3);
        boolean b2 = Boolean.parseBoolean(str3);
        System.out.println(b2);

    }

}
