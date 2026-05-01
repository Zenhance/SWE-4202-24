/*
Part A - Solution:

a.  Account name -> type String
    balance -> type double

b.  Three actions a customer can perform -
    1) Deposit
    input -> amount of money to add in customer's account.
    output -> if successful the balance increases.

    2) Withdraw
    input -> amount of money customer wants to take out of his/her account.
    output -> if successful the balance decreases.

    3) Bank Statement
    input -> nothing.
    output -> shows the account holder's name
    and the current balance in the account.

c. It will be difficult to match the            informations of the accounts as there       will be two separate arrays for one task.   We'll face difficulties to match the        corresponding indexes of two arrays and     operation on accounts will become           difficult.

d. I would add this feature in the BankAccount class. As it will be treated just like other methods.

*/

package Task1;

public class BankAccount {
    private String ownerName;
    private double balance;

    BankAccount(String ownerName) {
        this.ownerName = ownerName;
        this.balance = 0;
    }
}


