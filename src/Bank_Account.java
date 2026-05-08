/*
 Part A — Design before you code

 a.Owner’s name: String
      Current balance: double

 b.deposit(amount): input = double amount, change = balance += amount (if >0)
   withdraw(amount): input = double amount, change = balance -= amount (if enough money)
   printStatement(): input = none, output = prints owner name and balance

 c.Regarding the suggestion to use large arrays in the Main class (similar to Lab 1 Task 1):
  managing these arrays for 200 customers would be extremely difficult.
  It would lead to index mismatches,make adding new fields problematic,
  and result in messy, error-prone code

 d.To add a daily transaction limit, you shouldn't put it in the Main class;
   instead, it should be added within the BankAccount class using a private field and methods.
   This is because each account should manage its own data and rules, which is the core principle
   of encapsulation.
 */

class BankAccount {

    private String ownerName;
    private double balance;

    public BankAccount(String name) {
        this.ownerName = name;
        this.balance = 0.0;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Error");
            return;
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
            return;
        }
        balance -= amount;
    }

    public void printStatement() {
        System.out.println("Owner: " + ownerName + " | Balance: " + balance);
    }
}