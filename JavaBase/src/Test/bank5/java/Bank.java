package Test.bank5.java;

/**
 * @author sunjiacheng
 * @create 2019-10-09-16:23
 */

//将Bank类设计为单例模式
public class Bank
{
    private Custom[] customers;
    private int numberOfCustomer;

    private Bank()
    {
        this.customers = new Custom[5];
        this.numberOfCustomer = 0;
    }
    private static Bank bank = new Bank();

    public static Bank getBank() {
        return bank;
    }

    public void addCustomer(String firstName, String lastName)
    {
        Custom custom = new Custom(firstName, lastName);
        customers[numberOfCustomer] = custom;
        numberOfCustomer++;
    }

    public Custom getCustoms(int index) {
        return customers[index];
    }

    public int getNumberOfCustomer() {
        return numberOfCustomer;
    }
}
