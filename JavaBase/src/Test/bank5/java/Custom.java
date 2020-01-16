package Test.bank5.java;

/**
 * @author sunjiacheng
 * @create 2019-10-09-12:03
 */
public class Custom
{
    private String firstName;
    private String lastName;
    private Account[] accounts;
    private int numberOfAccount = 0;

    public Custom(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        accounts = new Account[5];
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccounts(int index) { return accounts[index]; }

    public int getNumberOfAccount() { return numberOfAccount; }

    public void addAccount(Account account)
    {
        accounts[numberOfAccount] = account;
        numberOfAccount++;
    }

}
