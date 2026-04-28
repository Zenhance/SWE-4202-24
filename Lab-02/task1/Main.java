
//a.name and balance need to be stored.String name and double balance.
//b.it needs to create three function named void deposit(),void withdraw() and void print Statement, 
// void deposit-input(amount)output(amount added to balance), 
//void withdrow-input(amount),output(amount reduced from balance);
//void printStatement()-inout(nothing),output(will show the balance with name)
//c.it will take a lot of time to store 200 accounts in one big array.it will create hassle and may cause overflow.it will be better to create a class for accounts.
//d.if i want to add a transaction limit per day then i will create a function named int transactionLimit() to account class but i will call it in the main function after every transaction
class BankAccount{
  public String name;
  public double balance=0;
 BankAccount(String name){
this.name=name;
 }
 void deposit(double amount){
  balance+=amount;
  System.out.println("balance after deposit:  "+balance);
  }
 
 void withdraw(double amount){
  balance-=amount;
  System.out.println("balance after withdrawal:  "+balance);
 }
 void printStatement(){
  System.out.println("Name: "+name+ " Balance: "+balance);
 }
}

public class Main

 {
  public static void main(String[]args){
  BankAccount alice=new BankAccount("Alice");
  BankAccount bob=new BankAccount("Bob");
  BankAccount tasnova=new BankAccount("Tasnova");

  alice.deposit(500);
  alice.withdraw(500);
  alice.printStatement();
  bob.deposit(500);
  bob.withdraw(500);
  bob.printStatement();
  tasnova.deposit(500);
  tasnova.withdraw(500);
  tasnova.printStatement();

  //BankAccount is a class and alice and bob are object
  //when i call alice.deposit(500) Alice's balance changes,
  //
  }



}
