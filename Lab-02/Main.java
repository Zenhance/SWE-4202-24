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

/*
a) Bank account - class
   Alice and bob - objects

b) It updates alice's balance and not bob's balance
 because we are calling the deposit method on alice's object through 
 alice.<method> .
Therefore, it can update alice's balance but not bob's balance.

c) Alice: 
        name : "Alice"
        balance : 1000
    Bob:
        name : "Bob"
        balance : 0

d) It would update bob's balance . Bob's balance would be incremented
by 100 because bob's pointer value has been copied into alice.


 */
