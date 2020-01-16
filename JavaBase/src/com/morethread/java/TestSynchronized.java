package com.morethread.java;

/**
 * @author sunjiacheng
 * @create 2019-11-27-16:45
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
 *
 *
 */
public class TestSynchronized
{
    public static void main(String[] args)
    {
        /*
        //创建方式二
        MySynchronizedThread mst = new MySynchronizedThread();
        //线程一
        Thread t1 = new Thread(mst);
        t1.setName("窗口一");
        t1.start();
        //线程二
        Thread t2 = new Thread(mst);
        t2.setName("窗口二");
        t2.start();
        //线程三
        Thread t3 = new Thread(mst);
        t3.setName("窗口三");
        t3.start();
        */

        //创建方式一
        //线程一
        MySynchronizedThread2 mst1 = new MySynchronizedThread2();
        mst1.start();
        //线程二
        MySynchronizedThread2 mst2 = new MySynchronizedThread2();
        mst2.start();
        //线程三
        MySynchronizedThread2 mst3 = new MySynchronizedThread2();
        mst3.start();
    }
}

class MySynchronizedThread implements Runnable
{
    //共享数据
    private int ticket = 100;

    //可充当同步监视器
    //Object obj = new Object();

    public MySynchronizedThread() {
    }

    @Override
    public void run() {
        while(true)
        {
            //同步代码块
            synchronized(this)
            {
                if(ticket > 0)
                {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ":卖票， 票号：" + ticket);
                    ticket--;
                }
                else
                    break;
            }
        }
    }
}

class MySynchronizedThread2 extends Thread
{
    private static int ticket = 100;

    @Override
    public void run()
    {
        while(true)
        {
            //同步代码块
            //MySynchronizedThread2.class  --类是个对象
            //类只会加载一次，所以类作为对象时，是唯一的
            synchronized(MySynchronizedThread2.class)
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
                else
                    break;
            }
        }
    }
}
