/*
a) string - account name , int - account balance , string - credit history.

b) deposit(amount) - updates balance, withdraw(amount)
 - updates balance (produce error if withdraw amount is greater than balance),
  checkbalance (shows balance)

c) 200 customers - difficult to manage account with all the steps of updating balance

d) Adding the transaction limit in the BankAccount class so that 
each user can have unique set of account records 
and the transaction limit only affects the set user.
 */

public class Main {

    public static void main(String[] args) {

        BankAccount n1 = new BankAccount("n1");
        BankAccount n2 = new BankAccount("n2");
        BankAccount n3 = new BankAccount("n3");

        n1.deposit(1000);
        n1.withdraw(500);
        n1.printBalance();

        n2.withdraw(6500);
        n2.printBalance();

        n3.deposit(-500);
        n3.printBalance();

        // Checking the provided problem statement.

        n1 = n3;

        n3.printBalance();

        n3.withdraw(140);

        n3.printBalance();

    }
}
