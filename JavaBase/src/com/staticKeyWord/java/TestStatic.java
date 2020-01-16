package com.staticKeyWord.java;

/**
 * @author sunjiacheng
 * @create 2019-10-14-16:34
 */

/**
 * static关键字：可用来修饰属性、方法、代码块（或初始化块）、内部类
 *
 * static修饰属性：
 * 1、由类创建的所有对象，都公用这一个属性
 * 2、当其中一个对象对此属性进行修改，会导致其他对象对此属性的一个调用（一个修改，所有都变）
 * 3、类中的static属性变量，随着类的加载而形成的，放在内存的静态区中，独一份
 * 4、静态属性和静态方法可以直接通过类名来调用
 * 5、类中的静态成员加载是要早于对象的，所以类对象在没有创建时，也可以通过类名调用
 *
 * static修饰方法
 * 6、static修饰方法，也是随着类的加载而加载，在内存中也是独一份
 * 7、可以直接通过类名调用
 * 8、静态的方法内部可以调用静态的属性和方法，但是不能调用非静态的属性和方法
 * 9、非静态的方法内部也可以调用静态的属性和方法
 *
 * 注：静态的结构的生命周期要早于非静态结构，被回收也晚于非静态结构
 */


public class TestStatic
{
    public static void main(String[] args)
    {
        SportMan s1 = new SportMan("金龙", 23);
        SportMan s2 = new SportMan("银龙", 21);
        s1.name = "花龙";
        s1.nation = "中国";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(SportMan.nation);

        s1.show1();
        SportMan.show();
        s1.show();
    }
}

class SportMan
{
    String name;
    int age;
    static String nation;

    public SportMan(String name, int age) {
        this.name = name;
        this.age = age;
        nation = "China";
    }

    @Override
    public String toString() {
        return "SportMan{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void show1()
    {
        System.out.println("age:" + this.age);
        System.out.println("nation:"+ nation);
        info();
        System.out.println("I am a sporter,I come from China!");
    }

    public static void show()
    {
        System.out.println("nation:" + nation);
        info();
        System.out.println("I am a sporter,I come from China!");
    }

    public static void info()
    {
        System.out.println("I am a static function!");
    }
}