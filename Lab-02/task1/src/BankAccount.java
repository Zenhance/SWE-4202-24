/* PART - A


a. Every account needs to store:
owner's name: string
balance: double

b. the three actions are:
deposit(amount):input is amount, adds it to balance if positive
withdraw(amount): input is amount, substract is if enough funds are presenrt
printstatement():no input, prints owner name and balance

c. if balances and names were stored in arrays, handling 200 customers would become very hard.
Because we would need to keep matching indexes. A small mistake would connect
different accounts with each other

d.A transaction limit should be added inside the bankaccount class, not in main, becaue every account should
control its own rules and data


 */

/*     PART B     */


public class BankAccount {
    private String owner;
    private double balance;

    public BankAccount(String owner){

        this.owner = owner;
        this.balance = 0;

    }
    public void deposit(double amount){
        if(amount <= 0 ){
            System.out.println("Invalid Ammount");
            return;
        }
        balance+=amount;
    }

    public void withdraw(double amount){
        if(amount <= 0){
            System.out.println("Invalid Amount");
            return;
        }
        balance-=amount;
    }

    public void printstatement(){
        System.out.println("Name: "+owner);
        System.out.println("Balance: "+balance);
    }

}



/*     PART C     */
/*
A. BankAccount is a class.
alice and bob are objects.

B. It changes only Alice's balance.
Each variable refers to a seperate objectin the memory.

C.
Alice:
[BankAccount object]
ownerName="Alice"
balance=0

Bob:
[BankAccount object]
ownerNAme="Bob"
balance=0

D.
IF we write alice=bob;
then both variable refer to the same object.
so:
alice.deposit(100);
will also change bob's balance.








 */



