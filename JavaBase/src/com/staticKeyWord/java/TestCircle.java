package com.staticKeyWord.java;

/**
 * @author sunjiacheng
 * @create 2019-10-14-17:32
 */
public class TestCircle
{
    public static void main(String[] args)
    {
        Circle c1 = new Circle(1.0);
        Circle c2 = new Circle(2.0);
        Circle c3 = new Circle(3.0);
        Circle c4 = new Circle(4.0);
        Circle c5 = new Circle(5.0);

        System.out.println(Circle.getTotal());
        Circle.show();
    }
}

class Circle
{
    private double radius;
    private static String info = "我是一个圆";
    private static int total = 0; //创建的对象个数

    public Circle(double radius) {
        this.radius = radius;
        total++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public static String getInfo() {
        return info;
    }

    public static void setInfo(String info) {
        Circle.info = info;
    }

    public static int getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }

    public static void show()
    {
        System.out.println(info);
    }

}

