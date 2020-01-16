package com.enumClass.java;

/**
 * @author sunjiacheng
 * @create 2019-10-30-15:48
 */

/**
 * 枚举类
 * 1、枚举类只有有限个对象，所以需要对其构造函数进行一定的限制，维持其对象的个数
 * 2、单例设计模式可以看作是一种特殊的枚举类
 *
 * 自定义枚举类
 *
 * enum关键字定义枚举类
 *
 * 枚举类实现接口
 */
public class TestEnum
{
    public static void main(String[] args)
    {
        //自定义枚举类
        Season spring = Season.SPRING;
        System.out.println(spring.toString());

        //enum关键字定义枚举类
        //1、values()方法：将所有枚举类中的对象，以数组形式返回
        Weekday[] weekdays = Weekday.values();
        for (int i = 0; i < weekdays.length; i++)
        {
            System.out.println(weekdays[i].toString());
        }
        //2、valueOf(String objName)方法：通过枚举类对象名，返回具体的对象
        Weekday day = Weekday.valueOf("Monday");
        System.out.println(day.toString());

        //枚举类实现接口
        Weekday weekday = Weekday.Monday;
        weekday.showInfo();

    }

}

//自定义枚举类（JDK1.5之前需要自定义枚举类）
class Season
{
    //1、提供类的属性，声明为 private final 类型
    private final String seasonName;
    private final String seasonDecs;
    //2、声明为final的属性，在构造器中初始化之后，不能被修改
    private Season(String seasonName, String seasonDecs)
    {
        this.seasonName = seasonName;
        this.seasonDecs = seasonDecs;
    }
    //3、通过公共方法调用属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDecs() {
        return seasonDecs;
    }

    //4、创建枚举类对象:public static final
    public static final Season SPRING = new Season("Spring", "春暖花开");
    public static final Season SUMMER = new Season("Summer", "夏日炎炎");
    public static final Season AUTUMN = new Season("Autumn", "秋高气爽");
    public static final Season WINTER = new Season("Winter", "白雪皑皑");

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDecs='" + seasonDecs + '\'' +
                '}';
    }
}