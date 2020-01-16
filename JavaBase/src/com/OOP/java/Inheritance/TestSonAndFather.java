package com.OOP.java.Inheritance;

/**
 * @author sunjiacheng
 * @create 2019-10-11-10:03
 */
public class TestSonAndFather
{
    public static void main(String[] args)
    {
        Dog d = new Dog();
        d.setAge(10);
        d.setName("花花");
        d.setHostName("李雷");
        System.out.println("name: " + d.getName() + "  " + "age: " + d.getAge() + "  " + "hostName: " + d.getHostName());
    }
}

//生物
class Creator
{
    private int age;

    public Creator() {
        System.out.println("This is Creator's constructor!");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Animal extends Creator
{
    private String name;

    public Animal() {
        System.out.println("This is Animal's constructor!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Dog extends Animal
{
    private String hostName;

    public Dog() {
        System.out.println("This is Dog's constructor!");
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }
}

