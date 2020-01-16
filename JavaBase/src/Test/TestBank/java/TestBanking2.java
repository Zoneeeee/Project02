package Test.TestBank.java;

import Test.bank2.java.Bank;
import Test.bank2.java.Custom;

/**
 * @author sunjiacheng
 * @create 2019-10-09-16:36
 */
public class TestBanking2
{public static void main(String[] args)
{
    Bank bank = new Bank();

    bank.addCustomer("Jane", "Smith");
    bank.addCustomer("Owen", "Bryant");
    bank.addCustomer("Tim", "Soley");
    bank.addCustomer("Mike", "jorden");
    bank.addCustomer("Maria", "Smith");

    for(int i = 0; i < bank.getNumberOfCustomer(); i++)
    {
        Custom customer = bank.getCustoms(i);
        System.out.println("Customer [" + (i + 1) + "] is " + customer.getFirstName() + " " + customer.getLastName());
    }
}

}
