public class BankAccount {
    /* Part A.The information every account need to store
         1.Owner's Name using String
         2.Owner's  Current Balance using double
         3.Account ID using integer


        b.Actions that have to perform:
         1.Deposit money(input), for this nothing needs to know. And it works as current balance and add balance (change) which will be added in the current balance
         2.Withdraw money ( input), for this have to check the current balance and deduct balance from main balance ( change). Yhe withdrawal money can't be bigger amount than the main balance otherwise it will give errors.
         3. Check Balance (output) and print the current balance.

         C. In handling 200 customers using just two arrays it will be difficult to manage and keep track of their names and balances. using class helps to combined and store the names and balance in order.
         and also it will create Error prone whenever changing or remove any customer's details.
         D.I would add the transaction limit in the BankAccount class so that it doesn't hamper other customer's transaction limit as it gives unique for every individual automatically.And if I use this in main I have to rewrite the limit logic every time.


     */

    String ownerName;
    double balance;

    public BankAccount(String accountName) {
        this.ownerName = accountName;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error");
        } else {
            balance += amount;
        }
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient balance");
        }

    }
    public void printStatement() {
            System.out.println("Owner's Name: +ownerName");
            System.out.println("Current Balance: + balance");

        }

    }
