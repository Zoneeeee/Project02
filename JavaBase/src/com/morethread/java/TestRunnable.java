package com.morethread.java;

/**
 * @author sunjiacheng
 * @create 2019-12-04-15:51
 */
public class TestRunnable {
    public static void main(String[] args)
    {
        //方式二：
        //（3）在主函数中创建该自定义类对象
        MyThread2 myt2 = new MyThread2();
        //（4）创建Thread类对象，并将自定义类对象传入Thread类的构造器
        Thread t1 = new Thread(myt2);
        //（5）Thread类对象调用start()方法
        t1.start();

        Thread t2 = new Thread(myt2);
        t2.start();
    }
}

/**
 * 线程的创建：
 * 方式二：
 *（1）自定义类实现Runnable接口
 *（2）实现run()方法：内容为自定义线程中需要执行的操作
 *（3）在主函数中创建该自定义类对象
 *（4）创建Thread类对象，并将自定义类对象传入Thread类的构造器
 *（5）Thread类对象调用start()方法: 启动线程，调用当前线程的run()方法 -> 调用Runnable类型的target对象（Runnable接口的实现类对象）的run()方法
 *
 */
//（1）自定义类实现Runnable接口
class MyThread2 implements Runnable
{
    //（2）实现run()方法：内容为自定义线程中需要执行的操作
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println("Thread1:" + i);
            }
        }
    }
}