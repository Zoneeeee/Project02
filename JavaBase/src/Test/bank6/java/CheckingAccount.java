package Test.bank6.java;

/**
 * @author sunjiacheng
 * @create 2019-10-11-15:57
 */
public class CheckingAccount extends Account
{
    private Double overdraftProtection; //透支额度

    public CheckingAccount() {
    }

    public CheckingAccount(double balance) {
        super(balance);
    }

    public CheckingAccount(double balance, Double overdraftProtection) {
        super(balance);
        this.overdraftProtection = overdraftProtection;
    }

    public Double getOverdraftProtection() {
        return overdraftProtection;
    }

    public void setOverdraftProtection(double overdraftProtection) {
        this.overdraftProtection = overdraftProtection;
    }

    @Override
    public void withdraw(double amount) throws OverDraftException {
        if(balance >= amount) {
            balance -= amount;
        }
        else {
            if(this.overdraftProtection == null) {
                throw new OverDraftException("no overDraft exception", (amount-balance));
            }
            else if(this.overdraftProtection >= (amount - balance)) {
                this.overdraftProtection -= (amount - balance);
                super.balance = 0;
            }
            else {
                throw new OverDraftException("insufficient funds for overdraft protection", (amount-balance-overdraftProtection));
            }
        }


    }
}
