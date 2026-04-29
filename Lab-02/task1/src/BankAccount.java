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
the transaction limit will be added at the start of the main function, where a variable
will keep track of daily changes until it hits the ceiling.

 */




public class BankAccount {
    private String name;
    private float balance;

    public BankAccount(String name) {
        this.name = name;
        this.balance = 0.0f;
    }

    public void deposit(float amount) {
        if (amount <= 0) {
            System.out.println("Error\n");
        } else {
            balance = amount + balance;
        }


    }

    public void withdraw(float amount) {
        if (amount > balance) {
            System.out.println("Insufficient Balance\n");
        } else {
            balance = balance - amount;
        }
    }

    public void printStatement() {
        System.out.println("Name: " + name);
        System.out.println("Balance: " + balance);
    }
}





