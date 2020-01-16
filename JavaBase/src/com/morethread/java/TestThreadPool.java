package com.morethread.java;

/**
 * @author sunjiacheng
 * @create 2019-12-05-10:25
 */

/**
 * 线程的创建：
 * 方式四：
 * （1）提供指定类型、指定数量的线程池
 * （2）执行指定的线程的操作，需要提供Runnable接口或Callable接口实现类的对象
 * （3）关闭线程池
 */

/**
 * 线程池
 * （1）思路：提前创建好多个线程，放入线程池中，使用时直接获取，是用完之后放回池中
 * （2）解决问题：可避免频繁创建和销毁线程，影响性能，实现重复利用
 * （3）好处：
 *        提高响应速度：减少了创建新线程的时间
 *        降低资源消耗：重复利用线程池中的线程，不需要每次都创建
 *        便于线程管理：
 *              corePoolSize：核心池大小
 *              maximumPoolSize：最大线程数
 *              keepAliveTime：线程没有任务时最长保持多长时间后会终止
 */

/**
 * ExecutorService接口
 * （1）真正的线程池接口：常见子类：ThreadPoolExecutor
 * （2）void execute(Runnable command);  //执行任务/命令，没有返回值，一般用来执行Runnable
 * （3）<T>Future<T>submit(Callable<T> task);  //执行任务，有返回值，一般用来执行Callable
 * （4）void shutdown();  //关闭连接池
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Executors工具类
 * （1）线程池的工厂类，用于创建并返回不同类型的线程池
 * （2）Executors.newCachedThreadPool();  //创建一个可根据需要创建新线程的线程池
 * （3）Executors.newFixedThreadPool(int n);  //创建一个可重用固定线程数的线程池
 * （4）Executors.newSingleThreadExecutor();  //创建一个只有一个线程的线程池
 * （5）Executors.newScheduledThreadPool(int n);  //创建一个线程池，它可安排在给定延迟后运行命令或者定期执行
 */

public class TestThreadPool
{
    public static void main(String[] args)
    {
        //（1）提供指定类型、指定数量的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        //设置线程池属性
        ThreadPoolExecutor tpe = (ThreadPoolExecutor)executorService;
        //核心池大小
        tpe.setCorePoolSize(20);
        //最大线程数
        //tpe.setKeepAliveTime(100, null);
        //线程没有任务时最长保持多长时间后会终止
        tpe.setMaximumPoolSize(100);

        //（2）执行指定的线程的操作，需要提供Runnable接口或Callable接口实现类的对象
        executorService.execute(new NumberTest()); //适用于Runnable
        executorService.execute(new NumberTest1());
        executorService.execute(new NumberTest2());
        //executorService.submit(); //适用于Callable
        //（3）关闭线程池
        executorService.shutdown();//关闭线程池
    }
}

class NumberTest implements Runnable
{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}

class NumberTest1 implements Runnable
{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i % 2 != 0)
                System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}


class NumberTest2 implements Runnable
{
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i % 2 == 0)
                System.out.println(Thread.currentThread().getName() + ": " + i);
        }
    }
}


