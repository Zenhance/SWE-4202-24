/* Part A
(a) Every account needs to have two things/ attributes.
1. Name (string), 2. Account Number (int) 3.Balance (float)

(b) Customers can perform 3 things. deposit, withdraw & check.
deposit --> input of amount, Adds amount to balance
withdraw --> input of amount, reduces amount from balance
check --> output of balance
(c) If we use array in the main then we need to use 200 different arrays.
(d) We will do it in a different class which will check the amount and returns a flag value. */

public class BankAccount {
    private String name;
    private double balance;

    public BankAccount(String name) {
        this.name = name;
        this.balance = 0;
    }


    public deposit(double amount) {
        this.balance = this.balance +  amount;
    }


    public withdraw(double amount) {
        this.balance = this.balance -  amount;
    }

    public void printStatement() {
        System.out.println("Owner's Name: " + this.name);
        System.out.println("Current Balance: " + this.balance);
    }
}
