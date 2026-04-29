/*
Problemset A solutions
a)
every account needs to store a name (String), current balance (float)
every account need to be aware of change of current balances(deposit, withdraw)

b)
Customer can:
1) check current balance : it needs to know that it has to output the value of
balance variable, and output that.
2) deposit money: it needs to know the amount to be deposited(inputted by the user)
and the amount to be added to previous balance and newer balance to be outputted on
the console
3) withdraw money: it needs to know the amount to be withdrawed(inputted by the user)
and the amount to be reduced from previous balance and newer balance to be outputted on
the console

c)
Memory Overflow

d)
the transaction limit will be added in the BankAccount class, where a variable
will keep track of daily changes until it hits the ceiling.Main should not know about
transaction limits, that's the account's own rule.

 */






public class Main {
    public static void main(String[] args) {
        BankAccount Tasauf = new BankAccount("Tasauf");
        BankAccount Abdullah = new BankAccount("Abdullah");
        BankAccount Sifat = new BankAccount("Sifat");


        Tasauf.deposit(1000);
        Tasauf.withdraw(200);
        Tasauf.withdraw(900);


        Abdullah.deposit(1000);
        Abdullah.withdraw(500);
        Abdullah.withdraw(1);

        Sifat.deposit(500);
        Sifat.withdraw(200);
        Sifat.withdraw(300);


        Tasauf.printStatement();
        Abdullah.printStatement();
        Sifat.printStatement();
    }
}

/*
Problemset C solutions:

a)BankAccount is a class, Alice and Bob are objects.
b)only Alice's balance changes. as we are accesing as alice.deposit(), not bob.deposit().
c)
      alice:
                name : "Alice"
                balance: 0
         bob:
                name : "Bob"
                balance : 0

d)it would update bob's balance. Bob's balance will be incremented by 100.
Because bob's pointer has been copied  into alice.
 */
