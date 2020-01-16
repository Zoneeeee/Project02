package Test.TestBank.java;

import Test.bank4.java.*;

/**
 * @author sunjiacheng
 * @create 2019-10-14-14:10
 */
public class TestBanking4
{
    private Bank bank;

    public TestBanking4(Bank bank) {
        this.bank = bank;
    }

    public static Bank initBank()
    {
        Bank bank = new Bank();
        Custom customer;

        bank.addCustomer("Owen", "Bryant");
        customer = bank.getCustoms(0);
        customer.setSavingAccount(new SavingAccount(500.0, 0.05));
        customer.setCheckingAccount(new CheckingAccount(200.0, customer.getSavingAccount()));

        bank.addCustomer("Tim", "Soley");
        customer = bank.getCustoms(1);
        customer.setCheckingAccount(new CheckingAccount(500.0));

        return bank;
    }

    public void readBank(Bank bank)
    {
        Custom customer;
        for (int i = 0; i < bank.getNumberOfCustomer(); i++)
        {
            customer = bank.getCustoms(i);
            if(customer.getSavingAccount() != null && customer.getCheckingAccount() != null)
                System.out.println("Customer [" + customer.getFirstName() + " "+ customer.getLastName() + "]" + " has a checking balance of " + customer.getCheckingAccount().getBalance() + " and a savings balance of " + customer.getSavingAccount().getBalance());
            else if(customer.getSavingAccount() == null)
                System.out.println("Customer [" + customer.getFirstName() + " "+ customer.getLastName() + "]" + " has a checking balance of " + customer.getCheckingAccount().getBalance());
            else if(customer.getCheckingAccount() == null)
                System.out.println("Customer [" + customer.getFirstName() + " "+ customer.getLastName() + "]" + " has a savings balance of " + customer.getSavingAccount().getBalance());
            else
                System.out.println("Customer [" + customer.getFirstName() + " "+ customer.getLastName() + "]" + " not have account!");
        }
        System.out.println("");
    }

    public void withdrawTest(Bank bank, int i)
    {
        Account account;
        Custom customer = bank.getCustoms(i);
        if(customer.getCheckingAccount() != null)
        {
            account  = bank.getCustoms(i).getCheckingAccount();
            System.out.println("Checking Account [" + customer.getFirstName() + " " + customer.getLastName() + "] : withdraw 150.00 successful?" + account.withdraw(150.00));
        }
        else
            System.out.println("Checking Account [" + customer.getFirstName() + " " + customer.getLastName() + "] : not exist!");
        System.out.println("");
    }

    public void depositCheckingTest(Bank bank, int i)
    {
        Account account;
        Custom customer = bank.getCustoms(i);
        if(customer.getCheckingAccount() != null)
        {
            account  = bank.getCustoms(i).getCheckingAccount();
            System.out.println("Checking Account [" + customer.getFirstName() + " " + customer.getLastName() + "] : deposit 50.00 successful?" + account.deposit(50.00));
        }
        else
            System.out.println("Checking Account [" + customer.getFirstName() + " " + customer.getLastName() + "] : not exist!");
        System.out.println("");
    }

    public void depositSavingTest(Bank bank, int i)
    {
        Account account;
        Custom customer = bank.getCustoms(i);
        if(customer.getSavingAccount() != null)
        {
            account  = bank.getCustoms(i).getSavingAccount();
            System.out.println("Saving Account [" + customer.getFirstName() + " " + customer.getLastName() + "] : deposit 50.00 successful?" + account.deposit(50.00));
        }
        else
            System.out.println("Saving Account [" + customer.getFirstName() + " " + customer.getLastName() + "] : not exist!");
        System.out.println("");
    }

    public static void main(String[] args)
    {
        Bank bank = TestBanking4.initBank();
        TestBanking4 t4 = new TestBanking4(bank);

        t4.readBank(bank);

        t4.withdrawTest(bank, 0);
        t4.depositCheckingTest(bank, 0);
        t4.depositSavingTest(bank, 0);

        t4.withdrawTest(bank, 1);
        t4.depositCheckingTest(bank, 1);
        t4.depositSavingTest(bank, 1);

        t4.readBank(bank);
    }
}
