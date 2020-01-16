package com.StringClass.java;

/**
 * @author sunjiacheng
 * @create 2019-12-05-16:58
 */
public class TestString
{
    public static void main(String[] args)
    {
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);

        System.out.println(sb.length());  //4

        System.out.println(sb); //"null"

        StringBuffer sb1 = new StringBuffer(str); //空指针异常
        System.out.println(sb1);
    }
}
