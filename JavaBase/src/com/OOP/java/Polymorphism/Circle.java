package com.OOP.java.Polymorphism;

/**
 * @author sunjiacheng
 * @create 2019-10-11-14:50
 */
public class Circle extends GeometricObject
{
    private double radius;

    public Circle() {
    }

    public Circle(String color, double weight, double radius) {
        super(color, weight);
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double findArea() {
        return (Math.PI * this.radius * this.radius);
    }
}
