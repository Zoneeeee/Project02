package com.morethread.java;

/**
 * @author sunjiacheng
 * @create 2019-12-02-14:58
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁
 * （1）从JDK5.0开始，Java提供了更强大的线程同步机制 -- 通过显式定义同步锁对象来实现同步
 * （2）同步锁使用Lock对象来充当
 */

/**
 * ReentrantLock类 实现了 Lock接口
 */

/**
 * synchronized 和 lock 的异同
 * （1）相同：二者都可以解决线程安全问题
 * （2）不同：
 *       （1）synchronized机制在执行完相应的同步代码之后，自动释放同步监视器
 *       （2）lock机制，需要手动的启动同步，手动的结束同步
 */

/**
 * 开发中对于代码同步建议顺序：
 * lock > 同步代码块 > 同步方法
 */

public class TestLock
{
    public static void main(String[] args)
    {
        Window w = new Window();
        Thread t1 = new Thread(w);
        t1.setName("窗口一");
        t1.start();
        Thread t2 = new Thread(w);
        t2.setName("窗口二");
        t2.start();
        Thread t3 = new Thread(w);
        t3.setName("窗口三");
        t3.start();
    }
}

class Window implements Runnable
{
    private int ticket = 100;

    //ReentrantLock锁
    //参数：boolean fair
    //（1）true 公平模式：先到先得
    //（2）false（默认）：谁抢到算谁
    //1、实例化ReentrantLock锁对象
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
        while(true)
        {
            try {
                //2、调用lock()方法：加锁
                lock.lock();
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + ": 售票， 票号为：" + ticket);
                    ticket--;
                }
            }finally {
                //3、调用unlock()方法：解锁
                lock.unlock();
            }
        }
    }
}
