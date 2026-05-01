/*
a. Account holder's name, current balance. There will be 3 methods: deposit money, withdraw money and check balance.
    String name, float balance.
b. deposit money, withdraw money, check balance are the actions a customer can perform on their account.
    Deposit needs to know the amount of money user want to deposit. And produces the updated balance after deposits.
    Withdraw needs to the amount of money user want to take from his account. And produces updated balance after withdraw.
    Check balance takes no input but shows the current amount the account has.
c.
d. We need to add a counter inside deposit and withdraw money method's. Each time the user perform any of these it will count and check whether it crossed transaction limit or not.
*/


class BankAccount{
    String ownerName;
    float balance;
    BankAccount(String ownerName){
        balance = 0;
    }
    public void deposit(float amount){
        if(amount <= 0){
            System.out.println("Error");
            return;
        }
        balance += amount;
    }
    public void withdraw(float amount){
        if(balance - amount < 0){
            System.out.println("Insufficient funds");
            return;
        }
        else{
            balance -= amount;
        }
    }
    public void printStatement(){
        System.out.println(ownerName);
        System.out.println(balance);
    }
}


public class Main {
    public static void main(String[] args) {
//        System.out.println("Hello world!");
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount Mahdi = new BankAccount("Mahdi");
        Mahdi.deposit(5000);
        bob.printStatement();
        alice.deposit(1999);
        alice.withdraw(500);
        Mahdi.printStatement();
        alice.printStatement();
    }
}