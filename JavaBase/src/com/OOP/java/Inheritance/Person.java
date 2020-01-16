package com.OOP.java.Inheritance;

/**
 * @author sunjiacheng
 * @create 2019-10-10-16:44
 */
public class Person
{
    private String name;
    private int age;
    int id = 1001;

    public Person() {
        //super();   //隐藏了，默认调动父类的无参构造器（这里是调用Object类的无参构造器）
        this.name = "AA";
        this.age = 1;
    }

    public Person(String name) {
        this();
        this.name = name;
    }

    public Person(String name, int age) {
        this(name);
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void eat()
    {
        System.out.println("eating");
    }

    public void sleep()
    {
        System.out.println("sleeping");
    }

    public int compare(Person p)
    {
        if(this.age > p.age)
            return 1;
        else if(this.age < p.age)
            return -1;
        else
            return 0;
    }
}
