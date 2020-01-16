package com.OOP.java.Polymorphism;

/**
 * @author sunjiacheng
 * @create 2019-10-11-11:27
 */
public class Woman extends Person
{
    private boolean beauty;

    public Woman() {
    }

    public Woman(String name, int age, boolean beauty) {
        super(name, age);
        this.beauty = beauty;
    }

    public boolean isBeauty() {
        return beauty;
    }

    public void setBeauty(boolean beauty) {
        this.beauty = beauty;
    }

    @Override
    public void walk() {
        System.out.println("女人窈窕的走路。。。");
    }

    @Override
    public void eat() {
        System.out.println("女人少吃，减肥。。。");
    }

    public void shopping()
    {
        System.out.println("买买买！！！");
    }
}
