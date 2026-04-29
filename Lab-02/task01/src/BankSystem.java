/*
 * a.Every account needs an account holder name and balance.
 *  String name, double balance.
 * b.Deposit-Input: Amount ; Updates balance;
 *  Withdraw-Input: Amount ; Updates balance;
 *  Check balance-Input: Account name; Displays account balance;
 * c.
 *
 * d. Added in Withdraw method;
 * */

class BankAccount{
    private String ownerName;
    private double balance;

    public BankAccount(String name) {
        ownerName = name;
        balance = 0;
    }

    public void deposit(double amount){
        if(amount<=0){
            System.out.println("Invalid amount.");
            return;
        }
        balance+=amount;
    }

    public void withdraw(double amount){
        if(amount>balance){
            System.out.println("Insufficient balance.");
            return;
        }
        balance-=amount;
    }

    public void printStatement(){
        System.out.println("Owner's name: "+ownerName);
        System.out.println("Balance: "+balance);
    }

}

public class BankSystem{
    public static void main(String[] args){
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount charlie = new BankAccount("Charlie");

        alice.printStatement();
        alice.withdraw(1000);
        alice.deposit(2000);
        alice.printStatement();

        bob.deposit(0);
        bob.deposit(90.5);
        bob.printStatement();
        bob.withdraw(2000);
        bob.printStatement();

        charlie.printStatement();
        charlie.withdraw(20.1);
        charlie.deposit(3000);
        charlie.printStatement();
    }
}

/*
* a.BankAccount is a class. alice and bob are objects;
* b.only Alice's balance changes. The program knows this because the method deposit is called by reference "alice".
* c.
* d. Bob's balance will change. bob and alice now both refer to the same memory location so changing one by reference
*    will change the other as well;
*/

