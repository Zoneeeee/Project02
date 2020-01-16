package com.helloworld.java;

/**
 * @author sunjiacheng
 * @create 2019-09-30-10:44
 */

/**
 * 方法的参数传递
 * 1、形参：方法声明时，方法小括号内的参数
 * 2、实参：调用方法时，世纪传入的参数的值
 *
 * 规则：java中的参数传递机制：值传递机制
 * 1、形参是基本数据类型：将实参的值复制一份传递给形参，实际实参本身并没有通过方法得到改变
 * 2、形参是引用数据类型：将引用类型变量的地址（堆中）传递给形参，这时修改形参中的变量相当于直接修改地址内的变量内容
 *
 */
public class ArgsTranferTest {
    public static void main(String[] args) {
        ArgsTranferTest tt = new ArgsTranferTest();
        DataSwap ds = new DataSwap();
        System.out.println(ds.i + "   " + ds.j);

        tt.swap(ds);
        System.out.println(ds.i + "   " + ds.j);
    }
    public void swap(DataSwap ds)
    {
        int temp = ds.i;
        ds.i = ds.j;
        ds.j = temp;
    }
}
class DataSwap
{
    int i = 10;
    int j = 5;
}