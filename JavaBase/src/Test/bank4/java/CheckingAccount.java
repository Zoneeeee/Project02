package Test.bank4.java;

/**
 * @author sunjiacheng
 * @create 2019-10-11-15:57
 */
public class CheckingAccount extends Account
{
    private SavingAccount protectionBy; //透支额度

    public CheckingAccount() {
    }

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, SavingAccount protectionBy) {
        super(balance);
        this.protectionBy = protectionBy;
    }

    public SavingAccount getProtectionBy() {
        return protectionBy;
    }

    public void setProtectionBy(SavingAccount protectionBy) {
        this.protectionBy = protectionBy;
    }

    @Override
    public boolean withdraw(double amount) {
        if(super.balance >= amount)
        {
            super.balance -= amount;
            return true;
        }
        else if(this.protectionBy.getBalance() >= (amount - super.balance))
        {
            this.protectionBy.withdraw(amount - super.balance);
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
