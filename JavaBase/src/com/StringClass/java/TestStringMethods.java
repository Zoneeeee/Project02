package com.StringClass.java;

import org.junit.Test;

/**
 * @author sunjiacheng
 * @create 2019-12-09-14:32
 */

/**
 * String类的常用方法1
 *
 * //获取字符串长度
 * int length();
 *
 * //返回某索引处的字符
 * char charAt(int index);
 *
 * //判断是否为空字符串
 * boolean isEmpty();
 *
 * //将字符串中所有字符转换为小写
 * String toLowerCase();
 *
 * //将字符串中所有字符转换为大写
 * String toUpperCase();
 *
 * //返回字符串的副本，忽略前导空白和结尾空白
 * String trim();
 *
 * //比较字符串的内容是否相同
 * boolean equals(Object obj);
 *
 * //忽略大小写比较字符串内容是否相同
 * boolean equalsIgnoreCase(String anotherString);
 *
 * //字符串连接，等价于"+"
 * String concat(String str);
 *
 * //比较两字符串大小：逐个比较字符串中字符的ASCII值，出现ASCII值不同的字符时返回，返回值：（调用者当前字符ASCII值 - 被比较者当前字符ASCII值）
 * int compareTo(String anotherString);
 *
 * //返回一个字符串，有beginIndex索引位置为开始，到最后
 * String substring(int beginIndex);
 *
 * //返回一个字符串，有beginIndex索引位置为开始，endIndex索引位置为结束
 * String substring(int beginIndex, int endIndex);
 */

/**
 * String类常用方法2
 *
 * //判断字符串是否已指定子串做结尾
 * boolean endsWith(String suffix);
 *
 * //判断字符串是否已指定子串做开头
 * boolean startsWith(String prefix);
 *
 * //判断字符串从索引toffset开始，是否以指定子串做开头
 * boolean startsWith(String prefix, int toffset);
 *
 * //判断当前字符串中，是否包含了指定字符序列 s （传入一个字符串类型也行：String类实现了CharSequence接口）
 * boolean contains(CharSequence s);
 *
 * //返回当前字符串中第一次出现指定子字符串的索引值，如果当前字符串中没有指定子字符串，返回 -1
 * int indexOf(String str);
 *
 * //从指定的索引开始，返回当前字符串中第一次出现指定子字符串的索引值，如果当前字符串中没有指定子字符串，返回 -1
 * int indexOf(String str, int fromIndex);
 *
 * //返回指定子字符串在当前字符串最后一次出现的索引值，如果当前字符串中没有指定子字符串，返回 -1
 * int lastIndexOf(String str);
 *
 * //从指定的索引开始反向搜索，返回指定子字符串在当前字符串最后一次出现的索引值，如果当前字符串中没有指定子字符串，返回 -1
 * int lastIndexOf(String str, int fromIndex);
 */

/**
 * String类常用方法三
 *
 * //返回一个新字符串，它是通过用 newChar 替换此字符串中所有的 oldChar 得到的
 * String replace(char oldChar, char newChar);
 *
 * //返回一个新字符串，它是通过用 replacement 替换此字符窜中所有的目标字符串 target
 * String replace(CharSequence target, CharSequence replacement);
 *
 * //返回一个新字符串，它是通过用 replacement 替换此字符串中所有满足给定 正则表达式regex 的子字符串
 * String replaceAll(String regex, String replacement);
 *
 * //返回一个新字符串，它是通过用 replacement 替换此字符串中第一个满足给定 正则表达式regex 的子字符串
 * String replaceFirst(String regex, String replacement);
 *
 * //判断此字符串是否匹配给定的正则表达式
 * boolean matches(String regex);
 *
 * //根据给定正则表达式，拆分此字符串，返回一个字符串数组
 * String[] split(String regex);
 *
 * //根据给定正则表达式，拆分此字符串，拆分出的子字符串个数不超过limit个，如果超过，剩下的全放到字符串数组的最后一个元素中，返回一个字符串数组
 * String[] split(String regex, int limit);
 */

public class TestStringMethods
{
    @Test
    public void test1()
    {
        String s1 = "          hello world  ";
        String s2 = s1.trim();
        System.out.println(s1);
        System.out.println(s2);
    }

    @Test
    public void test2()
    {
        String s1 = "aaaaaabbb";
        String s2 = "wwwyyy";
        int i = s1.compareTo(s2);
        System.out.println(i); //-22 ： 97(a) - 119(w)
    }
}


