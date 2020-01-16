package com.OOP.java.Inheritance;

/**
 * @author sunjiacheng
 * @create 2019-10-10-13:51
 */
public class Kids extends ManKind
{
    private int yearsOld;

    public int getYearsOld() {
        return yearsOld;
    }

    public void setYearsOld(int yearsOld) {
        this.yearsOld = yearsOld;
    }

    public void printAge()
    {
        System.out.println(this.yearsOld + " years old");
    }

    public void employees()
    {
        System.out.println("小孩不能上班");
    }
}
