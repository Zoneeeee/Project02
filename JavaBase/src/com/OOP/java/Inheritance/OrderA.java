package com.OOP.java.Inheritance;

/**
 * @author sunjiacheng
 * @create 2019-10-10-16:22
 */
public class OrderA extends Order
{
    public static void main(String[] args)
    {
        Order order = new Order();
        //order.orderName = "AA";   //错误情况
        order.orderDesc = null;
        order.orderID = 10;
        order.orderNumber = 1111;

        //order.method1();   //错误情况
        order.method2();
        order.method3();
        order.method4();
    }
}
