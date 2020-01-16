package com.helloworld.java;

/**
 * @author sunjiacheng
 * @create 2019-09-29-16:04
 */

/**
 *方法的重载：overLoad
 *要求： 1、同一个类中   2、方法名必须相同   3、参数列表不同（个数，类型）
 */

public class OverLoadTest {
    public static void main(String[] args) {
        OverLoadTest t = new OverLoadTest();
        System.out.println(t.max(12, 56));
        System.out.println(t.max(54.21, 12.23));
        System.out.println(t.max(98.2, 52.1, 69.23));
    }
    public int max(int i, int j) {
        return (i > j) ? i : j;
    }
    public double max(double i, double j){
        return (i > j) ? i : j;
    }
    public double max(double i, double j, double k)
    {
        return (max(i, j) > k) ? (max(i, j)) : k;
    }
}

