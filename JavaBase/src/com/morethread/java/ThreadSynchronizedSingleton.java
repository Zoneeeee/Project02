package com.morethread.java;

/**
 * @author sunjiacheng
 * @create 2019-11-28-15:42
 */

/**
 * 线程安全的懒汉式单例设计模式
 */

public class ThreadSynchronizedSingleton {
    public static void main(String[] args)
    {
        Bank bank = Bank.getInstance();
    }
}

class Bank
{
    private Bank()
    {

    }

    private static Bank instance = null;

    public static synchronized Bank getInstance()
    {
        if(instance == null)
        {
            instance = new Bank();
        }
        return instance;
    }
}