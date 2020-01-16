package com.Collection.java;

import java.util.List;

/**
 * @author sunjiacheng
 * @create 2019-10-22-17:07
 */

/**
 * 泛型
 * 1、实例化泛型类对象时，指明泛型的类型，指明之后，对应类中所有使用泛型的位置，都变为实例化中指定的泛型类型
 * 2、如果定义了泛型类，但是实例化中没有使用，默认为Object类型
 *
 */
public class TestGenericity
{
    public static void main(String[] args)
    {
        Order<Boolean> order = new Order<Boolean>();
        order.setT(true);
        System.out.println(order.getT());
        order.add();
        List<Boolean> list = order.list;
        System.out.println(list);
    }
}
