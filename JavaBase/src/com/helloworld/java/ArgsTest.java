package com.helloworld.java;

/**
 * @author sunjiacheng
 * @create 2019-09-29-17:31
 */

/**
 *可变个数的形参
 * 1、格式：对于方法的形参：数据类型 ... 形参名
 * 2、可变个数的形参的方法与同名的方法之间构成重载
 * 3、可变个数的形参的方法在调用时，个数从 0 开始，到无穷多个
 * 4、当无参函数 和 有0个可变个数形参的方法同时出现时，先调用无参函数
 *
 * 作用：可减少由于参数个数不同造成的重载
 *
 * 注意：
 * 1、public void sayHello(String ... args)   和    public void sayHello(String[] args)
 *    不属于重载，编译器认为这两个是一回事
 *
 * 2、可变个数形参只能位于参数列表的最后
 *
 * 3、一个方法之中，只能有一个可变个数的形参
 *
 */
public class ArgsTest {
    public static void main(String[] args) {
        ArgsTest a = new ArgsTest();
        a.sayHello();
        a.sayHello(new String[]{"hello world", "hello China"});   //可变个数形参的方法调用方式1
        a.sayHello("hello China", "hello sunjiahceng");   //可变个数形参的方法调用方式2

        int sum = a.getSum(1, 2, 3, 4, 5, 80);
        System.out.println(sum);
    }
    public void sayHello()
    {
        System.out.println("hello world!!");
    }
    public void sayHello(String str1)
    {
        System.out.println("hello" + str1);
    }
    public void sayHello(String ... args)
    {
        for (int i = 0; i <args.length ; i++) {
            System.out.println(args[i]);
        }
    }
    public void sayHello(int x, String ... args) {
        for (int i = 0; i <args.length ; i++) {
            System.out.println(args[i] + x);
        }
    }

    public int getSum(int ... args) {
        int sum = 0;
        for (int i = 0; i < args.length; i++) {
            sum += args[i];
        }
        return sum;
    }
}
