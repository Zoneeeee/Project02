package com.helloworld.java;

import com.helloworld.bean.Custom;
import com.helloworld.bean.Person;

import java.util.ArrayList;

/**
 * @author sunjiacheng
 * @create 2019-09-25-17:06
 */

/*
1. IDEA中代码模板所处的位置：settings - Editor - Live Templates / Postfix Completion
2. 常用的模板
 */
public class TemplatesTest
{
    //模板六：prsf
    private static final Custom cust = new Custom();
    //变形：psf
    public static final Person per = new Person();
    //psfi
    public static final int NUM = 1;
    //psfs
    public static final String s = "China";


    //模板1：psvm
    public static void main(String[] args)
    {
        //模板2：sout
        System.out.println();
        //变形：soutp / soutm / soutv / xxx.sout
        System.out.println("args = [" + args + "]");

        System.out.println("TemplatesTest.main");

        int num1 = 10;
        int num2 = 20;
        System.out.println("num2 = " + num2); //就近

        System.out.println(num1);

        //模板3：fori
        String[] arr = new String[]{"Tom", "Jerry", "HanMeiMei", "LiLei"};
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println(arr[i]);
        }
        //变形：iter   增强for循环
        for (String s : arr)
        {
            System.out.println(s);
        }
        //变形：itar   自动补齐内容
        for (int i = 0; i < arr.length; i++)
        {
            String s = arr[i];
        }

        //模板四：list.for
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);
        for (Object o : list)
        {
            
        }
        //变形：list.fori      正序遍历
        for (int i = 0; i < list.size(); i++)
        {
            
        }
        //变形：list.forr      逆序遍历
        for (int i = list.size() - 1; i >= 0; i--)
        {
            
        }
    }

    public static void method()
    {
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(456);
        list.add(789);

        //模板五：ifn
        if (list == null) {
            
        }
        //变形：inn
        if (list != null) {
            
        }
        //变形：xxx.null  /  xxx.nn
        if (list == null) {

        }
        if (list != null) {

        }
    }
}
