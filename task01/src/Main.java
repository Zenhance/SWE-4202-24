/*
a. What information does every account need to store? List each piece and the type
you would use.
ans - the information needed would be, account holders name and balance.
name -> string
balance -> double

b. What are the three actions a customer can perform on their account? For each one,
write down what it needs to know (inputs) and what it produces (output or change).
ans - check balance , deposit money , withdraw money. check balance - name and it shows balance . deposit money -
name , money amount and it adds amount to the account. withdraw money - name , amount and it reduces amount.

c. A colleague suggests storing all account balances in one big array in main, with a
separate array for owner names, just like Task 1 of Lab 1. What specific problem
would appear the moment you need to handle 200 customers?
ans - The moment I need to handle 200 customers, it would be very difficult to manage all of their
//balance or add new customers of remove existing customer if I use just two different arrays to
//store the name and the balance.

d. Suppose the bank later wants to add a transaction limit per day. Where exactly
would you add that — in main, or somewhere else? Why?
ans - in the Bankaccount class. so , that every single person would have unique transaction limits.
*/

public class Main {

    static void main(String[] args) {
        BankAccount Rubayet = new BankAccount("Rubayet");
        BankAccount Safwan = new BankAccount("Safwan");

        Safwan.deposit(10000);
        Rubayet.deposit(20000);

        Safwan.withdraw(325);

        Rubayet.withdraw(124);
        
        
        Safwan.printStatement();
        Rubayet.printStatement();

    }
}

/*
(a) BankAccount is a class and alice and bob is an object of the BankAccount class.
(b) Only Alice's balance changes. because when we do alice.method, it knows that the
method should only change the attributes of the alice object.
(c)alice:
    name = "Alice"
    balance = 0.00

   bob:
     name = "Bob:
     balance = 0.00

(d) it would update bob's balance. because alice now points to the object bob.




 */
