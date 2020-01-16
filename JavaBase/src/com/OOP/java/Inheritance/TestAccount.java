package com.OOP.java.Inheritance;

/**
 * @author sunjiacheng
 * @create 2019-10-11-10:52
 */
public class TestAccount
{
    public static void main(String[] args)
    {
        Account acct = new Account(1122, 20000, 0.045);

        acct.withdraw(30000);
        System.out.println("当前余额：" + acct.getBalance());

        acct.withdraw(2500);
        acct.deposit(3000);
        System.out.println("当前余额：" + acct.getBalance());
        System.out.println("月利率：" + acct.getMonthlyInterest());

        CheckAccount ca = new CheckAccount(1001, 20000, 0.045, 5000);
        ca.deposit(5000);
        System.out.println("当前余额：" + ca.getBalance());
        System.out.println("透支额度：" + ca.getOverdraft());
        ca.deposit(18000);
        System.out.println("当前余额：" + ca.getBalance());
        System.out.println("透支额度：" + ca.getOverdraft());
    }
}
