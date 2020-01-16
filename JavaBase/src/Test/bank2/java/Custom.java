package Test.bank2.java;

/**
 * @author sunjiacheng
 * @create 2019-10-09-12:03
 */
public class Custom
{
    private String firstName;
    private String lastName;
    private Account account;

    public Custom(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
