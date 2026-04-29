public class BankAccount {

    private String name;
    private double balance;

    public BankAccount(String name) {

        this.name = name;
        this.balance = 0;


    }

public void deposit(double amount){
    if(amount<=0) {
    System.out.println("Error!Invalid amount to deposit");}
      else {
     balance+=amount;
} }

public void withdraw(double amount){
        if(amount>balance) {
            System.out.println("Error!Insufficient Funds");}
        else {
            balance-=amount;
        } }


public void printStatement(){

            System.out.println("Owner's Name= "+ name);
            System.out.println("Current balance= "+ balance);
        }


}