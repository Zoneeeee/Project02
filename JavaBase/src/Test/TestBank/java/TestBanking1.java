package Test.TestBank.java;

import Test.bank1.java.Account;
import Test.bank1.java.Custom;

/**
 * @author sunjiacheng
 * @create 2019-10-09-12:09
 */
public class TestBanking1
{
    public static void main(String[] args)
    {
        Custom custom;
        Account account;

        custom = new Custom("Jane ", "Smith");
        System.out.println("Creating the customer Jane Smith.");

        account = new Account(500.00);
        custom.setAccount(account);
        account = custom.getAccount();
        System.out.println("Creating an account with a 500.00 balance.");

        custom.getAccount().withdraw(150.00);
        System.out.println("WithDraw 150.00");

        custom.getAccount().deposit(22.50);
        System.out.println("Deposit 22.50");

        custom.getAccount().withdraw(47.62);
        System.out.println("WithDraw 47.62");

        custom.getAccount().withdraw(500.00);
        System.out.println("WithDraw 500.00");

        System.out.println(custom.getFirstName() + custom.getLastName() + "'s account has a balance of " + custom.getAccount().getBalance());
    }
}
