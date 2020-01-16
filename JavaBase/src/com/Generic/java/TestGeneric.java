package com.Generic.java;

/**
 * @author sunjiacheng
 * @create 2019-10-29-14:46
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型
 * 1、解决问题：集合中可以存放各种类型的元素，这就导致了当对集合进行某些操作时，由于类型不同的原因，导致异常
 * 2、泛型在集合中可以起到类型限制的作用
 *
 * 自定义泛型类
 * 1、class Order<T> 声明类
 * 2、当创建类对象时，会给 T 规定具体的类型，而类内所有用到 T 的地方，都会变为规定的类型
 *
 * 泛型函数
 * 1、public <E>E getE(E e)
 * 2、public <E>void fromArrayToList(E[] e, List<E> list)
 * 3、泛型函数可脱离类声明时规定的泛型类型
 * 4、应用场景：用于处理不同类型的数据，这些数据不一定和泛型类声明时的规定类型一致，可参考Collection接口
 *
 *
 * 泛型与继承的关系
 * 1、若 类A 是 类B 的子类，那么List<A> 就不是 List<B> 的子接口，两者处于并列关系
 *
 * 2、通配符的使用：可读、不可写
 * （1）定义泛型类型为通配符？的变量，可以接收不同泛型类型的对象
 *          List<?> list = listS; //接收List<String>类型的对象
 * （2）可以读取声明为通配符的集合类的对象：都当成Object类型读即可
 *          Iterator<?> iterator = list.iterator();
 * （3）不允许向声明为通配符的集合类中写入对象：类型不确定
 *          list.add("CC"); //错误
 *
 */

public class TestGeneric
{
    public static void main(String[] args)
    {

    }
}

//泛型类
class Order<T>
{
    private String orderName;
    private int orderID;
    private T t;

    List<T> list = new ArrayList<T>();

    public void add(T t)
    {
        list.add(t);
    }

    //泛型方法：可操作与泛型类定义的不同的类型
    public <E>E getE(E e)
    {
        System.out.println(e);
        return e;
    }

    public <E>void fromArrayToList(E[] e, List<E> list)
    {
        for(E e1 : e)
        {
            list.add(e1);
        }
    }

    public Order() {
    }

    public Order(String orderName, int orderID, T t) {
        this.orderName = orderName;
        this.orderID = orderID;
        this.t = t;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}

class SubOrder<T> extends Order<T>
{

}

class SubOrder2 extends Order<Integer>
{

}