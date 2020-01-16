package com.OOP.java.Inheritance;

/**
 * @author sunjiacheng
 * @create 2019-10-11-10:44
 */
public class Account
{
    private int id;
    protected double balance;
    private double annualInterestRate;

    public Account()
    {

    }

    public Account(int id, double balance, double annualInterestRate) {
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    //返回月利率
    public double getMonthlyInterest()
    {
        return this.annualInterestRate/12;
    }

    //存款
    public void withdraw(double amount)
    {
        this.balance += amount;
    }

    //取款
    public void deposit(double amount)
    {
        if(this.balance >= amount)
            this.balance -= amount;
        else
            System.out.println("余额不足！");
    }
}
