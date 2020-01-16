package com.morethread.java;

/**
 * @author sunjiacheng
 * @create 2019-12-02-11:05
 */

/**
 * 死锁：
 *（1）不同的线程分别占用对方需要的同步资源不放弃，都在等待对方放弃自己需要的同步资源，就形成了线程的死锁
 *（2）出现死锁后，不会出现异常，不会出现提示，只是所有线程都处于阻塞状态，无法继续
 *
 * 解决方法：
 * （1）专门的算法、原则
 * （2）尽量减少同步资源的定义
 * （3）尽量避免嵌套同步
 *
 * 简单举例：
 * （1）执行一个同步代码时，需要先拿A锁，再拿B锁
 * （2）执行另一个同步代码时，需要先拿B锁，再拿A锁
 * （3）且两个同步代码中，都有sleep阻塞情况出现
 */

public class DeadLock implements Runnable
{
    A a = new A();
    B b = new B();

    public void init()
    {
        Thread.currentThread().setName("主线程");
        //调用A实例的foo方法
        a.foo(b);
        System.out.println("进入主线程之后");
    }

    @Override
    public void run()
    {
        Thread.currentThread().setName("副线程");
        //调用B实例的bar方法
        b.bar(a);
        System.out.println("进入副线程之后");
    }

    public static void main(String[] args)
    {
        DeadLock dl = new DeadLock();
        new Thread(dl).start();
        dl.init();
    }
}

class A
{
    public synchronized void foo(B b)
    {
        System.out.println("当前线程名：" + Thread.currentThread().getName() + " 进入了A实例的foo方法");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("当前线程名：" + Thread.currentThread().getName() + " 企图调用B实例的last方法");
        b.last();
    }
    public synchronized void last()
    {
        System.out.println("进入A实例的last方法内部");
    }
}

class B
{
    public synchronized void bar(A a)
    {
        System.out.println("当前线程名：" + Thread.currentThread().getName() + " 进入了B实例的bar方法");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.last();
        System.out.println("当前线程名：" + Thread.currentThread().getName() + " 企图调用A实例的last方法");
    }
    public synchronized void last()
    {
        System.out.println("进入B实例的last方法内部");
    }
}
