package com.Interface.java;

/**
 * @author sunjiacheng
 * @create 2019-10-16-16:58
 */

/**
 * 接口的理解：以USB接口为例
 * 1、USB接口的尺寸大小，规格等，相当于接口中的常量，必须是符合这些常量值才能使用
 * 2、USB设备插上接口时应具备的功能，例如：增删改查文件、弹出设备等，相当于接口中定义的抽象方法
 * 3、具体的设备插到接口时，需要安装相应的驱动：就是这套接口的实现类集合
 */

public class TestUSB
{
    public static void main(String[] args)
    {
        Computer c = new Computer();

        USB u1 = new Printer();
        c.doWork(u1);

        c.doWork(new Flash());

        //实现接口的匿名类的对象 方式一
        USB phone = new USB() {
            @Override
            public void start() {
                System.out.println("手机开始工作");
            }

            @Override
            public void stop() {
                System.out.println("手机停止工作");
            }
        };
        c.doWork(phone);

        //实现接口的匿名类的对象 方式二
        c.doWork(new USB() {
            @Override
            public void start() {
                System.out.println("U盘开始工作");
            }

            @Override
            public void stop() {
                System.out.println("U盘开始工作");
            }
        });
    }
}

interface USB
{
    void start();
    void stop();
}

class Computer
{
    public void doWork(USB usb)
    {
        usb.start();
        System.out.println("=========设备开始工作========");
        usb.stop();
    }
}

class Printer implements USB
{
    @Override
    public void start() {
        System.out.println("打印机开始工作");
    }

    @Override
    public void stop() {
        System.out.println("打印机停止工作");
    }
}

class Flash implements USB
{
    @Override
    public void start() {
        System.out.println("闪存开始工作");
    }

    @Override
    public void stop() {
        System.out.println("闪存停止工作");
    }
}