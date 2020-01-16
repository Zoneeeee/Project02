package com.CompareClass.java;

/**
 * @author sunjiacheng
 * @create 2019-12-19-10:30
 */

import java.util.Arrays;
import java.util.Comparator;

/**Comparator接口的使用举例：定制排序
 * 1、应用场景
 * （1）当类并没有实现java.lang.Comparable接口，而且又不方便修改代码
 * （2）实现了java.lang.Comparable接口，但是排序规则不适合当前操作
 *
 * 2、重写compare(Object o1, Object o2)方法：比较o1和o2的大小
 * （1）返回正整数：o1 > o2
 * （2）返回负整数：o1 < o2
 * （3）返回零：o1 == o2
 *
 */

public class TestComparator
{
    public static void main(String[] args)
    {
        String[] arr = new String[]{"AA", "CC", "kk", "MM", "GG", "dd", "DD"};
        Arrays.sort(arr, new Comparator<String>() {
            //按照字符串从大到小排序
            @Override
            public int compare(String o1, String o2) {
                if(o1 instanceof String && o2 instanceof String)
                {
                    String s1 = (String) o1;
                    String s2 = (String) o2;
                    return -(s1.compareTo(s2));
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(arr));


        Goods[] goods = new Goods[4];
        goods[0] = new Goods("lenovoMouse", 34);
        goods[1] = new Goods("dellMouse", 52);
        goods[2] = new Goods("xiaomiMouse", 19);
        goods[3] = new Goods("huaweiMouse", 100);
        Arrays.sort(goods, new Comparator<Object>() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods && o2 instanceof Goods)
                {
                    Goods g1 = (Goods)o1;
                    Goods g2 = (Goods)o2;
                    if(g1.getName().equals(g2.getName())) {
                        return -(Double.compare(g1.getPrice(), g2.getPrice())); //姓名一样，从大到小排价格
                    }else{
                        return g1.getName().compareTo(g2.getName()); //姓名从小到大排序
                    }
                }
                throw new RuntimeException("输入的数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(goods));
    }
}
