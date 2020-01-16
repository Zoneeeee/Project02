package Test.TestBank.java;

import Test.bank7.java.*;

/**
 * @author sunjiacheng
 * @create 2019-10-30-15:02
 */
public class TestBanking7
{
    public static void main(String[] args) {
        Bank bank = Bank.getBank();
        Custom customer;
        Account account;

        bank.addCustomer("Jane", "Smith");
        customer = bank.getCustom(0);
        customer.addAccount(new SavingAccount(5000, 0.05));
        customer.addAccount(new SavingAccount(15000, 0.05));
        customer.addAccount(new CheckingAccount(2000, null));

        bank.addCustomer("Owen", "Bryant");
        customer = bank.getCustom(1);
        customer.addAccount(new SavingAccount(500000, 0.05));
        customer.addAccount(new CheckingAccount(10000, 5000.0));

        account = bank.getCustom(0).getAccount(2);
        System.out.println("Customer: " + bank.getCustom(0).getFirstName() + " " + bank.getCustom(0).getLastName() + "  " + "has a checking balance of " + account.getBalance());
        try {
            account.withdraw(11260.00);
        } catch (OverDraftException e) {
            System.out.println("Exception:" + e.getMessage() + "   Deficit: " + e.getDeficit());
        } finally {
            System.out.println("Customer: " + bank.getCustom(0).getFirstName() + " " + bank.getCustom(0).getLastName() + "  " + "has a checking balance of " + account.getBalance());
        }

        account = bank.getCustom(1).getAccount(1);
        System.out.println("Customer: " + bank.getCustom(1).getFirstName() + " " + bank.getCustom(1).getLastName() + "  " + "has a checking balance of " + account.getBalance());
        try {
            account.withdraw(20000);
        } catch (OverDraftException e) {
            System.out.println("Exception:" + e.getMessage() + "   Deficit: " + e.getDeficit());
        } finally {
            System.out.println("Customer: " + bank.getCustom(1).getFirstName() + " " + bank.getCustom(1).getLastName() + "  " + "has a checking balance of " + account.getBalance());
        }

        System.out.println();

        CustomerReport customerReport = new CustomerReport();
        customerReport.generateReport();
    }
}
