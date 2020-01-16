package com.morethread.java;

/**
 * @author sunjiacheng
 * @create 2019-11-28-14:16
 */

/**
 * 线程安全问题：
 * （1）在多线程的场景下，当某一个线程操作一个变量的过程中，当尚未完成操作时，其他线程参与进来也操作该变量
 * （2）会导致产生错误的变化
 */

/**
 * 在Java中，通过同步机制，来解决线程安全问题
 * （1）方式一：同步代码块
 * synchronized(同步监视器){
 *      //需要被同步的代码：操作共享数据的代码，即为需要被同步的代码
 * }
 *      同步监视器：俗称：锁
 *          （1）任何一个类的对象都可以充当锁（通常使用this--当前对象）
 *          （2）多个线程必须公用同一把锁
 * 注: （1）实现Runnable接口的情况下，可选用this作为同步监视器
 *     （2）继承Thread类的情况下，慎用this作为同步监视器，可选用当前类作为同步监视器：MySynchronizedThread2.class
 *
 *
 * （2）方式二：同步方法
 * 如果操作共享数据的代码，完整的声明在一个方法之中，可将其生命为同步方法
 * 实现Runnable接口方式，非静态同步方法中的锁：this
 * 继承Thread类方式，静态同步方法中的锁：当前类本身（MySynchronizedMethod2.class）
 *
 *
 */
public class TestSynchronizedMethods
{
    public static void main(String[] args)
    {
        /*
        //Runnable方式
        MySynchronizedMethod msm = new MySynchronizedMethod();
        Thread t1 = new Thread(msm);
        t1.start();
        Thread t2 = new Thread(msm);
        t2.start();
        Thread t3 = new Thread(msm);
        t3.start();
        */

        //Thread方式
        MySynchronizedMethod2 msm21 = new MySynchronizedMethod2();
        msm21.start();
        MySynchronizedMethod2 msm22 = new MySynchronizedMethod2();
        msm22.start();
        MySynchronizedMethod2 msm23 = new MySynchronizedMethod2();
        msm23.start();
    }
}

class MySynchronizedMethod implements Runnable
{
    //共享数据
    private static int ticket = 100;

    @Override
    public void run() {
        while(true)
        {
            this.show();
        }
    }
    //同步方法
    //同步方法方式中的锁：this
    private synchronized void show()  //同步监视器：this
    {
        if(ticket > 0)
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票， 票号：" + ticket);
            ticket--;
        }
    }
}


class MySynchronizedMethod2 extends Thread
{
    //共享数据
    private static int ticket = 100;

    @Override
    public void run() {
        while(true)
        {
            this.show();
        }
    }
    //同步方法
    //同步方法方式中的锁：MySynchronizedMethod2.class
    private static synchronized void show()
    {
        if(ticket > 0)
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ":卖票， 票号：" + ticket);
            ticket--;
        }
    }
}