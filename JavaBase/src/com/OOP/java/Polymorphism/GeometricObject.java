package com.OOP.java.Polymorphism;

/**
 * @author sunjiacheng
 * @create 2019-10-11-14:40
 */
public class GeometricObject
{
    protected String color;
    protected double weight;

    public GeometricObject()
    {

    }

    protected GeometricObject(String color, double weight) {
        this.color = color;
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double findArea()
    {
        return 0.0;
    }
}
