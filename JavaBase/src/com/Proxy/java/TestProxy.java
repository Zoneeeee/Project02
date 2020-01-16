package com.Proxy.java;

/**
 * @author sunjiacheng
 * @create 2019-10-16-16:07
 */

/**
 * 静态代理模式：一个代理类负责代理一个对象的功能
 *
 * 区别于动态代理类：动态代理类：一个代理类负责多个对象的功能（反射机制会用到）
 */

public class TestProxy
{
    public static void main(String[] args)
    {
        Object obj = new ProxyObject();
        obj.action();
    }
}

interface Object
{
    void action();
}

class ProxyObject implements Object
{
    Object obj;

    public ProxyObject() {
        System.out.println("代理类创建成功");
        obj = new ObjectImpl();
    }

    @Override
    public void action() {
        System.out.println("代理类开始执行");
        obj.action();
        System.out.println("代理类执行结束");
    }
}

class ObjectImpl implements Object
{
    @Override
    public void action() {
        System.out.println("=========被代理类开始执行=========");
        System.out.println("=============具体操作============");
        System.out.println("=========被代理类执行完毕=========");
    }
}