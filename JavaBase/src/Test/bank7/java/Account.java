package Test.bank7.java;

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
    public void withdraw(double amt) throws OverDraftException {
        if(balance >= amt) {
            balance -= amt;
        }
        else {
            //System.out.println("余额不足！");
            throw new OverDraftException("资金不足", (amt-balance));
        }
    }
}