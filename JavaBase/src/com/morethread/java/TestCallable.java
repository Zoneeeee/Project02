package com.morethread.java;

/**
 * @author sunjiacheng
 * @create 2019-12-04-15:50
 */

/**
 * 线程的创建：
 * 方式三：
 * （1）创建自定义类，实现Callable接口
 * （2）实现call()方法：将子线程需要执行的操作声明在call()方法中
 * （3）创建自定义类对象（Callable接口实现类对象）
 * （4）创建FutureTask类对象，将Callable接口实现类对象作为参数，传入其构造器
 * （5）创建Thread类对象，将FutureTask类对象作为参数，传入其构造器，调用start()方法，启动线程
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 与Runnable相比，Callable功能更加强大
 * （1）call()方法可以有返回值
 * （2）call()方法可以抛异常
 * （3）支持泛型的返回值
 * （4）需要借助FutureTask类，比如获取返回结果
 */

/**
 * FutureTask类
 * （1）实现了 Future接口 和 Runnable接口
 * （2）Future接口唯一实现类
 * （3）可作为Runnable被线程执行
 * （4）可作为Future得到Callable的返回值
 */

public class TestCallable {
    public static void main(String[] args)
    {
        //（3）创建自定义类对象（Callable接口实现类对象）
        NumberThread numberThread = new NumberThread();
        //（4）创建FutureTask类对象，将Callable接口实现类对象作为参数，传入其构造器
        FutureTask<Integer> futureTask = new FutureTask<Integer>(numberThread);
        //（5）创建Thread类对象，将FutureTask类对象作为参数，传入其构造器，调用start()方法，启动线程
        new Thread(futureTask).start();

        //获取Callable接口实现类中实现的call()方法的返回值
        try {
            //get()方法的返回值，即为FutureTask构造器参数Callable实现类重写的call()方法的返回值
            Integer sum = futureTask.get();
            System.out.println(sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

//（1）创建自定义类，实现Callable接口
class NumberThread implements Callable<Integer>
{
    //（2）实现call()方法：将子线程需要执行的操作声明在call()方法中
    @Override
    public Integer call() throws Exception {
        Integer sum = 0;
        for (int i = 1; i <= 100 ; i++) {
            if(i % 2 == 0)
            {
               sum += i;
            }
        }
        return sum;
    }
}