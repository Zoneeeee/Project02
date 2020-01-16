package com.string.java;

/**
 * @author sunjiacheng
 * @create 2019-10-12-12:18
 */
public class Order
{
    private int orderID;
    private String orderName;

    public Order() {
    }

    public Order(int orderID, String orderName) {
        this.orderID = orderID;
        this.orderName = orderName;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    //重写Object类中的 equals 方法

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
        {
            return true;
        }
        else if(obj instanceof Order)
        {
            Order o1 = (Order)obj;
            return ((this.orderID == o1.orderID) && (this.orderName.equals(o1.orderName)));
        }
        else
            return false;
    }
}
