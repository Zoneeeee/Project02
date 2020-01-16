package Test.bank7.java;

import java.util.Iterator;

/**
 * @author sunjiacheng
 * @create 2019-10-15-11:50
 */
public class CustomerReport
{
    public void generateReport()
    {
        Custom customer;
        Bank bank = Bank.getBank();

        System.out.println("\t\t\tCUSTOMERS REPORT");
        System.out.println("\t\t\t================");

        Iterator<Custom> it_customers = bank.getCustomers();
        while(it_customers.hasNext())
        {
            customer = it_customers.next();

            System.out.println();
            System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName());

            Iterator<Account> it_accounts = customer.getAccounts();
            while(it_accounts.hasNext())
            {
                Account account = it_accounts.next();
                String account_type = "";
                if(account instanceof SavingAccount){
                    account_type = "SavingAccount";
                    System.out.println(account_type + ": current balance is " + account.getBalance());
                }
                if(account instanceof CheckingAccount){
                    account_type = "CheckingAccount";
                    System.out.println(account_type + ": current balance is " + account.getBalance());
                }
            }
        }
    }
}
