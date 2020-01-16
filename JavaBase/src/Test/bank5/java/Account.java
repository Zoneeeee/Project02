package Test.bank5.java;

/**
 * @author sunjiacheng
 * @create 2019-10-11-15:51
 */
public class Account
{
    protected double balance;

    public Account() {

    }

    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    //存钱
    public boolean deposit(double amt)
    {
        balance += amt;
        return true;
    }
    //取钱
    public boolean withdraw(double amt)
    {
        if(balance >= amt)
        {
            balance -= amt;
            return true;
        }
        else
        {
            System.out.println("余额不足！");
            return false;
        }
    }
}