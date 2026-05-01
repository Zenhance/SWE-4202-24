


/* A. Every account needs to store Current Balance

B. One can perform three actions from their account:
1. Deposit
2. Withdraw
3. Check Balance

C. Storing all balance in a one big array will cause several problems.
Inputting and sorting it will be difficult. Maintaining will be another issue.
Editing data is also a hassle here.

D. I will add that in the class as an individual method.
 */


public static void main(String[] args) {

    BankAccount A1 = new BankAccount("Rafsan", 1000);
    BankAccount A2 = new BankAccount("Roodra", 500);
    BankAccount A3 = new BankAccount("Wasi", 793.56);

    A1.printstatement();
    A1.withdraw(500);
    A1.printstatement();

    A2.printstatement();
    A2.deposit(676.67);
    A2.printstatement();

    A3.printstatement();
    A3.withdraw(800);
    A3.printstatement();

}


/*
A. BankAccount is a class. Alice and Bob are objects.

B. The balance of Alice changes as the object Alice has its own address
which stores the value.

D. If we write Alice = Bob, the address of Alice and Bob will be same.
Thus, writing ALice.Deposit(100) will update the balance of Bob's balance.
 */
