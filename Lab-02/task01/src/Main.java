public class Main{
public static void main(String[] args) {
    BankAccount ayesha = new BankAccount("ayesha");
    BankAccount labiba = new BankAccount("labiba");
    BankAccount zinti = new BankAccount("zinti");

    //ayesha transactions
    ayesha.deposit(1000);
    ayesha.withdraw(200);

    //labiba transactions
    labiba.deposit(500);
    labiba.withdraw(700);

    //zinti transactions
    zinti.deposit(-20);
    zinti.withdraw(100);

    //print accounts
    ayesha.printStatement();
    labiba.printStatement();
    zinti.printStatement();
}
}
/*
a. BankAccount is written once in your source file. alice and bob are two separate
things created from it. What is the word for what BankAccount is, and what is the
word for what alice and bob are?
ans: BankAccount is class; alice and bob are objects

b. When you call alice.deposit(500), which balance changes — Alice’s, Bob’s, or
both? How does the program know which one to update?
ans: only alice's balance is updated because alice refers to its own object

c. Draw a simple box diagram (in ASCII or words) showing what is in memory after
both lines above have run. Each box should show the field names and their values.
ans:alice:
         name:"Alice"
         balance:0

     bob:
         name:"Bob"
         balance:0

 d. If you wrote alice = bob; and then called alice.deposit(100), what would hap-
pen to Bob’s balance? Predict the result and explain why.
ans:both variables point to the same object
now
alice.deposit(100) but later it would update bob's balance and so it becomes 600

 */