package com.morethread.java;

/**
 * @author sunjiacheng
 * @create 2019-11-06-10:12
 */

/**
 * 程序：为了完成特定的任务，用某种语言编写的一组指令的集合，即指一段静态的代码，静态对象
 *
 * 进程：是程序的一次执行过程，或是正在运行的一个程序，是一个动态的过程：有它自身的生命周期
 * （1）进程作为资源分配的基本单位
 * （2）系统在运行时会为每个进程分配不同的内存区域（方法区 和 堆空间）
 *
 * 线程：进程可进一步细化为线程，是一个程序内部的一条执行路径
 * （1）若一个进程同一时间并行执行多个线程，则称这个程序时支持多线程的
 * （2）线程作为调度和执行的基本单位
 * （3）每个线程拥有独立的运行栈（虚拟机栈） 和 程序计数器
 * （4）同一个进程中的所有线程，共享进程中的内存空间（方法区 和 堆空间）
 * （5）线程切换开销小
 */

/**
 * 两种创建线程的方式比较：开发中优先选择实现Runnable接口的方式
 * （1）实现的方式没有类单继承性的局限性
 * （2）实现的方式更适合来处理多个线程有共享数据的问题
 */

public class TestThread
{
    public static void main(String[] args)
    {
        //方式一：
        //（3）在主函数中创建该自定义类对象
        MyThread myThread = new MyThread();
        //（4）调用start()方法，启动当前线程，并调用该线程的run()方法
        myThread.start();

        System.out.println("main hello");


        //如果这个线程只使用一次，则不需要单独创建一个线程子类
        //创建Thread类的匿名子类的方式
        new Thread(){
            @Override
            public void run() {
                for (int i = 0; i < 100; i++) {
                    if(i % 2 != 0){
                        System.out.println("Thread2:" + i);
                    }
                }
            }
        }.start();
    }
}

/**
 * 线程的创建
 * 方式一：
 * （1）自定义类继承Thread类
 * （2）重写run()方法：内容为自定义线程中需要执行的操作
 * （3）在主函数中创建该自定义类对象
 * （4）调用start()方法: 启动当前线程，并调用该线程的run()方法
 *
 * 需要注意的问题：
 * （1）如果使用多线程，不能直接去调用对象的run()方法，这样新线程是没有启动的，必须调用start()方法
 * （2）如果想创建多个线程，则需要重新创建线程对象，调用start()方法，不能用已经调用start()方法的对象去继续调用start()方法
 *
 */

//（1）自定义类继承Thread类
class MyThread extends Thread
{
    //（2）重写run()方法：内容为自定义线程中需要执行的操作
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println("Thread1:" + i);
            }
        }
    }
}




