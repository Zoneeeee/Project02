package com.OOP.java.Polymorphism;

/**
 * @author sunjiacheng
 * @create 2019-10-11-11:23
 */
public class Man extends Person
{
    private boolean smoking;

    public Man() {
    }

    public Man(String name, int age, boolean smoking) {
        super(name, age);
        this.smoking = smoking;
    }

    public boolean isSmoking() {
        return smoking;
    }

    public void setSmoking(boolean smoking) {
        this.smoking = smoking;
    }

    @Override
    public void walk() {
        System.out.println("男人走路！");
    }

    @Override
    public void eat() {
        System.out.println("男人吃饭！");
    }

    public void entertainment()
    {
        System.out.println("抽烟、喝酒、烫头");
    }
}
