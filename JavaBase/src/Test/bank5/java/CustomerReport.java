package Test.bank5.java;

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

        for(int cust_idx = 0; cust_idx < bank.getNumberOfCustomer(); cust_idx++)
        {
            customer = bank.getCustoms(cust_idx);

            System.out.println();
            System.out.println("Customer: " + customer.getFirstName() + " " + customer.getLastName());

            for(int acct_idx = 0; acct_idx < customer.getNumberOfAccount(); acct_idx++)
            {
                Account account = customer.getAccounts(acct_idx);
                String account_type = "";
                if(account instanceof SavingAccount)
                    account_type = "SavingAccount";
                if(account instanceof CheckingAccount)
                    account_type = "CheckingAccount";
                System.out.println(account_type + ": current balance is " + account.getBalance());
            }
        }
    }
}
