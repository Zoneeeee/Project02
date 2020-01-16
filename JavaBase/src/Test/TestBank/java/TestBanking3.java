package Test.TestBank.java;

import Test.bank3.java.*;

/**
 * @author sunjiacheng
 * @create 2019-10-11-16:07
 */
public class TestBanking3
{
    public static void main(String[] args)
    {
        Bank bank = new Bank();
        Custom customer;
        Account account;

        bank.addCustomer("Jane", "Smith");
        customer = bank.getCustoms(0);
        account = new SavingAccount(5000, 0.05);
        customer.addAccount(account);
        account = new SavingAccount(15000, 0.05);
        customer.addAccount(account);
        account = new CheckingAccount(15000, 1000);
        customer.addAccount(account);

        bank.addCustomer("Owen", "Bryant");
        customer = bank.getCustoms(1);
        account = new SavingAccount(500000, 0.05);
        customer.addAccount(account);
        account = new CheckingAccount(10000, 5000);
        customer.addAccount(account);


        bank.addCustomer("Tim", "Soley");
        customer = bank.getCustoms(2);
        account = new SavingAccount(25500, 0.05);
        customer.addAccount(account);
        account = new CheckingAccount(5000, 1500);
        customer.addAccount(account);

        bank.addCustomer("Maria", "Smith");
        customer = bank.getCustoms(3);
        customer.addAccount(bank.getCustoms(0).getAccounts(1)); //与 Jane Smith共享同一个账户
        customer.addAccount(bank.getCustoms(0).getAccounts(2));

        for (int i = 0; i < bank.getNumberOfCustomer(); i++)
        {
            customer = bank.getCustoms(i);
            for(int j = 0; j < customer.getNumberOfAccount(); j++)
            {
                account = customer.getAccounts(j);
                if(account instanceof SavingAccount)
                {
                    System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName() + "'s SavingAccount  " + "balance: " + account.getBalance() + "  " + "intersetRate: " + ((SavingAccount)account).getIntersetRate());
                }
                else if(account instanceof CheckingAccount)
                {
                    System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName() + "'s CheckingAccount  " + "balance: " + account.getBalance() + "  " + "overdraftProtection: " + ((CheckingAccount)account).getOverdraftProtection());
                }
            }
            System.out.println();
        }
    }
}
