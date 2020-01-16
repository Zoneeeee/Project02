package com.OOP.java.Inheritance;

/**
 * @author sunjiacheng
 * @create 2019-10-10-16:44
 */
public class Student extends Person
{
    private String schoolName;
    int id = 1002;

    //子类在创建对象时，会默认调用父类的无参构造器，为父类属性进行初始化
    public Student() {
        super();  //默认会调用，可以不写
    }

    public Student(String schoolName) {
        super("李雷", 23);
        this.schoolName = schoolName;
    }

    public Student(String name, int age, String schoolName) {
        super(name, age);
        this.schoolName = schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    //当子类和父类中的属性出现重名的情况时
    //使用 this.id 代表使用子类的属性（默认情况下，也是使用子类的属性）
    //使用 super.id 代表使用父类的属性
    public void show()
    {
        System.out.println("this.id :" + this.id);
        System.out.println("super.id :" + super.id);
    }

    public void eat()
    {
        System.out.println("Student eating");
    }

    public void info()
    {
        this.eat();
        super.eat();
    }

}

