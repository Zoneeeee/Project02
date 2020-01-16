package Test.TestBank.java;

import Test.bank1.java.Account;

/**
 * @author sunjiacheng
 * @create 2019-10-09-11:51
 */
public class TestBanking
{
    public static void main(String[] args)
    {
        Account account;

        account = new Account(500.00);
        System.out.println("Creating an account with a 500.00 balance.");

        account.withdraw(150.00);
        System.out.println("WithDraw 150.00");

        account.deposit(22.50);
        System.out.println("Deposit 22.50");

        account.withdraw(47.62);
        System.out.println("WithDraw 47.62");

        System.out.println("The account has a balance of " + account.getBalance());
    }
}
