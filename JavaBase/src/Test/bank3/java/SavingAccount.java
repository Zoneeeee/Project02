package Test.bank3.java;

/**
 * @author sunjiacheng
 * @create 2019-10-11-15:53
 */
public class SavingAccount extends Account
{
    private double intersetRate; //利率

    public SavingAccount() {
    }

    public SavingAccount(double balance, double intersetRate) {
        super(balance);
        this.intersetRate = intersetRate;
    }

    public double getIntersetRate() {
        return intersetRate;
    }

    public void setIntersetRate(double intersetRate) {
        this.intersetRate = intersetRate;
    }
}
