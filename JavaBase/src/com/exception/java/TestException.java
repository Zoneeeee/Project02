package com.exception.java;

/**
 * @author sunjiacheng
 * @create 2019-10-17-13:42
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * java异常
 * 1、程序执行过程中发生的不正常情况，称为异常
 * 2、开发过程中的语法错误和逻辑错误不是异常
 * 3、java程序执行过程中发生的异常事件分为两类：
 *      （1）Error：JVM无法解决的严重问题
 *              （1）JVM系统内部错误
 *              （2）资源耗尽
 *      （2）Exception：其他因编程错误或偶然的外在因素导致的一般性问题，可以使用针对性代码进行处理
 *              （1）空指针访问
 *              （2）试图读取不存在的文件
 *              （3）网络连接中断
 * 4、Exception异常
 *      （1）编译时异常：在编译期间出现的异常：SQLException、IOException、ClassNotFountException等
 *      （2）运行时异常：在运行时期出现的异常：RuntimeException（NullPointerException、ArrayIndexOutOfBoundsException等）
 *
 * 5、当执行一个程序时出现异常，那么异常之后的代码就不再执行了
 *
 * 6、继承关系中，如果父类的方法抛出了异常，则子类再重写该方法时，异常的范围必须小于等于父类抛出的异常类型
 *
 * 异常的处理：抓抛模型
 * 1、抛
 *      （1）当发生异常时（编译或运行）：会在异常的代码处生成一个对应异常类型的对象，并将其抛出
 *      （2）一旦抛出此异常类的对象，则程序就会终止执行
 *      （3）此异常类对象，抛给方法的调用者
 * 2、抓
 *      （1）抓出抛出的异常类对象，如何抓？ ->  异常处理的方式（两种）
 *      （2）异常处理方式一：解决掉该异常
 *      （3）异常处理方式二：继续向上抛，抛给别人解决
 *
 * 异常处理方式一：try-catch块
 *      try{
 *          //可能出现异常的代码
 *      }
 *      catch(Exception1 e1){
 *          //处理方式一
 *      }
 *      catch(Exception2 e2){
 *          //处理方式二
 *      }
 *      finally{
 *          //一定要执行的代码：
 *          //当try-catch块中有异常未被处理、catch块中的处理问题的代码出现异常，或者因为某些原因（return）导致程序终止等原因
 *          //无法执行try-catch块后面的代码时
 *          //finall块中的代码一定会被执行
 *      }
 * 注：
 *      1、try内部声明的变量，类似于局部变量，出了try块，就不能被调用了，所以一些变量的声明尽量放在try块外面
 *      2、finally是可选的
 *      3、catch语句内部是对异常对象的处理
 *          getMessage() -- 获取异常的信息
 *          printStackTrace() -- 打印异常的堆栈信息
 *      4、可以有多个catch块，try中抛出的异常类对象从上往下去匹配catch中的异常类的类型，一旦满足就去执行catch块中的代码，执行完跳出try-catch块
 *      5、如果异常处理了，则其后的代码继续执行
 *      6、对于运行时异常，可以不显示的进行处理，但是对于编译时异常，必须要处理（否则不让运行）
 *      7、若catch中多个类型是并列关系，则顺序匹配，怎么放都可以，但是如果多个类型是包含关系，则范围小的放在上面
 *
 * 异常处理方式二：抛出异常：将异常对象抛给方法的调用者，让调用者去处理（通过try-catch）
 *
 */

public class TestException
{
    public static void main(String[] args)
    {
        int i = TestException.method1();
        System.out.println(i);//一直会返回2

        try {
            TestException.method3();
        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
        }

        try {
            TestException.method4();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int method1()
    {
        try {
            //System.out.println(10/0);
            System.out.println(123);
            return 1;
        }
        catch (Exception e) {
            e.printStackTrace();
            return 3;
        }
        finally {
            System.out.println("我是最需要执行的代码");
            return 2;
        }
    }

    public static void method2() throws FileNotFoundException, IOException
    {
        FileInputStream fis = null;
        fis = new FileInputStream(new File("hello.txt"));
        int b;
        while((b = fis.read()) != -1){
            System.out.println((char)b);
        }
        fis.close();
    }

    public static void method3() throws IOException { //继续抛
        TestException.method2();
    }

    public static void method4() throws Exception {
        //手动抛出异常：常用于if-else中，当不满足某些条件时，则手动抛出
        //此处运行中的异常可以不显示的处理
        //throw new RuntimeException("这是个运行中的异常");

        //非运行时异常，则需要显示的处理，以下为处理的两种方式
        //1、往上抛，让调用者处理
        throw new Exception("这是个异常");
    }

    public static void method5()
    {
        //非运行时异常，则需要显示的处理
        //2、就在这里处理
        try {
            throw new Exception("这是个异常");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
