package Test.bank2.java;

/**
 * @author sunjiacheng
 * @create 2019-10-09-16:23
 */
public class Bank
{
    private Custom[] customers;
    private int numberOfCustomer;

    public Bank()
    {
        this.customers = new Custom[5];
        this.numberOfCustomer = 0;
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
