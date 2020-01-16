package com.codeBlock.java;

/**
 * @author sunjiacheng
 * @create 2019-10-15-14:07
 */

/**
 * 代码块（初始化块）
 *
 * 静态代码块
 * 1、里面可以有输出语句
 * 2、随着类的加载而加载，而且只被加载一次
 * 3、静态代码块之间，按照顺序结构执行
 * 4、静态代码块的执行要早于非静态代码块
 * 5、静态的代码块中只能执行静态的结构（属性，方法）
 *
 * 非静态代码块
 * 1、可以对类的属性进行初始化操作（静态，非静态都可以）
 * 2、代码块中可以拥有输出语句
 * 3、一个类中可以有多个非静态的代码块，多个代码块之间按照顺序结构执行
 * 4、每创建一个类的对象，非静态代码块就加载一次
 * 5、非静态代码块的执行要早于构造器
 * 6、类中的成员属性的声明，和代码块，两者之间也按照顺序结构执行，谁在前，谁先执行
 *
 * 属性初始化过程
 * （1）默认初始化
 * （2）静态代码块
 * （3）显示的初始化（声明时初始化） 或 非静态代码块初始化 --- 这两个按写的顺序执行
 * （4）构造器中初始化
 * （5）通过方法进行初始化
 *
 *
 *
 */


public class TestCodeBlock
{
    public static void main(String[] args)
    {
        /*
        Order o1 = new Order();
        System.out.println(o1.getOrderID());
        System.out.println(o1.getOrderName());
        System.out.println(Order.getOrderDecs());

        Order o2 = new Order();
        System.out.println(o2.getOrderID());
        System.out.println(o2.getOrderName());
        System.out.println(Order.getOrderDecs());
        */

        new Son();
        System.out.println();
        new Son();
    }
}

class Order
{
    private int orderID = 1001;
    private String orderName;
    private static String orderDecs;

    public Order() {
    }

    public Order(int orderID, String orderName) {
        this.orderID = orderID;
        this.orderName = orderName;
    }

    static {
        orderDecs = "123456789";
        System.out.println("static code block 1" + orderDecs);
    }

    {
        this.orderID = 1002;
        this.orderName = "AA";
        orderDecs = "123";
        System.out.println("code block 1" + orderDecs);
    }

    {
        this.orderID = 1003;
        this.orderName = "BB";
        orderDecs = "123456";
        System.out.println("code block 2" + orderDecs);
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public static String getOrderDecs() {
        return orderDecs;
    }

    public static void setOrderDecs(String orderDecs) {
        Order.orderDecs = orderDecs;
    }
}
