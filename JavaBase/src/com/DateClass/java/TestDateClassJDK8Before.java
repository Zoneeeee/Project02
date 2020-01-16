package com.DateClass.java;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @author sunjiacheng
 * @create 2019-12-17-14:02
 */

/**JDK8之前的日期时间API 一：
 * 1、java.lang.System
 *      currentTimeMillis() 时间戳:从 1970年1月1日0时0分0秒 至 今 以毫秒为单位的时间差
 *
 * 2、java.util.Date
 *    （1）构造器一：创建一个对应当前时间的Date对象
 *          Date date = new Date();
 *    （2）构造器二：创建一个指定时间戳（毫秒数）的Date对象
 *          Date date1 = new Date(1576564691013L);
 *    （3）toString()：
 *          格式：Tue Dec 17 14:38:11 CST 2019
 *
 * 3、java.sql.Date (java.util.Date的子类)
 *    （1）构造器:
 *          java.sql.Date date2 = new java.sql.Date(1576565452748L);
 *    （2）toString():
 *          格式：2019-12-17
 */

/**JDK8之前的日期时间API 二：
 * 1、java.text.SimpleDateFormat
 *    （1）SimpleDateFormat：对日期Date类的格式化：日期 --> 字符春
 *    （2）SimpleDateFormat：对日期Date类的解析：字符串 --> 日期
 *
 * 2、java.util.Calendar 日历类（抽象类：不能直接实例化）
 *    （1）实例化
 *          使用 Calendar.getInstance() 静态方法
 *          调用子类 GregorianCalendar 的构造器
 *    （2）常用方法
 *          get()：获取当前日期
 *          set()：设置/修改日期（返回值：void 体现：可变性（缺点））
 *          add()：增加/修改日期
 *          getTime()：Calendar --> Date
 *          setTime()：Date --> Calendar
 *     注：
 *     （1）获取月份时，一月到十二月 为 0-11
 *     （2）获取星期中的具体某天时， 周日是1，周一是2 ... 周六是7
 *
 */



public class TestDateClassJDK8Before
{
    public static void main(String[] args) throws ParseException {
        TestDateClassJDK8Before tdc = new TestDateClassJDK8Before();

        //tdc.dateAPI_1();

        //tdc.dateAPI_2();

        tdc.dateAPI_3();
    }

    //JDK8之前的日期时间API 一
    public void dateAPI_1()
    {
        //java.lang.System
        //时间戳
        //从 1970年1月1日0时0分0秒 至 今 以毫秒为单位的时间差
        long time = System.currentTimeMillis();
        System.out.println(time);

        //java.util.Date
        //构造器一：创建一个对应当前时间的Date对象
        Date date = new Date();
        System.out.println(date.toString()); //获取当前时间：Tue Dec 17 14:38:11 CST 2019
        System.out.println(date.getTime()); //获取当前时间戳：1576564691013
        //构造器二：创建一个指定时间戳（毫秒数）的Date对象
        Date date1 = new Date(1576564691013L);
        System.out.println(date1.toString()); //Tue Dec 17 14:38:11 CST 2019

        //java.sql.Date
        java.sql.Date date2 = new java.sql.Date(1576565452748L); //唯一可用构造器
        System.out.println(date2.toString()); //2019-12-17

        ////java.util.Date 与 java.sql.Date 相互转换
        //情况一
        //java.sql.Date --> java.util.Date :直接赋值（多态：子类转父类）
        Date date3 = new java.sql.Date(1576565893113L);
        //java.util.Date --> java.sql.Date
        java.sql.Date date4 = (java.sql.Date)date3;

        //情况二
        //java.util.Date --> java.sql.Date
        Date date5 = new Date();
        java.sql.Date date6 = new java.sql.Date(date5.getTime());
        System.out.println(date6.toString());
    }

    //JDK8之前的日期时间API 二
    public void dateAPI_2() throws ParseException
    {
        //java.text.SimpleDateFormat
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(); //默认格式化方式
        Date date = new Date();
        System.out.println(date);

        //格式化：日期 --> 字符春
        String dateString = simpleDateFormat.format(date);
        System.out.println(dateString);

        //解析：字符串 --> 日期
        String str = "19-12-17 下午4:50"; //固定格式
        Date date1 = simpleDateFormat.parse(str);
        System.out.println(date1.toString());

        //指定方式格式化
        SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String format1 = simpleDateFormat1.format(date);
        System.out.println(format1);

        //指定方式解析
        String format2 = "2020-01-01 13:00:01";
        Date date2 = simpleDateFormat1.parse(format2);
        System.out.println(date2);

        //练习一：字符串"2020.01.01" --> java.sql.Date
        String birth = "2020-01-01";
        SimpleDateFormat simpleDateFormat_birth = new SimpleDateFormat("yyyy-MM-dd");
        Date date_birth = simpleDateFormat_birth.parse(birth);
        java.sql.Date sql_date_birth = new java.sql.Date(date_birth.getTime());
        System.out.println(sql_date_birth.toString());

    }

    //JDK8之前的日期时间API 二
    public void dateAPI_3()
    {
        //Calendar类 实例化一
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getClass()); //class java.util.GregorianCalendar

        //Calendar类 实例化二
        Calendar calendar1 = new GregorianCalendar();

        //常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH); //获取：今天是这个月的第几天
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_YEAR, 353);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //add()
        calendar.add(Calendar.DAY_OF_YEAR, 1);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        calendar.add(Calendar.DAY_OF_YEAR, -2);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //getTime() : Calendar --> Date
        Date date = calendar.getTime();
        System.out.println(date.toString());

        //setTime() : Date --> Calendar
        Date date1 =  new Date();
        calendar.setTime(date1);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
    }
}
