/*
each account needs to store
- string ownerName
double balance
b. three actions one can perform:
  1.deposit(amount)
  input:double amount
  output: if valid then increases balance
  2.withdraw amount
  input: double amount
  output:if valid then decreases balance
  3.printStatement()
  input:none
  output:
  prints owner name and balance
c.

*/

class BankAccount{
    private String name;
    private double balance;

    public BankAccount(String Name){
        name= Name;
        balance = 0;
    }
    public void deposit (double amount){
        if(amount<=0){
            System.out.println("Invalid amount");
            return;
        }
        balance+=amount;

    }
    public void withdraw(double amount){
        balance-=amount;
    }
    public void printStatement(){
        System.out.println("Owner's name:");
        System.out.println("Owner's balance:");
    }
}
public class BankSystem{
    public static void main(String[] args) {
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount anna = new BankAccount("Anna");

        alice.deposit(500);
        alice.withdraw(300);

        bob.deposit(1200);
        bob.withdraw(1500);

        anna.deposit(400);
        anna.withdraw(100);

        alice.printStatement();
        bob.printStatement();
        anna.printStatement();
    }
}