/* Question Answer
(a) Every account need to store two information. The name of the account owner
and the current balance of the account.
Name => String
Balance => float

(b)Three actions that a customer can perform on their account are- DepositMoney, WithdrawMoney and CheckBalance.
DepositMoney => It needs to know the deposit amount and it generates the new balance.
WithdrawMoney => It needs to know the withdraw amount and it generates the new balance also it will
give error if the Withdraw amount is more than the balance.
CheckBalance => It returns the main account balance.

(c)The moment when I need to handle 200 customers is going to a very difficult task as I have to manage all of their
balance or add new customers of remove existing customer. If I can use two different arrays to
store the name and the balance.


(d) I would add the transaction limit in the BankAccount class so that the transaction
limit to each customer would be unique to them and not affect other people's transaction limits at all..

 */
public class Main {
    public static void main(String[] args) {
        BankAccount Bob = new BankAccount("Bob");
        BankAccount Mugdho = new BankAccount("Mugdho");
        BankAccount Alice = new BankAccount("Alice");

        Bob.deposit(20000);
        Mugdho.deposit(50000);
        Alice.deposit(1900);

        Bob.withdraw(18000);
        Mugdho.withdraw(41000);
        Alice.withdraw(1820);

        Bob.printstatement();
        Mugdho.printstatement();
        Alice.printstatement();
    }
}
/*
(a) BankAccount is a class and Alice and Bob is an object of the BankAccount class.
(b) Only Alice's balance changes.Because when we do alice.method, it knows that the
method should only change the attributes of the Alice object that is why Alice balance is changed.
(c)alice:
    name = "Alice"
    balance = 0.00

   bob:
     name = "Bob:
     balance = 0.00

(d) it would update Bob's balance,because Alice now points to the object bob.

*/
