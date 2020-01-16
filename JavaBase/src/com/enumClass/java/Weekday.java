package com.enumClass.java;

/**
 * @author sunjiacheng
 * @create 2019-10-30-17:01
 */

/**
 * 1、使用enum关键字创建枚举类，定义的枚举类默认继承于java.lang.Enum
 *
 * 2、Enum类的主要方法：
 * （1）values()方法：返回枚举类型的对象数组，该方法可以很方便的遍历所有枚举值
 * （2）valueOf(String str)方法：通过枚举类对象名，返回具体的对象
 * （3）toString()方法：返回当前枚举类对象常量的名称
 *
 */

//enum关键字创建枚举类
public enum Weekday implements Info
{
    Monday("Monday", "周一"){
        public void showInfo(){
            System.out.println("This is Monday!!!");
        }
    },
    Tuesday("Tuesday", "周二"){
        public void showInfo(){
            System.out.println("This is Tuesday!!!");
        }
    },
    Wednesday("Wednesday", "周三"){
        public void showInfo(){
            System.out.println("This is Wednesday!!!");
        }
    },
    Thursday("Thursday", "周四"){
        public void showInfo(){
            System.out.println("This is Thursday!!!");
        }
    },
    Friday("Friday", "周五"){
        public void showInfo(){
            System.out.println("This is Friday!!!");
        }
    };

    private final String weekdayName;
    private final String weekdayDecs;

    Weekday(String weekdayName, String weekdayDecs) {
        this.weekdayName = weekdayName;
        this.weekdayDecs = weekdayDecs;
    }

    public String getWeekdayName() {
        return weekdayName;
    }

    public String getWeekdayDecs() {
        return weekdayDecs;
    }

    @Override
    public String toString() {
        return "Weekday{" +
                "weekdayName='" + weekdayName + '\'' +
                ", weekdayDecs='" + weekdayDecs + '\'' +
                '}';
    }

    //方式一：这样重写的方法：所有的对象调用结果都一样
    /*
    @Override
    public void showInfo() {
        System.out.println("This is weekdays!!!");
    }
    */
}

//枚举类实现接口
interface Info
{
    void showInfo();
}


