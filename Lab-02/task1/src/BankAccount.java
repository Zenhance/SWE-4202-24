 /*
a. owner name - String
    current balance - double
b. 1. Deposit money - input:deposited amount; output: add to current balance.
    2. Withdraw money - input: withdraw amount; output: subtract from current balance;
     3. Check balance
c. It is difficult to handle 200 customers account in one big array and it will show error;

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
        if(amount<0) {
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

/*
a. Here BankAccount is a class alice,bob,raida are objects of the class.

 */