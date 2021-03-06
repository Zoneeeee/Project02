package com.morethread.java;

/**
 * @author sunjiacheng
 * @create 2019-11-21-14:25
 */

/**
 * Thread类中的常用方法：
 * 1、start() : 启动线程；调用当前线程的run()方法
 * 2、run() : 通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明在此方法中
 * 3、currentThread() : 静态方法，返回执行当前代码的线程
 * 4、getName() : 获取当前线程的名字
 * 5、setName() : 设置当前线程的名字
 *
 * 6、yield() : 释放当前CPU的执行权（之后CPU的执行权还是有可能分配到该线程手中）
 * 7、join() : 线程A中调用线程B的join()方法，此时线程A进入阻塞状态，直到线程B完全执行完成，线程A才结束阻塞状态
 * 8、sleep(long millitime) : 会使调用该方法的线程进入阻塞状态，阻塞时长可自己规定（单位：ms）
 *
 * 11、isAlive() : 判断当前线程是否存活
 * 10、stop() : 强制结束调用的线程（已过时）
 *
 * join()方法的应用场景：
 * （1）当前正在运行的线程A，需要使用另一个线程B处理好的数据时
 * （2）会通过线程B的对象，调用join()方法，让线程B先执行完
 * （3）再使用线程B执行完的数据继续执行线程A的任务
 */

/**
 * 线程的调度
 * 1、调度策略
 * （1）时间片：CPU分配时间片给各个线程，各个线程轮番使用CPU
 * （2）抢占式：高优先级的线程抢占CPU
 *
 * 2、线程的优先级等级
 * （1）MAX_PRIORITY 10   //最高 10
 * （2）MIN_PRIORITY 1    //最低 1
 * （3）NORM_PRIORITY 5   //默认 5
 *
 * 3、线程优先级涉及的方法
 * （1）获取线程优先级：getPriority()
 * （2）修改线程优先级：setPriority(int newPriority)
 *
 * 4、优先级说明：
 * （1）高优先级的线程要抢占低优先级线程的CPU执行权，但只是从概率上讲
 * （2）高优先级线程只是在高概率的情况下被执行，并不意味着只有高优先级的线程执行完成，低优先级才执行
 */


public class TestMoreThread {
}
