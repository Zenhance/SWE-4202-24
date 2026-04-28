/*
  a.
  for every account the following information are needed to store:

    account holder's name -- String
    account number -- int
    account balance -- double
    account PIN -- int

    b. A customer can perform the following three options:
    1) Withdraw :
        input: PIN,Account number
        output: current balance
    2) Deposit :
        input : Account number , Date ,
        output: current balance
    3) Transfer:
        input : Receivers account number
        output:

    c. To handle 200 customers account balances in big array may occur a big problem .
            if somehow the account holder's name and account number mismatches than it would
            be hard for the coder to go through all the names and accounts number one by one in array.

   d. Transaction limit should should be added inside the BankAccount class,
because it is part of account behavior, not main.
    */

public class BankAccount {

    private String name;
    private double balance;


    public BankAccount(String name){
        this.name = name;
        ths.balance = 0.0;

        public void deposit(double amount) {
            if(amount<= 0){
                System.out.println("Invalud Amount");
                return;
            }
            balance += amount;

        }
        public void withdraw(double amount) {
            if(amount > balance){
                System.out.println("Insufficient fund");
                return;
            }
            balance -= amount;

    }
    public void printStatement(){
            System.out.println(name + ": " + balance);
        }
}
