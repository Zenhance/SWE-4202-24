// Answer of part-A:
//-----------------
/*
a. Every account needs to store 2 information.
    1. Name. Type - String
    2. Current Balance. Type - double
b. Three actions a customer can perform.
    1. Deposit money:
        - Needs to know (input): The amount of deposit
        - What it produces (output): The total balance after deposit
    2. Withdraw money:
        - Needs to know (input): The amount of withdrawal
        - What it produces (output): Checks if the balance is sufficient for withdrawal. If the balance is insufficient or zero then shows an error; and if the balance is sufficient then shows total balance after withdrawal.
    3. Check balance:
        - Needs to know (input): Name
        - What it produces (output): Balance
c. If all account balances are stored in a big array, then we need to carefully match the index for each customers, making it harder to manage.
d. If the bank later wants to add a transaction limit per day, then I would add that inside the BankAccount class, not inside 'main'. Because the code would be more cleaner and easier to manage if I write code in this way.
*/
public class BankAccount{
    private String owner_name;
    private double balance;

    public BankAccount(String owner_name){
        this.owner_name = owner_name;
        this.balance = 0;
    }
    public void deposit(double amount){
        if (balance <= 0) { // checking if the deposit amount is entered correctly
            System.out.println("Error. Please enter a positive number.");
        }
        else {
            balance += amount;
        }
    }
    public void withdraw(double amount){
        if (balance - amount < 0) // checking if the amount is sufficient for withdrawal
        {
            System.out.println("Insufficient funds");
        }
        else {
            balance -= amount;
        }
    }
    public void printStatement(){
        System.out.println("Owner: " + owner_name);
        System.out.println("Balance: " + balance);
    }
    static void main(String[] args){
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount john = new BankAccount("John");

        alice.deposit(1000);
        alice.withdraw(300);

        bob.deposit(1500);
        bob.withdraw(500);

        john.deposit(1250);
        john.withdraw(250);

        alice.printStatement();
        bob.printStatement();
        john.printStatement();
    }
}

