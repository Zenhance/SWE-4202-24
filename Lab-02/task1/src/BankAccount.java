public class BankAccount {

    private String name;
    private double balance;

    public BankAccount(string name) {

        this.name = name;
        this.balance = 0;


    }

public void deposit(double amount){
if(amount<=0) {
    System.out.println("Error!Invalid amount to deposit");}
else {
balance+=amount;
}








}