package com.morethread.java;

/**
 * @author sunjiacheng
 * @create 2019-12-02-16:51
 */

/**
 * 线程通信
 * 方式一：wait()/notify()
 * 注：
 * （1）wait()/notify()/notifyAll()必须使用在 同步代码块 或 同步方法
 * （2）wait()/notify()/notifyAll()必须是由 同步代码块 或 同步方法 中的 同步监视器 调用
 * （3）wait()/notify()/notifyAll()三个方法是定义在java.lang.Object类中
 */

/**
 * sleep()方法和wait()方法的异同
 * （1）相同点：一旦执行，都可以使得当前线程进入阻塞状态
 * （2）不同点：
 *       （1）声明位置不同
 *              Thread类中声明sleep()
 *              Object类中声明wait()
 *       （2）调用要求不同
 *              sleep()可在任何需要的场景下调用
 *              wait()必须在使用同步代码块/同步方法时调用
 *       （3）当sleep()和wait()都使用在同步代码块/同步方法中时
 *              sleep()不会释放同步监视器
 *              wait()会自动释放同步监视器
 */

public class TestThreadCommunication
{
    public static void main(String[] args)
    {
        Number number = new Number();
        Thread t1 = new Thread(number);
        t1.setName("线程一");
        t1.start();
        Thread t2 = new Thread(number);
        t2.setName("线程二");
        t2.start();

    }
}

class Number implements Runnable
{
    private int number = 1;

    @Override
    public void run()
    {
        while(true)
        {
            synchronized (this)
            {
                //notify()方法：唤醒一个被wait()方法阻塞的线程（多个中唤醒优先级高的）
                //notifyAll()方法：唤醒所有被wait()方法阻塞的线程
                this.notify();
                if(number < 100)
                {
                    System.out.println(Thread.currentThread().getName() + ": " + number);
                    number++;

                    //对共享数据进行操作之后，让线程调用wait()方法
                    //wait()方法一旦调用，会自动放弃手中的同步监视器，进入阻塞状态
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else
                {
                    break;
                }
            }
        }
    }
}