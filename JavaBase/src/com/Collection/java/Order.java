package com.Collection.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sunjiacheng
 * @create 2019-10-22-17:08
 */
public class Order<T>
{
    private String orderName;
    private int orderID;
    private T t;
    List<T> list = new ArrayList<T>();

    public Order() {
    }

    public Order(String orderName, int orderID, T t, List<T> list) {
        this.orderName = orderName;
        this.orderID = orderID;
        this.t = t;
        this.list = list;
    }

    public void add()
    {
        list.add(t);
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

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderName='" + orderName + '\'' +
                ", orderID=" + orderID +
                ", t=" + t +
                ", list=" + list +
                '}';
    }
}

class SubOrder<T> extends Order<T>
{

}
