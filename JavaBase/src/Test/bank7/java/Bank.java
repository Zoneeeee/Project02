package Test.bank7.java;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author sunjiacheng
 * @create 2019-10-09-16:23
 */

//将Bank类设计为单例模式
public class Bank
{
    private List<Custom> customers;

    private Bank()
    {
        this.customers = new ArrayList<Custom>();
    }
    private static Bank bank = new Bank();

    public static Bank getBank() {
        return bank;
    }

    public void addCustomer(String firstName, String lastName)
    {
        Custom custom = new Custom(firstName, lastName);
        this.customers.add(custom);
    }

    public Custom getCustom(int index) {
        return customers.get(index);
    }

    public Iterator<Custom> getCustomers(){
        return customers.iterator();
    }

    public int getNumberOfCustomer() {
        return customers.size();
    }
}
