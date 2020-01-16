package com.DateClass.java;

/**
 * @author sunjiacheng
 * @create 2019-12-18-14:47
 */

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;

/**JDK8 中的日期时间API 一：
 * （1）java.time.LocalDate
 * （2）java.time.LocalTime
 * （3）java.time.LocalDateTime （使用频率最高）
 */

/**JDK8 中的日期时间API 二：
 * （1）java.time.Instant类：瞬时类，可用来记录应用程序中的事件时间戳
 */

/**JDK8 中的日期时间API 三：
 * （1）java.time.format.DateTimeFormatter类 ：格式化、解析 日期和时间
 *
 */

public class TestDateTimeClassJDK8After
{
    public static void main(String[] args)
    {
        TestDateTimeClassJDK8After tdcJa = new TestDateTimeClassJDK8After();

        //tdcJa.dateAPI_1();

        //tdcJa.dateAPI_2();

        tdcJa.dateAPI_3();
    }

    //JDK8 中的日期时间API 一
    public void dateAPI_1()
    {
        //实例化方式一：now()方法
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //实例化方式二：of()方法
        //设置指定的 年 月 日 时 分 秒   没有偏移量（不同于Calendar类）
        System.out.println(LocalDate.of(2020, 12, 18));
        System.out.println(LocalTime.of(16, 14, 1));
        System.out.println(LocalDateTime.of(2020, 12, 18, 16, 10, 58));

        //常用方法一：getXXX()
        //获取相关属性    没有偏移量（不同于Calendar类 ）
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //常用方法二：withXXX()
        //设置相关属性    有返回值，体现不可变性（不同于Calendar类）
        LocalDateTime localDateTime1 = localDateTime.withDayOfYear(358);
        System.out.println(localDateTime);
        System.out.println(localDateTime1);

        //常用方法三：plusXXX()/minusXXX()
        //增加指定属性/减少指定属性    有返回值，体现不可变性
        LocalDateTime localDateTime2 = localDateTime.plusMonths(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        LocalDateTime localDateTime3 = localDateTime.minusDays(3);
        System.out.println(localDateTime);
        System.out.println(localDateTime3);
    }

    //JDK8 中的日期时间API 二
    public void dateAPI_2()
    {
        //实例化
        Instant instant = Instant.now();
        System.out.println(instant);  //时间为：格林尼治时间（伦敦本初子午线时间，较北京时间慢8小时）

        //设置时区偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);

        //获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数
        System.out.println(instant.toEpochMilli()); //1576661114586 ：格林尼治时间

        //通过时间戳进行实例化
        Instant instant1 = Instant.ofEpochMilli(1576661114586L);
        System.out.println(instant1);
    }

    //JDK8 中的日期时间API 三
    public void dateAPI_3()
    {
        //格式化
        //方式一：预定义标准格式：ISO_LOCAL_DATE_TIME 、 ISO_LOCAL_DATE 、 ISO_LOCAL_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        LocalDateTime localDateTime = LocalDateTime.now();
        String str = formatter.format(localDateTime); //格式化
        System.out.println(str);

        TemporalAccessor parse = formatter.parse("2019-12-18T17:45:38.294"); //解析
        System.out.println(parse);

        //方式二：本地化相关格式：ofLocalizedDateTime()
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT); //格式化
        String str1 = formatter1.format(localDateTime);
        System.out.println(str1);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG); //格式化
        String str2 = formatter2.format(localDateTime);
        System.out.println(str2);

        TemporalAccessor parse1 = formatter1.parse("19-12-18 下午5:52"); //解析
        System.out.println(parse1);

        TemporalAccessor parse2 = formatter2.parse("2019年12月18日 下午05时52分21秒"); //解析
        System.out.println(parse2);

        //方式三：自定义格式
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        String str3 = formatter3.format(localDateTime); //格式化
        System.out.println(str3);

        TemporalAccessor parse3 = formatter3.parse("2019-12-18 06:01:47"); //解析
        System.out.println(parse3);


    }
}
