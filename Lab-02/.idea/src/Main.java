/*Part A

a.Every account needs to store: Owner's Name(string),Balance(double)
b.A customer can 1. Deposit money
                 2. Withdraw money
                 3. Check current balance
c.Problwm with storing balances in one big array in main is
with 200 customers i'd need 200 separate variables which is very hard to maintain
and keep track.
d.I'd add that feature as a method in BankAccount not in main
 because it belongs to each account individually.



 */

//Part B

public class Main {

    public static void main(String[] args) {

        BankAccount acc1 = new BankAccount("Nijhum");
        BankAccount acc2 = new BankAccount("Megha");
        BankAccount acc3 = new BankAccount("Medha");

        acc1.Deposit(10000.0);
        acc1.Withdraw(2000.0);

        acc2.Deposit(20000.0);
        acc2.Withdraw(5600.0);

        acc3.Deposit(60000.0);
        acc3.Withdraw(2000.0);

        acc1.PrintBalance();
        acc2.PrintBalance();
        acc3.PrintBalance();

    }
}

/*Part C

a. Here BankAccount is a class and alice and bob are objects.
b. Alice's.By doing alice.deposit(500); method is called
and this is how the program know which one to update
c.  Memory Diagram After both line runs:
     alice                 bob
     ownerName= "Alice"    ownerName= "bob"
     balance=0.0           balance=0.0
d.If i write alice=bob; and then called alice.deposit(100);
bob's balance would be the same as alice's which is 100
because by writing alice=bob i assigned bob to alice
so now both of them pointing to the same object.

 */