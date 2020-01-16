package com.OOP.java.Encapsulation;

/**
 * @author sunjiacheng
 * @create 2019-10-10-9:31
 */

/**
 * package：声明源文件所在的包，写在程序的第一行
 * 1、每“.”一次，表示一层文件目录
 * 2、包名都要小写
 * 3、同一个包下，不能有重名的类，但是不同的包下，可以有同名的类
 */

/**
 * import：显示的导入指定包下的类或接口
 * 1、显示导入指定包下的类或接口
 * 2、写在报的声明和源文件之间
 * 3、如果需要引入多个类或接口，那么就并列写出
 * 4、如果导入的类是 java.lang 包下的，如 System  String  Math等，就不需要显示的声明
 * 5、可用 java.util.* 包含 java.util 包下的所有内容
 * 6、如果出现了不同包下同名类的导入情况，则在程序中标明类所在的包
 *      如：java.sql.Date d1 = new java.sql.Date(1321354);
 * 7、import static 表示导入指定类的 static 的属性或方法（注意：属性和方法）
 * 8、import java.lang.* 只能导入lang包下的所有类或者接口，不能导入lang包的子包下的所有类或者接口
 */

/**
 * java.lang  --  包含一些java语言的核心类，如String、Math、Integer、System、Thread 提供常用功能
 * java.net   --  包含执行与网络相关的操作的类或者接口
 * java.io    --  包含能提供多种输入、输出功能的类
 * java.util  --  包含一些实用的工具类，如定义系统特性、接口的集合框架类、使用与日期日历相关的函数
 * java.text  --  包含一些java格式化相关的类
 * java.sql   --  包含了java进行JDBC数据库编程的相关类或者接口
 * java.awt   --  包含了构成抽象窗口工具集的多个类，这些类用来构建和管理应用程序的图形用户界面（GUI）
 * java.applet--  包含applet运行所需的一些类
 */

import java.util.Date;
import java.util.Scanner;

/**
 * JavaBean
 * 1、类是公共的
 * 2、有一个无参的公共的构造器
 * 3、有属性，且有对应的get 、 set方法
 */
public class TestBean
{
    public static void main(String[] args)
    {
        Scanner s = new Scanner(System.in);
        s.next();

        Date d = new Date();
    }
}
