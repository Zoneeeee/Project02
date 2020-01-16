package com.OOP.java.Inheritance;

/**
 * @author sunjiacheng
 * @create 2019-10-11-10:58
 */
public class CheckAccount extends Account
{
    private double overdraft; //可透支额度

    public CheckAccount() {
    }

    public CheckAccount(int id, double balance, double annualInterestRate, double overdraft) {
        super(id, balance, annualInterestRate);
        this.overdraft = overdraft;
    }

    public double getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(double overdraft) {
        this.overdraft = overdraft;
    }

    @Override
    public void deposit(double amount) {
        if(super.balance >= amount)
            super.balance -= amount;
        else if(this.overdraft >= (amount - super.balance))
        {
            this.overdraft -= (amount - super.balance);
            super.balance = 0;
        }
        else
            System.out.println("超出透支额度！");
    }
}
