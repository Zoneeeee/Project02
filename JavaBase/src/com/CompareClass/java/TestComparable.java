package com.CompareClass.java;

/**
 * @author sunjiacheng
 * @create 2019-12-19-10:30
 */

import java.util.Arrays;

/**Comparable接口的使用举例：自然排序
 * 1、像String、包装类等实现了Comparable接口，重写了compareTo(Object obj)方法，给出了比较两个对象大小的解决方案
 * 2、像String、包装类重写了compareTo()方法之后，进行了从小到大的排列
 * 3、重写compareTo()规则
 *      如果当前对象this大于形参对象obj，则返回正整数
 *      如果当前对象this小于形参对象obj，则返回负整数
 *      如果当前对象this等于形参对象obj，则返回零
 * 4、对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable接口，重写compareTo()方法，指明如何排序
 *
 */


public class TestComparable
{
    public static void main(String[] args)
    {
        Goods[] arr = new Goods[4];
        arr[0] = new Goods("lenovoMouse", 34);
        arr[1] = new Goods("dellMouse", 52);
        arr[2] = new Goods("xiaomiMouse", 19);
        arr[3] = new Goods("huaweiMouse", 100);

        Arrays.sort(arr);

        System.out.println(Arrays.toString(arr));
    }
}


class Goods implements Comparable
{
    private String name;
    private double price;

    public Goods() {
    }

    public Goods(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Object o)
    {
        if(o instanceof Goods)
        {
            Goods goods = (Goods)o;

            //方式一
            if(this.price > goods.price) {
                return 1;
            } else if(this.price < goods.price) {
                return -1;
            } else {
                //return 0;
                return -(this.name.compareTo(goods.name)); //如果价格相等，按名称从高到低排
            }

            //方式二
            //return Double.compare(this.price, goods.price);
        }
        throw new RuntimeException("传入类型不一致");
    }

}