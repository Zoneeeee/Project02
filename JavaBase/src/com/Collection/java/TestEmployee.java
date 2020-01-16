package com.Collection.java;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author sunjiacheng
 * @create 2019-10-21-16:42
 */
public class TestEmployee {
    public static void main(String[] args) {
        Employee e1 = new Employee("LDH", 55, new MyDate(1962, 1, 17));
        Employee e2 = new Employee("GFC", 50, new MyDate(1967, 6, 9));
        Employee e3 = new Employee("ZXY", 58, new MyDate(1959, 3, 6));
        Employee e4 = new Employee("LM", 47, new MyDate(1970, 6, 25));
        Employee e5 = new Employee("ZJL", 38, new MyDate(1979, 11, 2));

        /*
        //自然排序
        TreeSet set = new TreeSet();
        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator it = set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        */

        //定制排序
        Comparator com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee) {
                    Employee e1 = (Employee)o1;
                    Employee e2 = (Employee)o2;
                    int i = e1.getBirthday().getYear().compareTo(e2.getBirthday().getYear());
                    if(i == 0){
                        int j = e1.getBirthday().getMonth().compareTo(e2.getBirthday().getMonth());
                        if(j == 0){
                            return e1.getBirthday().getDay().compareTo(e2.getBirthday().getDay());
                        }
                        else{ return j; }
                    }
                    else{ return i; }
                }
                return 0;
            }
        };
        TreeSet ts = new TreeSet(com);
        ts.add(e1);
        ts.add(e2);
        ts.add(e3);
        ts.add(e4);
        ts.add(e5);

        Iterator it = ts.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }

    }
}
