/*
a. What information does every account need to store? List each piece and the type
you would use.
ans:String name, double balance
b. What are the three actions a customer can perform on their account? For each one,
write down what it needs to know (inputs) and what it produces (output or change).
ans: deposit(amount)=updates balance;
     withdraw(amount)=updates balance;
     printstatement()=prints user info;
c. A colleague suggests storing all account balances in one big array in main, with a
separate array for owner names, just like Task 1 of Lab 1. What specific problem
would appear the moment you need to handle 200 customers?
ans: the amount of parameters used would increase which would be more time consuming.
d. Suppose the bank later wants to add a transaction limit per day. Where exactly
would you add that — in main, or somewhere else? Why?
ans:BankAccount class.


*/
public class Main {
    public static void main(String[] args) {

        BankAccount tahsin = new BankAccount("Tahsin");
        BankAccount moin = new BankAccount("Moin");
        BankAccount arnob= new BankAccount("Arnob");


        tahsin.deposit(1000000);
        tahsin.withdraw(50000);

        moin.deposit(124);
        moin.withdraw(3333);

        arnob.deposit(500000);
        arnob.withdraw(4000);

        tahsin.printStatement();
        moin.printStatement();
        arnob.printStatement();


    }
}
/*
a. BankAccount is written once in your source file. alice and bob are two separate
things created from it. What is the word for what BankAccount is, and what is the
word for what alice and bob are?
ans:Object=Alice+Bob.
class=BankAccount.

b. When you call alice.deposit(500), which balance changes — Alice’s, Bob’s, or
both? How does the program know which one to update?
ans: it would change alices balance. alice.method is used so only alice would be affected

c. Draw a simple box diagram (in ASCII or words) showing what is in memory after
both lines above have run. Each box should show the field names and their values.
ans:     alice:
                name   :"Alice"
                balance: 0

         bob:
                name    :"Bob"
                balance : 0

d. If you wrote alice = bob; and then called alice.deposit(100), what would hap-
pen to Bob’s balance? Predict the result and explain why.
ans:
it would update bobs balance.because bobs pointer got coppied into alices.bobs balance would be increased.

 */