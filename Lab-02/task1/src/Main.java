//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
/*
 a. I will store name with type string and balance with type double.
    Also the arguments in the method should be double as well.
 b. the method we need is
    Deposit and Withdraw where both will have argument amount of type double .
    Deposit will increase the balance by amount and Withdraw will decrease it by amount.
    Another method printstatement should only print the account holders name and balance.
 c. we will be required to write tremendous number of lines of codes in order to handle 200 peoples data. also human error may occur while handling two arrays.
 d. Daily Transaction Limit should be added into class not in the main. Because each account should have its own limit count . Putting it in the main will accumulate the limit for different accounts together.
 */


import java.util.Scanner;



public class Main{

    static class BankAccount{
        private String name;
        private double balance=0 ;

        BankAccount(String name){
            this.name=name;


        }
        void deposit(double amount){
            balance+=amount;

        }
        void withdraw(double amount){
            if((balance-amount)<=0){
                System.out.println("Insufficient balance");
            }
            else{
                balance-=amount;
            }

        }
        void printStatement(){
            System.out.println("Account Holder: "+ name);
            System.out.println("Balance: "+ balance);

        }
    }

    public static void main(String[]args){
        BankAccount b1=new BankAccount("Rakin");
        BankAccount b2=new BankAccount("Zunied");
        BankAccount b3=new BankAccount("Sakib");


        b1.deposit(124.14);
        b1.withdraw(120);
        b1.printStatement();

        b2.withdraw(535);
        b2.deposit(12427);
        b2.printStatement();


        b3.deposit(1222);
        b3.withdraw(525);

        b3.printStatement();

    }
}


        /*
        a. alice and bob are the instances of the cass BankAccount
        b. only the balance of alice changes. alice.deposit(500), here specifies that only the balance of alice should change
        c. BankAccount -

                b1-     name    - Rakin
                        balance -  4.14
                b2-     name    - Zunied
                        balance - 12427.0
                b3-     name    - Sakib
                        balance - 697.0

        d . If I assign alice=bob then both variable points to the same object in memory. Therefore, calling alice.deposit(1000) will also change the balance value for the instance bob.

         */