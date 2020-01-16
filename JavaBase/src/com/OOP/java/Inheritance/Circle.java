package com.OOP.java.Inheritance;

/**
 * @author sunjiacheng
 * @create 2019-10-10-15:30
 */
public class Circle
{
    private double radius;

    public Circle() {
        this.radius = 1;
    }

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double findArea()
    {
        double area = Math.PI * this.radius * this.radius;
        System.out.println("圆形的面积为：" + area);
        return area;
    }
}
