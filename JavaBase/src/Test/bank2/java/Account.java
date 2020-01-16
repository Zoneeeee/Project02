package Test.bank2.java;

/**
 * @author sunjiacheng
 * @create 2019-10-09-11:40
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

    //存款
    public void withdraw(double amount)
    {
        this.balance += amount;
    }

    //取款
    public boolean deposit(double amount)
    {
        if(this.balance >= amount)
        {
            this.balance -= amount;
            return true;
        }
        else
        {
            System.out.println("余额不足！");
            return false;
        }
    }
}


