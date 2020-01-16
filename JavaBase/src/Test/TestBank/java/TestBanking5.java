package Test.TestBank.java;

import Test.bank5.java.*;

/**
 * @author sunjiacheng
 * @create 2019-10-15-11:24
 */
public class TestBanking5
{
    public static void main(String[] args)
    {
        Bank bank = Bank.getBank();
        Custom customer;
        CustomerReport report = new CustomerReport();

        bank.addCustomer("Jane", "Smith");
        customer = bank.getCustoms(0);
        customer.addAccount(new SavingAccount(5000, 0.05));
        customer.addAccount(new SavingAccount(15000, 0.05));
        customer.addAccount(new CheckingAccount(2000, 1000));

        bank.addCustomer("Owen", "Bryant");
        customer = bank.getCustoms(1);
        customer.addAccount(new SavingAccount(500000, 0.05));
        customer.addAccount(new CheckingAccount(10000, 5000));

        bank.addCustomer("Tim", "Soley");
        customer = bank.getCustoms(2);
        customer.addAccount(new SavingAccount(25500, 0.05));
        customer.addAccount(new CheckingAccount(5000, 1500));

        bank.addCustomer("Maria", "Smith");
        customer = bank.getCustoms(3);
        customer.addAccount(bank.getCustoms(0).getAccounts(0)); //与 Jane Smith共享同一个账户
        customer.addAccount(bank.getCustoms(0).getAccounts(1));
        customer.addAccount(bank.getCustoms(0).getAccounts(2));

        report.generateReport();
    }
}
