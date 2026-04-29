 /*
a. owner name - String
    current balance - double
b. 1. Deposit money - input:deposited amount; output:
    2. Withdraw money - input: withdraw amount
    3.
c.
*/
public class BankAccount {
    String name;
    double balance;

    account(String name){
        this.name=name;
        this.balance=0;
    }

     int deposit(amount) {
        balance+=amount;
        if(amount<=0) {
            System.out.println("Error");
        }
        return;
     }

     int withdraw(amount) {
        balance-=amount;
        if(amount<=0) {
            System.out.println("Insufficient funds");
        }
        return;
     }

     void printStatement() {
         System.out.println(name);
         System.out.println(balance);
         return;
     }


}
