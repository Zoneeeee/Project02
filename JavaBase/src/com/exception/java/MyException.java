package com.exception.java;

/**
 * @author sunjiacheng
 * @create 2019-10-18-10:34
 */

/**
 * 自定义异常类
 * 1、序列号用于唯一确定一个异常类对象
 * 2、重写几个构造器
 */
public class MyException extends Exception
{
    static final long serialVersionUID = -7034895766939L; //序列号：用于唯一确定一个异常类对象

    public MyException() {
    }

    public MyException(String message) {
        super(message);
    }
}
