package com.Collection.java;

/**
 * @author sunjiacheng
 * @create 2019-10-21-11:25
 */

import java.util.Objects;

/**
 * Set：存储的元素是无序的，不可重复的
 * 1、无序性 不等于 随机性
 * 2、Set的无序性：指的是元素在内存中存储的位置是无序的
 * 3、要求添加进Set中的元素，所在的类，一定要重写equals()方法和hashCode()方法，用来保证Set中元素的不可重复性
 *
 * Set中的元素如何进行存储的？  --使用了哈希算法
 * 1、当Set中添加对象时，首先调用此对象所在类的hashCode()算法，计算此对象的哈希值（这个哈希值决定了此对象在Set中的存储位置）
 * 2、若此位置之前没有对象存储，则这个对象直接存储到此位置
 * 3、若此位置已有对象存储，再通过equals()方法，比较这两个对象是否相同，如果相同，则后一个对象则不能添加进来，如果不相同，则都可以存储
 *
 * 注：hashCode()方法和equals()方法要一致
 *
 * LinkedHashSet：使用链表维护了一个添加进集合时的顺序
 * 1、我们遍历LinkedHashSet集合元素时，是按照添加进去的顺序遍历的（但并不代表是有序的）
 * 2、LinkedHashSet插入性能略低于HshSet（由于要维护一个链表和插入时的顺序）
 * 3、LinkedHashSet的迭代访问Set中全部元素时有很好的性能（由于链表的特性）
 *
 * TreeSet：
 * 1、向TreeSet中添加元素必须是同一类型的（在运行时，会报错，结合泛型会在编译时报错）
 * 2、可以按照添加进集合中的元素的指定顺序遍历，想String，包装类等默认按从小到大的顺序遍历
 * 3、当向TreeSet中添加自定义类对象时，有两种排序方式：
 *      （1）自然排序：要求自定义类实现 java.lang.Comparable接口 并重写其compareTo(Object obj)方法，确定需要排列顺序的具体属性
 *      （2）定制排序：
 *              1、创建一个实现了Comparator接口的类对象，重写compare()方法
 *              2、将此对象作为形参传递给TreeSet的构造器中
 *              3、向TreeSet集合中添加元素
 *
 * 4、自定义类型对象的比较，按照compareTo()方法中比较的那个属性进行比较，如果那个属性相同，则只能填进来一个，其他属性不关心
 *
 * 注：自然排序（适用于可以修改自定义类的情况）：
 *          hashCode()、equals()、compareTo() 三个方法要一致
 *     定制排序（适用于自定义类无法被修改的情况）：
 *          hashCode()、equals()、compare() 三个方法要一致
 *
 *     自然排序和定制排序同时出现时：定制排序优先执行
 *
 */

public class TestSet {
    public static void main(String[] args)
    {

    }
}

class Customer{
    private String name;
    private Integer age;
    private int no;

    public Customer() {
    }

    public Customer(String name, Integer age, int no) {
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
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", no=" + no +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return getNo() == customer.getNo() &&
                Objects.equals(getName(), customer.getName()) &&
                Objects.equals(getAge(), customer.getAge());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getAge(), getNo());
    }
}
