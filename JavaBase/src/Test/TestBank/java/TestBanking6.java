package Test.TestBank.java;

import Test.bank6.java.*;

/**
 * @author sunjiacheng
 * @create 2019-10-18-14:44
 */
public class TestBanking6
{
    public static void main(String[] args)
    {
        Bank bank = Bank.getBank();
        Custom customer;
        Account account;

        bank.addCustomer("Jane", "Smith");
        customer = bank.getCustoms(0);
        customer.addAccount(new SavingAccount(5000, 0.05));
        customer.addAccount(new SavingAccount(15000, 0.05));
        customer.addAccount(new CheckingAccount(2000, null));

        bank.addCustomer("Owen", "Bryant");
        customer = bank.getCustoms(1);
        customer.addAccount(new SavingAccount(500000, 0.05));
        customer.addAccount(new CheckingAccount(10000, 5000.0));

        account = bank.getCustoms(0).getAccounts(2);
        System.out.println("Customer: " + bank.getCustoms(0).getFirstName() + " " + bank.getCustoms(0).getLastName() + "  " + "has a checking balance of " + account.getBalance());
        try {
            account.withdraw(11260.00);
        } catch (OverDraftException e) {
            System.out.println("Exception:" + e.getMessage() + "   Deficit: " + e.getDeficit());
        } finally {
            System.out.println("Customer: " + bank.getCustoms(0).getFirstName() + " " + bank.getCustoms(0).getLastName() + "  " + "has a checking balance of " + account.getBalance());
        }

        account = bank.getCustoms(1).getAccounts(1);
        System.out.println("Customer: " + bank.getCustoms(1).getFirstName() + " " + bank.getCustoms(1).getLastName() + "  " + "has a checking balance of " + account.getBalance());
        try {
            account.withdraw(20000);
        } catch (OverDraftException e) {
            System.out.println("Exception:" + e.getMessage() + "   Deficit: " + e.getDeficit());
        } finally {
            System.out.println("Customer: " + bank.getCustoms(1).getFirstName() + " " + bank.getCustoms(1).getLastName() + "  " + "has a checking balance of " + account.getBalance());
        }


    }
}
