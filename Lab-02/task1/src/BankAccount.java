/*

Part A

a. Every account needs to store 2 info:
   1. name (String type)
   2. balance (double type) //using double is a personal choice

b. 3 actions are:
    1. Deposit:
        Input: amount of deposit
        Change: deposits or adds money to balance
    2. Withdraw:
        Input: amount of withdrawal
        Change: withdraws or subtracts money from balance
    3. Print Statement:
        Input: N/A
        Output: shows the account name and the current balance

c. If we listen to the colleague, we will lose track of 200 customers
   We may store the balances or names in wrong index and get confused
   or we may accidentally (or maliciously) change the data

d. We will put the limit inside CLASS so that it's applicable
   for all the accounts that exist and the accounts being created in future

*/

public class BankAccount {
    private String name;
    private double balance;

    BankAccount(String n){
        name = n;
        balance = 0;
    }
    public void deposit(double amount){
        if(amount <= 0)
            System.out.println("We asked to ADD an amount -_-");
            // Couldn't see the line in the pdf where it asked for a error msg, I'm blind
            // actually I was reading from classroom pdf viewer which was blurry as hell
            // also my brain was fried :")
        else
            balance += amount;
    }
    public  void withdraw(double amount){
        if((balance-amount) < 0)
            System.out.println("\"Insufficient funds\"");
        else
            balance -= amount;
    }
    public void printStatement(){
        System.out.println("Owner's name: "+name);
        System.out.println("Balance: "+balance+" Taka");
    }
}
//