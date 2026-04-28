
/*a. What information does every account need to store? List each piece and the type
you would use.
Ans: String Name, String credit history, int balance

b. What are the three actions a customer can perform on their account? For each one,
write down what it needs to know (inputs) and what it produces (output or change).
Ans: deposit(amount) == updates balance, withdraw(amount) == updates balance, printstatement() == prints user info

c. A colleague suggests storing all account balances in one big array in main, with a
separate array for owner names, just like Task 1 of Lab 1. What specific problem
would appear the moment you need to handle 200 customers?
Ans: There would be no inbuilt relation between hence increasing the amount of parameters.
So the program might need 400 arguments instead of 200 in method calling.
d. Suppose the bank later wants to add a transaction limit per day. Where exactly
would you add that — in main, or somewhere else? Why?
Ans: I would put that in BankAccount class.
*/

public class Main {
    public static void main(String[] args) {

        BankAccount arnob = new BankAccount("arnob");
        BankAccount moin = new BankAccount("moin");
        BankAccount sakep = new BankAccount("sakep");

        arnob.deposit(500);
        arnob.withdraw(100);
        arnob.printStatement();

        moin.withdraw(9000);
        moin.printStatement();

        sakep.deposit(-10);
        sakep.printStatement();
    }


}