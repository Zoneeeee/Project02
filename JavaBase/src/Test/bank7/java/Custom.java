package Test.bank7.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sunjiacheng
 * @create 2019-10-09-12:03
 */
public class Custom
{
    private String firstName;
    private String lastName;
    private List<Account> accounts;

    public Custom(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accounts = new ArrayList<Account>();
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Account getAccount(int index) { return accounts.get(index); }

    public Iterator<Account> getAccounts(){
        return accounts.iterator();
    }

    public int getNumberOfAccount() { return accounts.size(); }

    public void addAccount(Account account)
    {
        accounts.add(account);
    }

}
