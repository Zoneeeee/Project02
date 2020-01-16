package com.codeBlock.java;

/**
 * @author sunjiacheng
 * @create 2019-10-15-15:13
 */

/**
 * 继承关系下的代码执行顺序
 * 1、从根父类 -> 子类，依次往下执行完所有的 static代码块
 * 2、执行根父类的非静态代码块 -> 执行根父类的构造函数
 * 3、依次向下重复 2 中过程，直到子类中
 *
 * Root's static code block
 * Father's static code block
 * Son's static code block
 *
 * Root's code block
 * Root's constructor
 *
 * Father's code block
 * Father's constructor
 *
 * Son's code block
 * Son's constructor
 *
 */

public class CodeBlockTree
{
    static{
        System.out.println("Root's static code block");
    }

    {
        System.out.println("Root's code block");
    }

    public CodeBlockTree() {
        System.out.println("Root's constructor");
    }
}

class Father extends CodeBlockTree
{
    //private static String name = "AA";

    static{
        //name = "BB";
        //System.out.println(name);
        System.out.println("Father's static code block");
    }

    {
        //name = "CC";
        //System.out.println(name);
        System.out.println("Father's code block");
    }

    public Father() {
        super();
        System.out.println("Father's constructor");
    }
}

class Son extends Father
{
    static{
        System.out.println("Son's static code block");
    }

    {
        System.out.println("Son's code block");
    }

    public Son() {
        super();
        System.out.println("Son's constructor");
    }
}
