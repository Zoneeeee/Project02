package Test.bank1.java;

/**
 * @author sunjiacheng
 * @create 2019-10-09-11:40
 */
public class Account
{
    private double balance;

    public Account(double init_balance)
    {
        this.balance = init_balance;
    }
    public double getBalance() {
        return balance;
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


