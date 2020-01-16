package com.OOP.java.Inheritance;

/**
 * @author sunjiacheng
 * @create 2019-10-10-15:30
 */
public class Cylinder extends Circle
{
    private double length;

    public Cylinder() {
        this.length = 1;
    }

    public Cylinder(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double findVolume()
    {
        //return Math.PI * this.getRadius() * this.getRadius() * length;
        //double volume = Math.PI * this.getRadius() * this.getRadius() * length;
        double volume = super.findArea() * length;
        System.out.println("圆柱体的体积为：" + volume);
        return volume;
    }

    //重写：求圆柱体的表面积
    public double findArea()
    {
        //double area = (2 * Math.PI * this.getRadius() * this.getRadius()) + (this.length * 2 * Math.PI * this.getRadius());
        double area = (2 * super.findArea()) + (this.length * 2 * Math.PI * this.getRadius());
        System.out.println("圆柱体的表面积为：" + area);
        return area;
    }
}
