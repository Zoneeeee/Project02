package com.OOP.java.Inheritance;

/**
 * @author sunjiacheng
 * @create 2019-10-10-16:14
 */
public class Order
{
    private String orderName;
    int orderID;
    protected int orderNumber;
    public String orderDesc;

    private void method1()
    {
        System.out.println("method1");
    }

    void method2()
    {
        System.out.println("method2");
    }

    protected void method3()
    {
        System.out.println("method3");
    }

    public void method4()
    {
        System.out.println("method4");
    }
}
