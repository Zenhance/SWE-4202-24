/*
 * a.Every account needs a account holder name and balance.
 *  String name, long long balance.
 * b.Deposit- Input: Amount ; Updates balance;
 *  Withdraw-    Input: Amount ; Updates balance;
 *  Check balance-   Input: Account name; Displays account balance;
 * c.
 *
 * d. Added in Withdraw method;
 * */

class BankAccount{
    private String ownerName;
    private long balance;

    public BankAccount(String name) {
        ownerName = name;
        balance = 0;
    }

    public void deposit(long amount){
        if(amount<=0){
            System.out.println("Invalid amount.");
            return;
        }
        balance+=amount;
    }

    public void withdraw(long amount){
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
        bob.deposit(9000);
        bob.printStatement();
        bob.withdraw(2000);
        bob.printStatement();
    }
}

/*
* a.BankAccount is a class. alice and bob are objects;
* b.only alice's balance changes.
*
* d. Bob's balance will remain unchanged. alice==bob only copies bob's attributes to alice's.
*/

