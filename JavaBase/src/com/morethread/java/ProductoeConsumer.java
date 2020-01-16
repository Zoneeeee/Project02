package com.morethread.java;

/**
 * @author sunjiacheng
 * @create 2019-12-04-14:16
 */

/**
 * 生产者消费者问题
 */

public class ProductoeConsumer
{
    public static void main(String[] args)
    {
        Clerk clerk = new Clerk();

        Producer p1 = new Producer(clerk);
        p1.setName("生产者1");
        p1.start();

        Consumer c1 = new Consumer(clerk);
        c1.setName("消费者1");
        c1.start();

        Consumer c2 = new Consumer(clerk);
        c2.setName("消费者2");
        c2.start();

    }
}

class Clerk
{
    private int productCount = 0;

    //生产产品
    public synchronized void produceProduct() { //同步监视器this
        if(productCount < 20)
        {
            this.productCount++;
            System.out.println(Thread.currentThread().getName() + ": 开始生产第" + productCount + "个产品....");
            //只要生产了一个产品，就可以唤醒消费者线程
            this.notify();
        }
        else
        {
            try {
                this.wait();
            } catch (InterruptedException e) { //同步监视器this
                e.printStackTrace();
            }
        }
    }

    //消费产品
    public synchronized void consumeProduct() {
        if(productCount > 0)
        {
            System.out.println(Thread.currentThread().getName() + ": 正在消费第" + productCount + "个产品....");
            this.productCount--;
            //只要消费了一个产品，就可以唤醒生产者线程
            this.notify();
        }
        else
        {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Producer extends Thread
{
    private Clerk clerk;

    public Producer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始生产产品....");
        
        while(true)
        {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            
            clerk.produceProduct();
        }
    }
}

class Consumer extends Thread
{
    private Clerk clerk;

    public Consumer(Clerk clerk) {
        this.clerk = clerk;
    }

    @Override
    public void run() {
        System.out.println(getName() + "开始消费产品....");

        while(true)
        {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.consumeProduct();
        }
    }
}
