package Task1;

public class Main {
    public static void main(String[] args) {
        BankAccount alice = new BankAccount("Alice");
        BankAccount bob = new BankAccount("Bob");
        BankAccount mahdi = new BankAccount("Mahdi");

    alice.deposit(1000);
    bob.deposit(1499);
    mahdi.deposit(2000);

    alice.withdraw(450);
    bob.withdraw(1500);
    mahdi.withdraw(2000);

    alice.printStatement();
    bob.printStatement();
    mahdi.printStatement();
    }
}

/*

a. BankAccount is called Class and alice/bob/mahdi are Objects of the class.

b. It will change the balance of alice only as there is a separate memory for this object.

c. Below is the box diagram (in words) for the given question-

    Name: Alice
    Balance: 500
    Name: Bob
    Balance = 0

d. if I do alice=bob and call alice.deposit(100)
     Bob's balance will change , 100 will be added to his current balance.
*/




