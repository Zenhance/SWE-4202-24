//a. Every account needs to store two information:
//i) name of bank account owner (String)
//ii) balance of account (double)

//b. The three actions are:
//1. deposit(double amount)
//Input: amount(double)
//Output: balance increase
//2. withdraw(double)
//Input: amount(double)
//Output: balance decrease if the amount is sufficient
//3. printStatement()
//Input: none
//Output: print the name of the owner of the bank account and balance of that account
//
//c. Following problems can arise if we use to store the data of 200 customers using array:
//i) Data can be mismatched
//ii) Hard to maintain all data
//iii) While using arrays, the functions are independent. They are not dependent on other functions. So, there will be no proper connection between owner and balance.
//iv) Since we need to rely on the index of each data, it is also error-prone
//
//d. If the bank wants to add transaction limit per day, then we need to create something inside the class(BankAccount).
// Because the rules related to behaviour of the account remain inside the class. It ensures no data mismatch and maintainability is improved.

class BankAccount
{
    private String name;
    private double balance;
    public BankAccount(String name)
    {
        this.name = name;
        this.balance = 0;
    }
    public void deposit(double amount)
    {
        if (amount <= 0)
        {
            System.out.println("Error!");
        }
        balance= balance + amount;
    }
    public void withdraw(double amount)
    {
        if (balance - amount <= 0)
        {
            System.out.println("Insufficient Funds");
        }
        else
        {
            balance = balance - amount;
        }
    }
    public void printStatement()
    {
        System.out.println("Owner : "+name);
        System.out.println("Balance : "+balance);
    }
}
public class Main
{
    public static void main(String[] args)
    {
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount charlie = new BankAccount("Charlie");

        alice.deposit(500);
        alice.withdraw(300);

        bob.deposit(1000);
        bob.withdraw(500);

        charlie.deposit(1500);
        charlie.withdraw(700);

        alice.printStatement();
        bob.printStatement();
        charlie.printStatement();
    }
}
//a. BankAccount is class while alice and bob are object.
//
//b. Alice's balance changes. Because the method alice.deposit is called for the object alice.
//
//c. After the both line runs:
//  alice-> [name="Alice" , balance=500]
//  bob-> [name="Bob" , balance=0]
//
//d. If we write 'alice=bob' then both refer to the same object.
// alice.deposit(100) will increase Bob's balance.