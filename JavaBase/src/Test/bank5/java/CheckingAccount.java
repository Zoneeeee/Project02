package Test.bank5.java;

/**
 * @author sunjiacheng
 * @create 2019-10-11-15:57
 */
public class CheckingAccount extends Account
{
    private double overdraftProtection; //透支额度

    public CheckingAccount() {
    }

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, double overdraftProtection) {
        super(balance);
        this.overdraftProtection = overdraftProtection;
    }

    public double getOverdraftProtection() {
        return overdraftProtection;
    }

    public void setOverdraftProtection(double overdraftProtection) {
        this.overdraftProtection = overdraftProtection;
    }

    @Override
    public boolean withdraw(double amount) {
        if(super.balance >= amount)
        {
            super.balance -= amount;
            return true;
        }
        else if(this.overdraftProtection >= (amount - super.balance))
        {
            this.overdraftProtection -= (amount - super.balance);
            super.balance = 0;
            return true;
        }
        else
        {
            System.out.println("超出透支额度！");
            return false;
        }
    }
}
