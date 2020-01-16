package com.StringClass.java;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author sunjiacheng
 * @create 2019-12-17-11:30
 */

/**
 * StringBuffer / StringBuilder常用方法
 *
 * 增
 * //字符串拼接，提供了多个重载的append方法
 * StringBuffer append(xxx);
 *
 * 删
 * //删除指定区间的内容
 * StringBuffer delete(int start, int end);
 *
 * 改
 * //修改指定索引处的字符值
 * public void setCharAt(int n, char ch);
 *
 * //把 [start, end) 范围，替换成 str
 * StringBuffer replace(int start, int end, String str);
 *
 * 查
 * //返回，查找指定索引处的那个字符
 * public char charAt(int n);
 *
 * 插
 * //在指定位置插入xxx
 * StringBuffer insert(int offset, xxx)
 *
 *
 * 其他
 * //返回子字符串第一次出现的索引值
 * public int indexOf(String str);
 *
 * //返回一个子字符串，范围：[start, end)
 * public String substring(int start, int end);
 *
 * //返回一个字符串的长度
 * public int length();
 *
 * //把当前字符序列逆转
 * StringBuffer reverse()
 *
 */

public class TestStringBufferBuilderMethods
{
    @Test
    public void test1()
    {

    }
}