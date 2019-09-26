package com.helloworld.bean;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Custom extends Person
{
    private static int num;

    public static void main(String[] args)
    {
        //排错时作为正确代码，可以用该结构进行代码隐藏，不影响使用
        //region Description
        System.out.println("hello World!!");
        ArrayList list = new ArrayList();
        //endregion

        //method();
    }

    public static void method()
    {
        /*StringBuffer buffer = new StringBuffer();*/

        try {
            FileInputStream fis = new FileInputStream("hello.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        num = 10;
    }

    public void eat()
    {
        System.out.println("Custom 吃饭");
    }

}
