package com.OOP.java.Encapsulation;

/**
 * @author sunjiacheng
 * @create 2019-10-09-17:12
 */

/**
 * this:
 * 1、this可以理解为当前对象或者正在创建的对象，比如 this.name, this.show()
 * 2、可以在构造器中通过 this(形参) 的方式显示的调用本类中其他重载的指定的构造器
 * 3、在构造器中使用 this() 必须放在构造器的第一行
 * 4、在类中，要保持一个构造器中不存在 this()
 *
 * */

public class TestTriAngle
{
    public static void main(String[] args)
    {
        TriAngle t = new TriAngle(1.0, 1.0);
        System.out.println("面积为：" + t.findArea());

        t.setBase(2.3);
        t.setHeight(1.2);
        System.out.println("面积为：" + t.findArea());
    }
}

class TriAngle
{
    private double base;
    private double height;

    public TriAngle()
    {
        System.out.println("初始化开始");
    }
    public TriAngle(double base)
    {
        this();
        this.base = base;
    }
    public TriAngle(double base, double height)
    {
        this(base);
        this.height = height;
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double findArea()
    {
        return ((this.base * this.height) / 2);
    }
}
