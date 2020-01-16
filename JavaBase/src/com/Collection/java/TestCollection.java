package com.Collection.java;

/**
 * @author sunjiacheng
 * @create 2019-10-18-15:35
 */

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

/**
 * 集合和数组的存储，主要指的是内存层面的存储，不涉及持久化的存储（.txt .mp4 .jpg 或 数据库中）
 */


/**
 * 数组在存储数据方面的缺点
 * （1）一旦初始化，长度就不可修改了
 * （2）数组中提供的方法十分有限，对于添加、删除、插入数据等操作，非常不便，同时效率不高
 * （3）获取数组中实际元素的个数的需求，数组中没有现成的属性和方法可用
 * （4）数组存储数据的特点：有序、可重复，对于无序、不可重复的需求，不能满足
 */

/**
 * java集合框架
 * （1）Collection接口API
 * （2）Iterator迭代器接口
 * （3）Collection子接口：Set接口（无序，不可重复）：HashSet、LinkedHashSet、TreeSet
 * （4）Collection子接口：List接口（有序，可重复）：ArrayList、LinkedList、Vector
 * （5）Map接口（与Collection接口并列，具有映射关系）：HashMap、TreeMap、Hashtable
 * （6）Collection工具类
 *
 * java集合的功能
 * 1、可以动态的把多个对象的引用放到容器中
 * 2、可用于存储数量不等的多个对象，还可用于保存具有映射关系的关联数组
 */

/**
 * Collection接口中定义的抽象方法
 * （1）add() 添加元素进入集合中（Collection中不能添加基本数据类型的元素，只能添加对象，123 这类的元素其实是装箱之后的Integer包装类对象）
 * （2）addAll(Collection A) 将集合A 中的元素，添加到集合B中
 * （3）size() 获取集合中的元素个数
 * （4）isEmpty() 判断当前集合是否为空（判断size是否为0）
 * （5）clear() 清空集合元素
 * （6）contains() 判断当前集合中是否包含了obj（内部使用obj对象所在类的equals()方法进行判断，如果obj对象重写了equals方法，则比内容，如果没重写，则比地址）
 * （7）containsAll(Collection A) 判断 集合A 中的所有元素是否都存在于 集合B 中
 * （8）remove() 移除指定的元素（内部也和contains()方法一样，先通过obj对象所在类的equals()方法进行判断，然后再删除）
 * （9）removeAll(Collection B) 从集合A 中移除 集合B中所有的元素（集合A 集合B 共有的）
 * （10）retainsAll(Collection A) 获取当前集合B 和 集合A 的交集，并返回给集合B
 * （11）equals() 当前集合 和 形参集合的所有元素都相同时，返回true
 * （12）hashCode() 返回当前对象的HASH值
 * （13）toArray() 集合 --> 数组
 * （14）asList() 数组 --> 集合（List）
 * （15）iterator() 迭代器 -- 专门用来遍历容器
 */

/**
 * 新特性：JDK5.0  -- foreach循环（增强for循环） -- 可用于遍历集合、数组
 *
 * 内部也是使用迭代器进行遍历，同时将元素赋值给 Object obj
 *
 *         for(Object obj : collection)
 *         {
 *             System.out.println(obj);
 *         }
 */

public class TestCollection
{
    public static void main(String[] args)
    {
        Collection collection = new ArrayList();
        collection.add(123);
        collection.add("AA");
        collection.add(new Person("BB", 12, 1));
        collection.add("CC");
        collection.add(new String("MM"));

        //for(集合元素的类型 局部变量 : 集合对象)
        for(Object obj : collection)
        {
            System.out.println(obj);
        }
    }
}

class Person implements Comparable
{
    private String name;
    private Integer age;
    private int no;

    public Person() {
    }

    public Person(String name, Integer age, int no) {
        this.name = name;
        this.age = age;
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", no=" + no +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return getNo() == person.getNo() &&
                Objects.equals(getName(), person.getName()) &&
                Objects.equals(getAge(), person.getAge());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getAge(), getNo());
    }

    //自然排序
    //功能：按照自定义类型的某个属性进行比较，排列
    //写法：保证hashCode()、equals()、compareTo() 三个方法要一致
    @Override
    public int compareTo(Object o) {
        if(o instanceof Person) {
            Person p = (Person)o;
            int i = this.no - p.no;
            if(i == 0) {
                int j = this.name.compareTo(p.name);
                if(j == 0) {
                    return this.age.compareTo(p.age);
                }
                else { return j; }
            }
            else { return i; }
        }
        return 0;
    }

    /*
    @Override
    public int compareTo(Object o) {
        if(o instanceof Person) {
            Person p = (Person)o;

            //属性类型为：自定义数据类型 时的写法
            //从小到大排列
            //return this.name.compareTo(p.name);
            //从大到小排列
            return -(this.name.compareTo(p.name));

            //属性类型为：包装类型 时的写法（基本属性类型可以写成包装类型，并按照这种方式进行重写）
            //return this.age.compareTo(p.age);

            //属性类型为：基本数据类型 时的写法
            //return (this.no - p.age);
        }
        return 0; //return 0 代表两个属性是一样的，则无法填入Set中
    }
    */


}
