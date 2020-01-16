package com.OOP.java.Inheritance;

/**
 * @author sunjiacheng
 * @create 2019-10-10-11:46
 */
public class ManKind
{
    private int sex;
    private int salary;

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void manOrWoman()
    {
        if(sex == 1)
        {
            System.out.println("Man");
        }
        else if(sex == 0)
        {
            System.out.println("Woman");
        }
        else
        {
            System.out.println("error");
        }
    }

    public void employees()
    {
        if(this.salary == 0)
        {
            System.out.println("No job");
        }
        else if(this.salary > 0)
        {
            System.out.println("job");
        }
    }
}
