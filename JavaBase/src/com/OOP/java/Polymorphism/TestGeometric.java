package com.OOP.java.Polymorphism;

/**
 * @author sunjiacheng
 * @create 2019-10-11-15:09
 */
public class TestGeometric
{
    public static void main(String[] args)
    {
        TestGeometric t = new TestGeometric();

        Circle c1 = new Circle("Red", 1, 2.3);
        Circle c2 = new Circle("Green", 1, 2.3);

        MyRectangle m1 = new MyRectangle("Blue", 2.0, 2.3, 3.0);

        t.displayGeometricObject(c1);
        t.displayGeometricObject(c2);
        t.displayGeometricObject(m1);

        if(t.equalsArea(c1, c2))
            System.out.println("c1: " + c1.findArea() + "  " + "c2: " + c2.findArea() + "面积相等");
        else
            System.out.println("c1: " + c1.findArea() + "  " + "c2: " + c2.findArea() + "面积不相等");

        if(t.equalsArea(c1, m1))
            System.out.println("c1: " + c1.findArea() + "  " + "m1: " + m1.findArea() + "面积相等");
        else
            System.out.println("c1: " + c1.findArea() + "  " + "m1: " + m1.findArea() + "面积不相等");
    }

    public boolean equalsArea(GeometricObject o1, GeometricObject o2)
    {
        if(o1.findArea() == o2.findArea())
            return true;
        else
            return false;
    }

    public void displayGeometricObject(GeometricObject o)
    {
        System.out.println(o.findArea());
    }
}

