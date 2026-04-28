//a)
//account name-string
//account balance-double
//b)
//1)can deposit money
//input-the amount to be added
//output-the increased balance
//2)can withdraw money
//input-the amount to be decreased
//output-the decreased amount
//can check balance
//input-account name
//output-current balance
//c)
//hard to manage ,data inconsistency, difficult to extend
//d)
//transaction limit per day has to be added in the BankAccount Class
//because it is easier to maintain


public class BankAccount {
private String owners_name;
private double balance;
public BankAccount(String owners_name){
    this.owners_name=owners_name;
    this.balance=0.0;
}
public void deposit(double amount){
if(amount<=0){
    System.out.println("Invalid transaction");
}
balance+=amount;
}
public void withdraw(double amount){
    if(amount>balance){
        System.out.println("Insufficient funds");
    }
    balance-=amount;
}
public void printstatement(){
    System.out.println("Owner:"+owners_name+"-Balance:"+balance);
}

    static void main(String[] args) {
BankAccount a= new BankAccount("Harry");
BankAccount b=new BankAccount("Ron");
BankAccount c=new BankAccount("Harmaini");
a.deposit(1400);
a.withdraw(650);
b.deposit(960);
b.withdraw(156);
c.withdraw(520);
a.printstatement();
b.printstatement();
c.printstatement();
}

}
