package com.innerClass.java;

/**
 * @author sunjiacheng
 * @create 2019-10-17-11:45
 */
public class TestProduct
{
    public static void main(String[] args)
    {
        TestProduct t = new TestProduct();

        //方式一：创建一个接口实现类对象，作为形参传入
        t.show(new NoteBook());

        //方式二：创建一个实现接口的匿名类的匿名对象
        t.show(new Product() {
            @Override
            public void getName() {
                System.out.println("ASUS笔记本电脑");
            }

            @Override
            public void getPrice() {
                System.out.println("$600");
            }
        });

        //方式三：使用局部内部类，返回一个接口实现类的对象
        t.show(t.getProduct());

        //方式四：使用匿名内部类，返回一个接口实现类的对象
        t.show(t.getProduct1());
    }
    public void show(Product p)
    {
        p.getName();
        p.getPrice();
    }

    //局部内部类的使用
    public Product getProduct()
    {
        //方式一：实现Product接口的局部内部类
        class Canera implements Product
        {
            @Override
            public void getName() {
                System.out.println("数码相机");
            }

            @Override
            public void getPrice() {
                System.out.println("$200");
            }
        }
        return new Canera();
    }

    public Product getProduct1()
    {
        //方式二：实现Product接口的匿名内部类
        return new Product() {
            @Override
            public void getName() {
                System.out.println("智能音箱");
            }

            @Override
            public void getPrice() {
                System.out.println("$20");
            }
        };
    }
}

interface Product
{
    void getName();
    void getPrice();
}

class NoteBook implements Product
{
    @Override
    public void getName() {
        System.out.println("HP笔记本电脑");
    }

    @Override
    public void getPrice() {
        System.out.println("$800");
    }
}
