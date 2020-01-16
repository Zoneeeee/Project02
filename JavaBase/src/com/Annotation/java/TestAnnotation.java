package com.Annotation.java;

/**
 * @author sunjiacheng
 * @create 2019-10-31-10:25
 */

import java.lang.annotation.*;
import java.util.ArrayList;

/**
 * 注解：Annotation
 * 1、JDK内置的基本注解类型（3个）：
 *      （1）@Override：限定重写父类方法，该注解只能用于方法
 *      （2）@Deprecated：用于表示某个程序元素（类、方法等）已过时
 *      （3）@SuppressWarnings：抑制编译器警告
 *
 * 2、自定义注解类型：public @interface MyAnnotation{}
 *
 * 3、对注解进行注解（4个）：元注解(用于对现有注解进行解释说明)
 *      （1）Retention: 只能用于修饰一个Annotation的定义，用于指定该Annotation可以保留的时间（生命周期）
 *              （1）@Retention(RetentionPolicy.SOURCE) ： 编译时抛弃（不考虑）被修饰的注解
 *              （2）@Retention(RetentionPolicy.CLASS) ： （默认）当编译时注解会被保留在.class文件中，但是运行时不会被保留
 *              （3）@Retention(RetentionPolicy.RUNTIME) ： 编译时注解会被保留在.class文件中，运行时也会被保留，所以可以通过反射机制获取
 *
 *      （2）Target: 用于修饰Annotation定义，用于指定被修饰的Annotation能用于修饰哪些程序元素
 *
 *      （3）Documented: 用于指定被该元注解修饰的Annotation类，将被javadoc工具提取成文档
 *              注意：定义为 @Documented 的注解必须设置 @Retention(RetentionPolicy.RUNTIME)
 *
 *      （4）Inherited: 被它修饰的Annotation将具有继承性，如果某个类使用了被 @Inherited 修饰的 Annotation，则其子类将会自动具有该Annotation
 *
 * 4、利用反射获取注解信息：
 *
 * 概念
 * 1、注解：代码中的特殊标记
 *      （1）注解可以在编译，类加载，运行时被读取，并执行相应的处理
 *      （2）通过使用Annotation可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息
 * 2、注解可以用修饰：包、类、构造器、方法、成员变量、参数、局部变量声明
 * 3、注解能被用来为程序元素（类，方法，成员变量等）设置元数据
 *
 *
 * JDK8 之中的注解新特性：
 * 1、可重复注解
 *      （1）在MyAnnotation上声明 @Repeatable 值为 MyAnnotations.class ：@Repeatable(MyAnnotations.class)
 *      （2）MyAnnotations 和 MyAnnotation 注解上声明的 @Retention 和 @Target 要保持一致
 * 2、类型注解
 *     元注解 @Target 的 参数类型 ElementType 枚举值多了两个
 *      （1）TYPE_PARAMETER：该注解能写在 类型变量的声明 语句中（如：泛型声明）
 *      （2）TYPE_USE：表示该注解能写在 使用类型的任何语句 中
 *
 */

//JDK8 之前 重复注解 的写法
@MyAnnotations({@MyAnnotation(value="hi"), @MyAnnotation(value="hello world")})
public class TestAnnotation
{
    private String name;
    private int age;

    public TestAnnotation() {
    }

    //JDK8 之中 重复注解 的写法
    @MyAnnotation
    @MyAnnotation(value="hi")
    @MyAnnotation(value="hello world")
    public TestAnnotation(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

//jdk8 中的 类型注解 的使用
class Generic<@MyAnnotation T>
{
    public void show() throws @MyAnnotation RuntimeException
    {
        @MyAnnotation TestAnnotation testAnnotation = new TestAnnotation();

        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int)10L;
    }

}


//自定义注解
@Inherited
@Repeatable(MyAnnotations.class) //JDK8.0 之中 设置可重复注解的方式
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.TYPE_PARAMETER, ElementType.TYPE_USE})
@interface MyAnnotation
{
    String value() default "hello"; //注解的成员
}

@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.FIELD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@interface MyAnnotations
{
    MyAnnotation[] value();
}