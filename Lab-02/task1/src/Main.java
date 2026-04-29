
public class Main {
    public static void main(String[] args) {

        BankAccount alice = new BankAccount("Alice");
        BankAccount baba= new BankAccount("baba");
        BankAccount cee= new BankAccount("cee");
        alice.deposit(500);
        alice.withdraw(300);
        alice.withdraw(300);
        alice.deposit(0);
        alice.printStatement();
        baba.deposit(5000);
        baba.withdraw(300);
        baba.withdraw(3000);
        baba.deposit(10);
        baba.printStatement();
        cee.deposit(50);
        cee.withdraw(30);
        cee.withdraw(0);
        cee.deposit(1000);
        cee.printStatement();
    }
}
/*
    a.the word for  BankAccount is class and alice and bob are two "object" created of that class.

    b.for alice.deposit(500), only alice's balance changes. the program knows before each object has separate attributes and methods.
    When I call an object(alice), all methods used only change alice's attributes(balance).
    c.
   +--------------------------+     +--------------------------+
   |   BankAccount (alice)    |     |   BankAccount (bob)      |
   +--------------------------+     +--------------------------+
   | name: "Alice"            |     | name: "Bob"              |
   | balance: 0.0             |     | balance: 0.0             |
   +--------------------------+     +--------------------------+

    d.If I write alice=bob, then the objects will become same or refer to one object. and then calling alice.deposit(100), bob's balance will also increase,
     since alice and bob now refer to the same object.
*/