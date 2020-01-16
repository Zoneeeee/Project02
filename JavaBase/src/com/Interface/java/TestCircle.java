package com.Interface.java;

/**
 * @author sunjiacheng
 * @create 2019-10-16-17:34
 */
public class TestCircle
{
    public static void main(String[] args)
    {
        ComparableCircle c1 = new ComparableCircle(3.2);
        ComparableCircle c2 = new ComparableCircle(5.0);
        ComparableCircle c3 = new ComparableCircle(1.1);

        int i1 = c1.compareTo(c1);
        System.out.println(i1);
        int i2 = c1.compareTo(c2);
        System.out.println(i2);
        int i3 = c1.compareTo(c3);
        System.out.println(i3);

        //int i4 = c1.compareTo(new String());
        //System.out.println(i4);
    }
}

interface CompareObject
{
    int compareTo(Object o);
}

class Circle
{
    private double radius;

    public Circle() {
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
}

class ComparableCircle extends Circle implements CompareObject
{
    public ComparableCircle() {
    }

    public ComparableCircle(double radius) {
        super(radius);
    }

    @Override
    public int compareTo(Object o) {
        if(this == o){
            return 0;
        } else if(o instanceof ComparableCircle) {
            ComparableCircle c = (ComparableCircle)o;
            if(this.getRadius() > c.getRadius()){
                return 1;
            } else if(this.getRadius() < c.getRadius()){
                return -1;
            } else
                return 0;
        }else{
            throw new RuntimeException("传入的非ComparableCircle的对象，不可进行比较");
        }
    }
}