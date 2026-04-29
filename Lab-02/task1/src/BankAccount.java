/* a) String account owner's name
float account balance

b) Deposit
input =account balance
output= account balance increase
Withdraw
input =account balance
output= account balance decrease
Checking balance
c) If two arrays are created , it'll become messy and it'll be difficult to
handle the data. The arrays will become lengthy.
d) We have to add the transaction limit per day in class.
 */

/* part-b*/
class Account {
    String name;
    double balance = 0;

    public class Account(String name) {
        this.name=name;
    }

    public class deposit(double amount) {
        if(balance<=0)
                System.out.print("Error!");
        else
        balance+=amount;
    }

    public class withdraw(double amount) {
        if(balance<0)
                System.out.print("Insufficient funds!");
        else
        balance-=amount;
    }

    public class printStatement(String name, double balance) {
        System.out.println("Owner's name"+name);
        System.out.println("Current balance:"+balance);
    }
}
public class BankAccount{
    public static void main(String args[]){
        Account acc1= new Account("Kallol");
        Account acc2= new Account("Sumi");
        Account acc3= new Account("Sabit");
        acc1.deposit(1000);
        acc1.withdraw(500);
        acc2.deposit(2000);
        acc2.withdraw(1000);
        acc3.deposit(500);
        acc3.withdraw(200);
        acc1.printStatement();
        acc2.printStatement();
        acc3.printStatement();

    }
}
/* part-c
a.The Account constructor is what we use to et up each account. When we make an acount it uses the owners name
and starts the balance at 0. In the part of the program we make two accounts: one for Alice(Kallol)
and one for Bob(Sumi). We give their names to the constructor so that both of their accounts start with no money
in them.Then we perform the following processes. Lastly, we show how much money is, in each
account now.
c. alice:
name:"Alice";
balance: 0;
bob:
name:"Bob";
balance: 0;
*/
